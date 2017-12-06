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

    public Network() {

        // Set up file reader, to access CSV file listing lines and associated stations
        String csvFile = "MTRsystem_partial.csv";
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
                Station initial = new Station(stationsStr[1]);
                LinkedList<Station> stations = new LinkedList<>(new LinearNode<>(initial));

                // Add to list of termini
                allTermini.add(initial);

                for(int i = 2; i < stationsStr.length; i++) {
                    Station station = new Station(stationsStr[i]);
                    stations.addStation(station);
                    if(i == stationsStr.length-1) {
                        allTermini.add(station);
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
}
