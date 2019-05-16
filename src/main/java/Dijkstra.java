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
     * Finds
     *
     * @return
     */
    public Node findBestRoute() {
        return step(root);
    }

    /**
     * TODO
     *
     * @param node
     * @return
     */
    private Node step(Node node) {
        while (node.getId() != data.getIdxDest()) {
            ArrayList<Node> nodes = new ArrayList<Node>();
            if (data.getPossRoutes().get(node.getId()) != null) {
                for (Route r : data.getPossRoutes().get(node.getId())) {
                    if(!visited.contains(r.getTarget())) {
                        Node tr = new Node(r.getTarget(), node.getDistance() + r.getCost(), node);
                        nodes.add(tr);
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
     * TODO
     *
     * @return
     */
    private Node findShortest() {
        Node min = null;
        for (Node tn : leaves) {
            if (min == null || tn.getDistance() < min.getDistance()) {
                min = tn;
            }
        }
        return min;
    }

    /**
     * TODO
     *
     * @param tn
     * @param s
     * @return
     */
    public String printRoute(Node tn, String s) {
        if (tn.getId() != root.getId()) {
            s = " ---" + tn.getDistance() + "---> " + data.getNodeList().get(tn.getId()) + s;
            return printRoute(tn.getPrev(), s);
        }
        return data.getNodeList().get(root.getId()) + s;
    }
}
