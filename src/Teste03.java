

import grafo.Grafo;

public class Teste03 {

    

    public static void main(String[] args) {
        Grafo gr = new Grafo();
        gr.addVertice("A");
        gr.addVertice("B");
        gr.addVertice("C");
        gr.addVertice("D");
        gr.addVertice("E");
        gr.addVertice("F");
        gr.addAresta("A", "B", 9);
        gr.addAresta("B", "C", 5);
        gr.addAresta("A", "C", 10);
        gr.addAresta("A", "F", 6);
        gr.addAresta("C", "F", 14);
        gr.addAresta("C", "D", 5);
        gr.addAresta("F", "D", 8);
        gr.addAresta("F", "E", 4);
        gr.addAresta("E", "D", 3);
        // System.out.println(gr.getVetorRotasDijkstra("A"));
        System.out.println(gr.calcularCarteiroChines("A"));
    }
    
}
