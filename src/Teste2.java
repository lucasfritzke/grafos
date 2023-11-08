import grafo.Grafo;
import grafo.Vertice;

public class Teste2 {

    public static void main(String[] args) {
         Grafo gr = new Grafo();


        // Vértices
        Vertice a = new Vertice("A");
        Vertice b = new Vertice("B");
        Vertice c = new Vertice("C");
        Vertice d = new Vertice("D");
        Vertice e = new Vertice("E");
        Vertice f = new Vertice("F");
        Vertice g = new Vertice("G");
        Vertice h= new Vertice("H");
        Vertice i = new Vertice("I");
        
        // Adicionando vértices ao grafo
        gr.addVertice(a);
        gr.addVertice(b);
        gr.addVertice(c);
        gr.addVertice(d);
        gr.addVertice(e);
        gr.addVertice(f);
        gr.addVertice(g);
        gr.addVertice(h);
        gr.addVertice(i);

        gr.addAresta("A", "B", 12);
        gr.addAresta("A", "D", 2);
        gr.addAresta("A", "H", 8);

        gr.addAresta("B", "C", 3);
        gr.addAresta("B", "I", 10);

        gr.addAresta("C", "D", 2);
        gr.addAresta("C", "E", 2);
        gr.addAresta("C", "F", 1);

        gr.addAresta("D", "G", 1);
        gr.addAresta("D", "E", 1);

        gr.addAresta("E", "F", 3);
        gr.addAresta("E", "G", 2);

        gr.addAresta("F", "G", 2);
        gr.addAresta("F", "I", 4);

        gr.addAresta("H", "G", 5);
        gr.addAresta("H", "I", 12);

        System.out.println(gr.getVetorRotasDijkstra("A"));
        System.out.println("\n");
        System.out.println(gr.getVetorRotasDijkstra("I"));
    


    }
    
}
