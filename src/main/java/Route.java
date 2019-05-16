public class Route {
    private int source;
    private int target;
    private double cost;

    public Route(int source, int target, double cost) {
        this.source = source;
        this.target = target;
        this.cost = cost;
    }

    public int getSource() {
        return source;
    }

    public int getTarget() {
        return target;
    }

    public double getCost() {
        return cost;
    }


    @Override
    public String toString() {
        return "[" + source + "---" + cost + "--->" + target + "]";
    }
}
