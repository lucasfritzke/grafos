package grafo;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {

    private ArrayList<Vertice> listaAdj = new ArrayList<>();

    public Dijkstra(ArrayList<Vertice> listaAdj) {
        this.listaAdj = listaAdj;
    }

    public ArrayList<Vertice> getListaAdj() {
        return listaAdj;
    }

    public void setListaAdj(ArrayList<Vertice> listaAdj) {
        this.listaAdj = listaAdj;
    }

    public String[][] calcularRota(String id){

        return null;

    }

    public Vertice getVertice(String id) {
        
        for (Vertice v : listaAdj) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public String[][] dijkstra(String id) {
        Vertice v = this.getVertice(id);
        if (v != null) {
            this.initializaSingleSource(id);
        } else {
            return null;
        }
        
        ArrayList<Vertice> s = new ArrayList<>();
        PriorityQueue<Vertice> q = new PriorityQueue<>(new VerticeDijkstraComparator());
        for (Vertice vertice : listaAdj) {
            q.add(vertice);
        }

        while (!q.isEmpty()) {
            Vertice u = q.poll();
            s.add(u);
            ArrayList<Aresta> listaArestas = u.getListaArestas();
            PriorityQueue<Aresta> filaArestas = new PriorityQueue<>(new ArestaComparator());
            for (Aresta aresta : listaArestas) {
                filaArestas.add(aresta);
            }
            while (!filaArestas.isEmpty()) {
                Aresta aresta = filaArestas.poll();
                Vertice adj = aresta.getVerticeAdj();
                
                this.relax(u, adj, aresta.getCusto(), q);
                
            }

        }
        return null;

    }

    private void initializaSingleSource(String id) {

        for (Vertice v : listaAdj) {
            v.setD(Integer.MAX_VALUE);
            v.setPi("nill");

            if (v.getId().equals(id)) {
                v.setD(0);
                v.setPi("nill");
            }
        }

    }

    private void relax(Vertice u, Vertice verticeAdj, int custo, PriorityQueue<Vertice> q) {

        if (verticeAdj.getD() > u.getD() + custo) {
            q.remove(verticeAdj);
            verticeAdj.setD(u.getD() + custo);
            verticeAdj.setPi(u.getId());
            q.add(verticeAdj);
        }
    }

    public String[][] vetorRoteamento(String id){
        this.dijkstra(id);
        String[][] st = new String[listaAdj.size()][6];

        for (int i = 0; i < listaAdj.size(); i++) {
            Vertice v = listaAdj.get(i);
            st[i][0] = v.getId();
            st[i][1] = Integer.toString(v.getD());
            st[i][2] = v.getPi();
            st[i][3] = " ";
            st[i][4] = "x";
            st[i][5] = id;
        }

        return st;

    }

    public String vetorRoteamentoToString(String id){
        StringBuilder str = new StringBuilder();
        int size = listaAdj.size();
        String[][] st = this.vetorRoteamento(id);
        // Cabeçalhos
        str.append(String.format("%-8s", "VERTICE"));
        for (int i = 0; i < size; i++) {
            str.append(String.format("%-8s", st[i][0]));
        }
        str.append("\n");
        str.append(String.format("%-8s", "d"));
        for (int i = 0; i < size; i++) {
            str.append(String.format("%-8s", st[i][1]));
        }
        str.append("\n");
        str.append(String.format("%-8s", "Pi"));
        for (int i = 0; i < size; i++) {
            str.append(String.format("%-8s", st[i][2]));
        }
        str.append("\n");
        str.append(String.format("%-8s", "q"));
        for (int i = 0; i < size; i++) {
            str.append(String.format("%-8s", st[i][3]));
        }
        str.append("\n");
        str.append(String.format("%-8s", "s"));
        for (int i = 0; i < size; i++) {
            str.append(String.format("%-8s", st[i][4]));
        }
        return str.toString();

    }

    public String vetorRoteamentoToString(String[][] li){
        StringBuilder str = new StringBuilder();
        int size = li.length;
        String[][] st = li;
        // Cabeçalhos
        str.append(String.format("%-8s", "VERTICE"));
        for (int i = 0; i < size; i++) {
            str.append(String.format("%-8s", st[i][0]));
        }
        str.append("\n");
        str.append(String.format("%-8s", "d"));
        for (int i = 0; i < size; i++) {
            str.append(String.format("%-8s", st[i][1]));
        }
        str.append("\n");
        str.append(String.format("%-8s", "Pi"));
        for (int i = 0; i < size; i++) {
            str.append(String.format("%-8s", st[i][2]));
        }
        str.append("\n");
        str.append(String.format("%-8s", "q"));
        for (int i = 0; i < size; i++) {
            str.append(String.format("%-8s", st[i][3]));
        }
        str.append("\n");
        str.append(String.format("%-8s", "s"));
        for (int i = 0; i < size; i++) {
            str.append(String.format("%-8s", st[i][4]));
        }
        return str.toString();

    }
    
}
