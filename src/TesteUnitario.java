// LUCAS FRITZKE E GUILHERME BACK

public class TesteUnitario {

    public static void main(String[] args) {
        
        Grafo grafo = new Grafo();
        grafo.addVertice("A");
        grafo.addVertice("B");
        grafo.addVertice("C");
        grafo.addVertice("D");
        grafo.addVertice("E");
        grafo.addVertice("F");
        grafo.addVertice("G");
        grafo.addVertice("H");
        grafo.addVertice("I");
        grafo.addVertice("J");
        grafo.addVertice("K");
        grafo.addVertice("L");

        grafo.addAresta("A", "E", 12);
        grafo.addAresta("A", "B", 8);
        grafo.addAresta("E", "F", 6);
        grafo.addAresta("F", "B", 6);
        grafo.addAresta("F", "G", 5);
        grafo.addAresta("B", "C", 1);
        grafo.addAresta("G", "C", 4);
        grafo.addAresta("C", "D", 3);
        grafo.addAresta("D", "H", 9);
        grafo.addAresta("G", "H", 7);
        grafo.addAresta("G", "I", 12);
        grafo.addAresta("H", "J", 5);
        grafo.addAresta("I", "J", 5);
        grafo.addAresta("I", "K", 6);
        grafo.addAresta("K", "L", 2);
        grafo.addAresta("J", "L", 3);

        CarteiroChines cc = new CarteiroChines(grafo);
        System.out.println(cc.calcularRota("A"));
        //System.out.println(cc.calcularRota("I"));
        



    }
    
}
