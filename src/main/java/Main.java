/**
 * Hauptklasse, in der das Programm ausgefuehrt wird.
 *
 * @author Leo und Lovis
 */
public class Main {

    //Startknoten der Routenberechnung
    private static final String START = "Erde";
    //Endknoten der Routenberechnung
    private static final String DEST = "b3-r7-r4nd7";


    public static void main(String[] args) {
        JsonData data = new JsonData(START, DEST);
        Dijkstra dj = new Dijkstra(data);

        System.out.println(dj.printRoute(dj.findBestRoute(), ""));

    }


}
