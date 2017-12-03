public class ControlCentre implements Controller {
    private Network network;
    private TUI view;

    public ControlCentre() {
        view = new TUI(this);
        Network network = new Network();
    }

    @Override
    public String listAllTermini() {
        return null;
    }

    @Override
    public String listStationsInLine(String line) {
        return null;
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
