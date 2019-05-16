import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class Dijkstra {

    Map<Integer, ArrayList<Route>> routes;
    TreeNode root;
    int dest;
    ArrayList<TreeNode> leaves = new ArrayList<TreeNode>();
    HashSet<Integer> visited = new HashSet<Integer>();

    public Dijkstra(Map<Integer, ArrayList<Route>> routes, int start, int dest) {
        this.routes = routes;
        this.dest = dest;
        this.root = new TreeNode(start, 0, null);
    }

    public TreeNode findBestRoute() {
        return step(root);
    }

    private TreeNode step(TreeNode node) {
        while (node.getId() != dest) {
            ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
            if (routes.get(node.getId()) != null) {
                for (Route r : routes.get(node.getId())) {
                    if(!visited.contains(r.getTarget())) {
                        TreeNode tr = new TreeNode(r.getTarget(), node.getDistance() + r.getCost(), node);
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

    private TreeNode findShortest() {
        TreeNode min = null;
        for (TreeNode tn : leaves) {
            if (min == null || tn.getDistance() < min.getDistance()) {
                min = tn;
            }
        }
        return min;
    }

    public String printRoute(TreeNode tn, String s) {
        if (tn.getId() != root.getId()) {
            s = " ---" + tn.getDistance() + "---> " +tn.toString() + s;
            return printRoute(tn.getPrev(), s);
        }
        return root.getId() + s;
    }
}
