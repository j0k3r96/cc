/**
 * Knoten, der einen Planeten darstellt
 * @author Leo und Lovis
 */
public class Node {

    private int id;
    private double distance;
    private Node prev;

    /**
     * Konstruktor zum Erstellen eines Knotens
     * @param id Knoten-ID
     * @param distance Distanz vom Startpunkt zu diesem Knoten
     * @param prev vorheriger Knoten auf der aktuellen Route
     */
    public Node(int id, double distance, Node prev) {
        this.id = id;
        this.distance = distance;
        this.prev = prev;
    }

    public int getId() {
        return id;
    }

    public double getDistance() {
        return distance;
    }

    public Node getPrev() {
        return prev;
    }


    @Override
    public String toString() {
        return "" + id;
    }
}
