public class ControlCentre implements Controller {
    private final Network network;

    public ControlCentre() {
        network = new Network();
        new TUI(this);
    }

    @Override
    public String listAllTermini() {
        StringBuilder result = new StringBuilder("Stations which are also termini on the MTR network are: \n");
        for (Station terminus : network.getAllTermini()) {
            result.append(terminus.toString()).append("\n");
        }
        return result.toString();
    }

    @Override
    public String listStationsInLine(String line) {
        if(network.getLinesByName().containsKey(line)){
            Line requestedLine = network.getLinesByName().get(line);
            return requestedLine.allStationsToString();
        } else {
            return null;
        }
    }

    @Override
    public String listAllDirectlyConnectedLines(String line) {
        return network.connectedLines(line);
    }

    @Override
    public String showPathBetween(String stationA, String stationB) {
        return network.getPathToStation(stationA, stationB);
    }

    public static void main(String[] args) {
        //Create ControlCentre
        Controller controller = new ControlCentre();
    }
}
