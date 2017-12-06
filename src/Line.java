import java.util.List;
import java.util.Set;

public class Line {
    private final String name;
    private final LinkedList<Station> stations;

    public Line(String name, LinkedList<Station> stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public LinkedList<Station> getStations() {
        return stations;
    }

    public String allStationsToString() {
       return "The stations on the " + getName() + " are: " + stations.toString();
    }
}
