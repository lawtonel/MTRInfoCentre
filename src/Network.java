import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Network {
    private Map<String, Line> linesByName;

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
        BufferedReader br = new BufferedReader(fr);

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
                LinkedList<Station> stations = new LinkedList<>(new LinearNode<>(new Station(stationsStr[1])));

                for(int i = 2; i < stationsStr.length; i++) {
                    Station station = new Station(stationsStr[i]);
                    stations.addStation(station);
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
}
