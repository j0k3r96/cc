public class Main {

    public static void main(String[] args) {
        JsonData data = new JsonData();
        Dijkstra dj = new Dijkstra(data.getPossRoutes(), data.getIdxStart(), data.getIdxDest());
        System.out.println(dj.printRoute(dj.findBestRoute(), ""));

    }


}
