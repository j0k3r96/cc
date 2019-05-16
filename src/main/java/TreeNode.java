import java.util.ArrayList;

public class TreeNode {

    private int id;
    private double distance;
    private TreeNode prev;
    private boolean visited = false;
    private ArrayList<TreeNode> children = new ArrayList<TreeNode>();

    public TreeNode(int id, double distance, TreeNode prev) {
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

    public TreeNode getPrev() {
        return prev;
    }

    public ArrayList<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<TreeNode> children) {
        this.children = children;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }


    @Override
    public String toString() {
        return "" + id;
    }
}
