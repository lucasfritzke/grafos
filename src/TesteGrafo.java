import grafo.Aresta;
import grafo.Grafo;

public class TesteGrafo {
    

    public static void main(String[] args) {
        Grafo g = new Grafo();

        g.addVertice("A");
        g.addVertice("B");
        g.addVertice("C");

        g.addAresta("A", "B", 2);
        g.addAresta("B", "C", 2);
        g.addAresta("C", "A", 2);
        
        Aresta a =  g.getAresta("A", "B", 2);
        g.duplicarArestas(a);
        System.out.println(g.toString());
        g.removerDuplicacoes();
        System.out.println(g.toString());


    }
}
