import grafo.Grafo;
import grafo.Vertice;

public class Main {
    
public static void main(String[] args) {
    
    Grafo g = new Grafo();
    Vertice a = new Vertice("A");
    Vertice b = new Vertice("B");
    Vertice c = new Vertice("C");
    Vertice d = new Vertice("D");
    g.addVertice(b);
    g.addVertice(a);
    g.addVertice(d);
    g.addVertice(c);
    g.addAresta("C", "D", 3);
    g.addAresta("A", "D", 7);
    g.addAresta("A", "B", 14);
    g.addAresta("A", "C", 2);
    g.addAresta("D", "B", 1);
    
    
    System.out.println(g.getListaAdj());
    System.out.println(g.getVetorRotasDijkstra("A"));
    
}

}
