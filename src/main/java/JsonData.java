import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonData {

    private final String START = "Erde";
    private final String DEST = "b3-r7-r4nd7";

    private int idxDest = - 1;
    private int idxStart = -1;
    private Map<Integer, ArrayList<Route>> possRoutes = new HashMap<Integer, ArrayList<Route>>();


    public JsonData() {
        String resourceName = "/generatedGraph.json";
        InputStream is = JsonData.class.getResourceAsStream(resourceName);
        JSONTokener tokener = new JSONTokener(is);

        JSONObject data = new JSONObject(tokener);
        JSONArray nodes = data.getJSONArray("nodes");
        JSONArray edges = data.getJSONArray("edges");
        for (int i = 0; i < nodes.length(); i++) {
            String pointer = "/"+i+"/label";
            if (idxStart == -1) {
                idxStart = ((String) nodes.query(pointer)).equals(START) ? i : -1;
            }
            if (idxDest == -1) {
                idxDest = ((String) nodes.query(pointer)).equals(DEST) ? i : -1;
            }
        }

        for (int i = 0; i < edges.length(); i++) {
            String ptrSrc = "/"+i+"/source";
            String ptrTrgt ="/"+i+"/target";
            String ptrCost ="/"+i+"/cost";
            Integer src = (Integer)edges.query(ptrSrc);
            ArrayList<Route> al = possRoutes.containsKey(src) ? possRoutes.get(src) : new ArrayList<Route>();
            al.add(new Route(src, (Integer)edges.query(ptrTrgt), (Double) edges.query(ptrCost)));
            possRoutes.put(src, al);

            //other direction
            src = (Integer)edges.query(ptrTrgt);
            al = possRoutes.containsKey(src) ? possRoutes.get(src) : new ArrayList<Route>();
            al.add(new Route(src, (Integer)edges.query(ptrSrc), (Double) edges.query(ptrCost)));
            possRoutes.put(src, al);
        }
    }

    public int getIdxDest() {
        return idxDest;
    }

    public void setIdxDest(int idxDest) {
        this.idxDest = idxDest;
    }

    public int getIdxStart() {
        return idxStart;
    }

    public void setIdxStart(int idxStart) {
        this.idxStart = idxStart;
    }

    public Map<Integer, ArrayList<Route>> getPossRoutes() {
        return possRoutes;
    }

    public void setPossRoutes(Map<Integer, ArrayList<Route>> possRoutes) {
        this.possRoutes = possRoutes;
    }
}

