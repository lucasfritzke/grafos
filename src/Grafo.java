import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Grafo {

    private ArrayList<Vertice> listaAdj = new ArrayList<>();

    public void addVertice(Vertice v) {

        if (listaAdj.contains(v)) {

            throw new IllegalArgumentException("Verice ja adicionado");
        } else {
            listaAdj.add(v);
        }

        listaAdj.sort(null);

    }

    public String getListaAdj() {

        String str = "";
        for (Vertice v : listaAdj) {
            str += v.getListaAdj() + "\n";
        }
        return str;
    }

    public void addAresta(String idVertice1, String idVertice2, int custo) {

        Vertice v1 = this.getVertice(idVertice1);
        Vertice v2 = this.getVertice(idVertice2);
        if (v1 != null && v2 != null && !v1.equals(v2)) {
            v1.addAresta(custo, v2);
            v2.addAresta(custo, v1);
        } else {
            throw new IllegalArgumentException("Entrada invalida");
        }
    }

    public Vertice getVertice(String id) {

        for (Vertice v : listaAdj) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public String getVetorRotasDijkstra(String id) {
        this.dijkstra(id);
        StringBuilder str = new StringBuilder();
        int size = listaAdj.size();
        String[][] st = new String[listaAdj.size()][5];

        for (int i = 0; i < listaAdj.size(); i++) {
            Vertice v = listaAdj.get(i);
            st[i][0] = v.getId();
            st[i][1] = Integer.toString(v.getD());
            st[i][2] = v.getPi();
            st[i][3] = " ";
            st[i][4] = "x";
        }

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

    private String[][] dijkstra(String id) {
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
                
                this.relax(u, adj, aresta.getCusto());
                if(q.contains(adj)){
                    q.remove(adj);
                    q.add(adj);
                }
                
            }

        }
        return null;

    }

    private void relax(Vertice u, Vertice verticeAdj, int custo) {

        if (verticeAdj.getD() > u.getD() + custo) {
            verticeAdj.setD(u.getD() + custo);
            verticeAdj.setPi(u.getId());
        }
    }

    private int getPosicaoId(String[][] vet, String id) {

        for (int i = 0; i < vet.length; i++) {
            if (vet[i][0].equals(id)) {
                return i;
            }

        }
        // nao vai chegar aqui
        return 0;
    }

    private void setVetorDijkstra(String[][] vet, String id, String d, String pi) {

        for (int i = 0; i < vet.length; i++) {
            if (vet[i][0].equals(id)) {
                vet[i][1] = d;
                vet[i][2] = pi;
            }
        }
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

}
