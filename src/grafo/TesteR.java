package grafo;

import java.util.ArrayList;

public class TesteR {

    public static void main(String[] args) {
        Vertice v1 = new Vertice("A");
        Vertice v2 = new Vertice("B");
        Vertice v3 = new Vertice("C");
        Vertice v4 = new Vertice("D");
        Aresta a = new Aresta(v1, v2, 3);
        Aresta b = new Aresta(v1, v2, 3);
        Aresta c = new Aresta(v1, v3, 7);
        Aresta d = new Aresta(v4, v2, 8);
        v1.addAresta(a);
        v1.addAresta(b);
        v1.addAresta(c);
        v1.addAresta(d);
        System.out.println(c.equals(d) + " falso");
        System.out.println(a.equals(b) + " true");
        ArrayList<Aresta> ar = new ArrayList<>();
        ar.add(d);
        ar.add(b);
        ar.add(a);
        ar.add(c);
        ar.sort(null);
        for (Aresta aresta : ar) {
            Vertice[] v = aresta.getVertices();
            System.out.println(v[0].getId() + " "+ v[1].getId() + " " + aresta.getCusto());
        }
        System.out.println(v1.getListaAdj());




    }
    
}
