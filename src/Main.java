public class Main {
    
public static void main(String[] args) {
    
    Grafo g = new Grafo();
    Vertice a = new Vertice("A");
    Vertice b = new Vertice("B");
    Vertice c = new Vertice("C");
    Vertice d = new Vertice("D");
    g.addVertice(a);
    g.addVertice(b);
    g.addVertice(c);
    g.addVertice(d);

    g.addAresta("A", "B", 14);
    g.addAresta("A", "C", 2);
    g.addAresta("C", "D", 3);
    g.addAresta("A", "D", 7);

    System.out.println(g.getVetorRotasDijkstra());
    
}

}
