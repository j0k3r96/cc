/**
 * Hauptklasse, in der das Programm ausgefuehrt wird.
 *
 * Ergebnis:
 *
 * Erde ---0.04060214221510905---> node_810 ---0.20340603534177526--->
 * node_595 ---0.836544511606854---> node_132 ---1.4699063731635515--->
 * node_519 ---2.232482414734185---> node_71 ---2.90669820409565--->
 * node_432 ---2.995687895999458---> b3-r7-r4nd7
 *
 * Kommulierte distanz zwischen den Planeten
 *
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
