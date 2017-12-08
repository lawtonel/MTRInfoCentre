public class LinearNode<Station>  {
    private LinearNode<Station> next;
    private LinearNode<Station> previous;
    private Station station;

    public LinearNode(Station station) {
        next = null;
        previous = null;
        this.station = station;
    }

    public LinearNode<Station> getNext() {
        return next;
    }

    public LinearNode<Station> getPrevious() { return previous; }

    public void setNext (LinearNode<Station> node)
    {
        next = node;
    }

    public void setPrevious(LinearNode<Station> node) { previous = node; }

    public Station getStation() {
        return station;
    }
}
