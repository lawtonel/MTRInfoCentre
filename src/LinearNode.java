public class LinearNode<Station>  {
    private LinearNode<Station> next;
    private Station station;

    public LinearNode(Station station) {
        next = null;
        this.station = station;
    }

    public LinearNode<Station> getNext() {
        return next;
    }

    public void setNext (LinearNode<Station> node) {
        next = node;
    }

    public Station getStation() {
        return station;
    }
}
