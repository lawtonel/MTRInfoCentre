/**The LinkedList class models nodes that are connected to each other via a singly linked list.
 * This is then used in the Line class to model stations on a line in the MTR Network**/

public class LinkedList<Station>  {
    private LinearNode<Station> first;
    private LinearNode<Station> last;
    private LinearNode<Station> current;


    // Creates initial linked list with one node
    public LinkedList(LinearNode<Station> first) {
        this.first = first;
        this.last = first;
        this.current = first;
    }

    public LinearNode<Station> getFirst() {
        return first;
    }

    public void addStation(Station station) {
        LinearNode<Station> newStation = new LinearNode<>(station);
        last.setNext(newStation);
        last = newStation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        LinearNode<Station> current = first;
        while (current != null) {
            sb.append(current.getStation().toString());
            if (current.getNext() != null) {
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
