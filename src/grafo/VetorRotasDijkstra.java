package grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VetorRotasDijkstra {

    HashMap<String, ColunaVetorDijkstra> matriz = new HashMap<>();

    public VetorRotasDijkstra(ArrayList<Vertice> listaAdj) {

        for (Vertice v : listaAdj) {
            matriz.put(v.getId(), new ColunaVetorDijkstra());
            ColunaVetorDijkstra c = matriz.get(v.getId());
            c.distancia = v.getD();
            c.pai = v.getPi();
        }

    }

    public int getDistancia(String id) {
        return matriz.get(id).distancia;
    }

    public String getPai(String id) {
        return matriz.get(id).pai;
    }

    class ColunaVetorDijkstra {
        int distancia = 0;
        String pai = "";
        boolean processado = false;
    }

    @Override
    public String toString() {


        StringBuilder str = new StringBuilder();

        // Obtém a lista de IDs dos vértices no HashMap
        ArrayList<String> ids = new ArrayList<>(matriz.keySet());

        // Cria a primeira linha da matriz com os IDs dos vértices
        str.append(String.format("%-3s", " "));
        for (String id : ids) {
            str.append(String.format("%-8s", id));
        }
        str.append("\n");
        str.append(String.format("%-3s", "d"));
        for (Map.Entry<String, ColunaVetorDijkstra> c: matriz.entrySet()) {
            str.append(String.format("%-8s", c.getValue().distancia));
        }
        
        str.append("\n");
        str.append(String.format("%-3s", "pi"));
        for (Map.Entry<String, ColunaVetorDijkstra> c: matriz.entrySet()) {
            str.append(String.format("%-8s", c.getValue().pai));
        }

        return str.toString();
    }

}
