public class LinkedList<Station> {
    private LinearNode<Station> first;
    private LinearNode<Station> last;


    // Creates initial linked list with one node
    public LinkedList(LinearNode<Station> first) {
        this.first = first;
        this.last = first;
    }

    public LinearNode<Station> getFirst() {
        return first;
    }

    public LinearNode<Station> getLast() {
        return last;
    }

    public void addStation(Station station) {
        LinearNode<Station> newStation = new LinearNode<>(station);
        newStation.setNext(last);
        last = newStation;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        LinearNode<Station> current = first;
        while (current != null) {
            sb.append(current.getStation().toString());
            if (current.getStation() != null) {
                sb.append(", ");
                current = current.getNext();
            } else {
                sb.append('.');
                break;
            }
        }
        return sb.toString();
    }
}
