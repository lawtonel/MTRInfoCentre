import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class Network {
    private Set<Line> lines;

    public Network() {

        // Set up file reader, to access CSV file listing lines and associated stations
        String csvFile = "assets/MTRsystem_partial.csv";
        FileReader fr = null;
        try {
            fr = new FileReader(csvFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Set up buffered reader and read each line from the CSV file
        BufferedReader br = new BufferedReader(fr);
        String line;

        try {
            while((line = br.readLine()) != null) {
                // Create new linked list of stations on a particular line
                String[] stationsStr = line.split(",");
                LinkedList<Station> stations = new LinkedList<>(new LinearNode<>(new Station(stationsStr[1])));
                for(int i = 2; i < stationsStr.length; i++) {
                    Station station = new Station(stationsStr[i]);
                    stations.addStation(station);
                }

                // Create new Line object and put into set
                Line newLine = new Line(stationsStr[0], stations);
                lines.add(newLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
