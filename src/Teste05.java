

import grafo.CarteiroChines;
import grafo.Grafo;

public class Teste05 {

    public static void main(String[] args) {
        
        Grafo g = new Grafo();
        g.addVertice("A");
        g.addVertice("B");
        g.addVertice("C");

        g.addAresta("A", "B", 2);
        g.addAresta("B", "C", 2);

        CarteiroChines cc = new CarteiroChines(g);
        System.out.println(cc.calcularRota("A"));
        
    }
    
}
