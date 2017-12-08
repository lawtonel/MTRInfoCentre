import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Network {
    private final Map<String, Line> linesByName;
    private final ArrayList<Station> allTermini;
    private final ArrayList<Station> allStations;

    public Network() {

        // Set up file reader, to access CSV file listing lines and associated stations
        String csvFile = "assets/MTRsystem_partial.csv";
        FileReader fr = null;
        try {
            fr = new FileReader(csvFile);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        // Set up buffered reader and read each line from the CSV file
        assert fr != null;
        BufferedReader br = new BufferedReader(fr);

        // Create an array list to store termini of all 12 lines
        // Initialise capacity at 24 to avoid extend capacity operation
        allTermini = new ArrayList<>(24);

        // Create an array list to store all stations and all their respective lines
        allStations = new ArrayList<>();

        // Create map to store line name (key) and line object (value)
        linesByName = new HashMap<>();

        try {
            String result;
            while((result = br.readLine()) != null) {
                // Read from file and split each line around comma
                String[] stationsStr = result.split(",");

                // Get line name
                String lineName = stationsStr[0];

                // Create new linked list of stations on that line, initialised with first node
                Station initial = new Station(stationsStr[1], lineName);

                Station initialToAdd = initial;

                // Add to all stations
                if(allStations.contains(initial)){
                    for(Station station: allStations){
                        if(station.isStation(stationsStr[1])){
                            initialToAdd = station;
                            station.addLine(lineName);
                        }
                    }
                } else {
                    allStations.add(initial);
                }

                // Add to list of termini
                allTermini.add(initialToAdd);



                LinkedList<Station> stations = new LinkedList<>(new LinearNode<>(initialToAdd));


                for(int i = 2; i < stationsStr.length; i++) {
                    Station station = new Station(stationsStr[i], lineName);

                    Station stationForLine = station;

                    if(allStations.contains(station)){
                        for(Station stationSingle: allStations){
                            if(stationSingle.isStation(stationsStr[i])){
                                stationForLine = stationSingle;
                                stationSingle.addLine(lineName);
                            }
                        }
                    } else {
                        allStations.add(stationForLine);
                    }

                    stations.addStation(stationForLine);
                    if(i == stationsStr.length-1) {
                        allTermini.add(stationForLine);
                    }
                }

                // Create new Line object and put into map
                Line newLine = new Line(lineName, stations);
                linesByName.put(lineName, newLine);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Map<String, Line> getLinesByName() {
        return linesByName;
    }

    public ArrayList<Station> getAllTermini() {
        return allTermini;
    }

    public String connectedLines(String line) {
        ArrayList<String> connectedLines = new ArrayList<>();
        for(Map.Entry<String, Line> lineSingle: linesByName.entrySet()){
            if(lineSingle.getKey().equals(line)){
                LinearNode<Station> current = lineSingle.getValue().getStations().getFirst();
                while(current != null) {
                    if(current.getStation().getLine().size() == 1){
                        continue;
                    }
                    ArrayList<String> lines = current.getStation().getLine();
                    lines.remove(line);
                    connectedLines.addAll(lines);
                    current = current.getNext();
                }
            }
        }
        return connectedLines.toString();
    }

    public String pathFinder(String location, String destination) {

        return null;
    }

}
