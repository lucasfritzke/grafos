import grafo.Grafo;
import grafo.Vertice;

public class Teste01 {

    public static void main(String[] args) {
        
        Grafo g = new Grafo();
        
        // Vértices
        Vertice A = new Vertice("A");
        Vertice B = new Vertice("B");
        Vertice C = new Vertice("C");
        Vertice D = new Vertice("D");
        Vertice E = new Vertice("E");
        Vertice F = new Vertice("F");
        
        // Adicionando vértices ao grafo
        g.addVertice(A);
        g.addVertice(B);
        g.addVertice(C);
        g.addVertice(D);
        g.addVertice(E);
        g.addVertice(F);
        
        // Adicionando arestas com pesos
        g.addAresta("A", "C", 2);
        g.addAresta("A", "B", 5);
        g.addAresta("B", "A", 5);
        g.addAresta("B", "D", 8);
        g.addAresta("B", "C", 7);
        g.addAresta("C", "A", 2);
        g.addAresta("C", "E", 8);
        g.addAresta("C", "D", 4);
        g.addAresta("C", "B", 7);
        g.addAresta("D", "B", 8);
        g.addAresta("D", "C", 4);
        g.addAresta("D", "E", 6);
        g.addAresta("D", "F", 4);
        g.addAresta("E", "F", 3);
        g.addAresta("E", "D", 6);
        g.addAresta("E", "C", 8);
        g.addAresta("F", "D", 4);
        g.addAresta("F", "E", 3);

        System.out.println(g.getVetorRotasDijkstra("A"));
    }
    
}
