import grafo.Grafo;

public class Teste04 {

    

    public static void main(String[] args) {
        Grafo gr = new Grafo();
        gr.addVertice("1");
        gr.addVertice("2");
        gr.addVertice("3");
        gr.addVertice("4");
        gr.addVertice("5");
        gr.addVertice("6");
        gr.addVertice("7");
        gr.addVertice("8");
        gr.addVertice("9");
        gr.addVertice("10");
        gr.addVertice("11");
        gr.addVertice("12");

        gr.addAresta("2", "3", 18); 
        gr.addAresta("2", "4", 9);
        gr.addAresta("2", "1", 13);
        gr.addAresta("2", "9", 2);
        gr.addAresta("1", "7", 19);
        gr.addAresta("1", "12", 4);
        gr.addAresta("7", "12", 18);
        gr.addAresta("4", "3", 20); 
        gr.addAresta("1", "4", 17);

        gr.addAresta("9", "11", 14);
        gr.addAresta("9", "10", 16);
        gr.addAresta("11", "10", 12);
        gr.addAresta("10", "8", 3);
        gr.addAresta("11", "8", 10);

        gr.addAresta("8", "7", 8);
        gr.addAresta("7", "6", 4);
        gr.addAresta("11", "5", 20);
        gr.addAresta("3", "5", 5); 
        gr.addAresta("12", "5", 11);
        gr.addAresta("6", "5", 7);
        gr.addAresta("12", "6", 3);
        gr.addAresta("1", "10", 19);

        System.out.println(gr.calcularCarteiroChines("1"));


    }
    
}
