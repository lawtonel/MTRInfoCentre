/**The Line class models an individual line of the MTR network.  Stations on the line are modelled as a LinkedList**/

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
