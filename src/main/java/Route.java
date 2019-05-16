/**
 * Route von einem Planeten zum anderen mit festen Kosten fuer den WEg
 * @author Leo und Lovis
 */
public class Route {
    private int source;
    private int target;
    private double cost;

    /**
     * Konstruktor zum Erstellen einer Route
     * @param source Startpunkt
     * @param target Ziel
     * @param cost Wegkosten
     */
    public Route(int source, int target, double cost) {
        this.source = source;
        this.target = target;
        this.cost = cost;
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
