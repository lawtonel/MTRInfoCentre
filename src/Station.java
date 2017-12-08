import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**Models an underground station that exists on the MTR network**/

public class Station {
    private String name;
    private ArrayList<String> lines;
    private Set<Station> connectedStations;

    public Station(String name, String line) {
        this.name = name;
        lines = new ArrayList<>();
        this.lines.add(line);
        connectedStations = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getLine() {
        return lines;
    }

    public boolean isStation(String name) {
        return this.name.equals(name);
    }

    public boolean isOnLine(String lineToCheck) {
        for (String line: lines) {
            if(line.equals(lineToCheck)){
                return true;
            }
        }
        return false;
    }

    public boolean isStationLink(){
        return lines.size() > 1;
    }

    public void addLine(String line) {
        this.lines.add(line);
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }

    public Set<Station> getConnectedStations() {
        return connectedStations;
    }

    public void addConnection(Station station) {
        connectedStations.add(station);
    }
}
