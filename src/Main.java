public class Main {
    
public static void main(String[] args) {
    
    Grafo g = new Grafo();
    Vertice a = new Vertice("A");
    Vertice b = new Vertice("B");
    Vertice c = new Vertice("C");
    g.addVertice(a);
    g.addVertice(b);
    g.addVertice(c);
    g.addAresta("A", "B", 14);
    g.addAresta("A", "C", 2);

    System.out.println(g.getListaAdj());
}

}
