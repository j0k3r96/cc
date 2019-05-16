import java.util.ArrayList;
import java.util.HashSet;

/**
 * Klasse zur Berechnung der kuerzesten Route zwischen zwei Knoten,
 * angelehnt an den Algorithmus von Dijkstra
 * @author Leo und Lovis
 */
public class Dijkstra {

    JsonData data;

    Node root;
    ArrayList<Node> leaves = new ArrayList<Node>();
    HashSet<Integer> visited = new HashSet<Integer>();

    /**
     * Konstruktor zur Uebergabe der wichtigsten Parameter
     *
     * @param data die verarbeite JSON-Informationen
     */
    public Dijkstra(JsonData data) {
        this.data = data;
        this.root = new Node(data.getIdxStart(), 0, null);
    }

    /**
     * Fuehrt die Routenberechnung aus und gibt die Ziel-Node zurueck.
     * Anhand der Node kann man den Pfad zurueck verfolgen.
     *
     * @return ZielNode
     */
    public Node findBestRoute() {
        return step(root);
    }

    /**
     * Fuehrt den Dijkstra-Algorithmus aus
     *
     * @param node der Wurzelknoten
     * @return den Zielknoten, mit Angabe der Laenge des kuerzesten Weges und der Knoten,
     *          die auf dem Weg durchlaufen wurden.
     */
    private Node step(Node node) {
        while (node != null && node.getId() != data.getIdxDest()) {
            if (data.getPossRoutes().get(node.getId()) != null) {
                for (Route r : data.getPossRoutes().get(node.getId())) {
                    if(!visited.contains(r.getTarget())) {
                        Node tr = new Node(r.getTarget(), node.getDistance() + r.getCost(), node);
                        leaves.add(tr);
                    }
                }
            }
            leaves.remove(node);
            visited.add(node.getId());
            node = findShortest();
        }
        return node;
    }

    /**
     * Findet von allen offenen Routenpfaden den, der dem Startpunkt am naechsten ist
     *
     * @return den Knoten
     */
    private Node findShortest() {
        Node min = null;
        if (leaves.size() > 0) {
            for (Node tn : leaves) {
                if (min == null || tn.getDistance() < min.getDistance()) {
                    min = tn;
                }
            }
        }
        return min;
    }

    /**
     * Gibt die im Knoten uebergebene Route formatiert aus
     *
     * @param tn der uebergebene Knoten
     * @param s String zum rekursiven Aufruf
     * @return Route
     */
    public String printRoute(Node tn, String s) {
        if (tn != null) {
            if (tn.getId() != root.getId()) {
                s = " ---" + tn.getDistance() + "---> " + data.getNodeList().get(tn.getId()) + s;
                return printRoute(tn.getPrev(), s);
            }
            return data.getNodeList().get(root.getId()) + s;
        } else {
            return "Keine gueltige Route gefunden!";
        }
    }
}
