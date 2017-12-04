public class ControlCentre implements Controller {
    private Network network;

    public ControlCentre() {
        network = new Network();
        TUI view = new TUI(this);
    }

    @Override
    public String listAllTermini() {
        return null;
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
        return null;
    }

    @Override
    public String showPathBetween(String stationA, String stationB) {
        return null;
    }

    public static void main(String[] args) {
        //Create ControlCentre
        Controller controller = new ControlCentre();
    }
}
