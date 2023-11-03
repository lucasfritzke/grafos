import java.util.ArrayList;
import java.util.List;

public class Grafo {


    private ArrayList<Vertice> listaAdj = new ArrayList<>();


    public void addVertice(Vertice v){

        if(listaAdj.contains(v)){

            throw new IllegalArgumentException("Verice ja adicionado");
        } else {
            listaAdj.add(v);
        }

    }

    public String getListaAdj(){

        String str ="";
        for (Vertice v : listaAdj) {
          str += v.getListaAdj() +"\n";
        }
        return str;
    }

    public void addAresta(String idVertice1, String idVertice2, int custo){

        Vertice v1 = this.getVertice(idVertice1);
        Vertice v2 = this.getVertice(idVertice2);
        if(v1 != null && v2 != null && !v1.equals(v2) ){
            v1.addAresta(custo, v2);
            v2.addAresta(custo, v1);
        } else {
            throw new IllegalArgumentException("Entrada invalida");
        }
        }

        


    public Vertice getVertice(String id){

        for (Vertice v : listaAdj) {
            if(v.getId().equals(id)){
                return v;
            }
        }
        return null;
    }

    public String getVetorRotasDijkstra() {
        String[][] vetor = this.dijkstra();
        StringBuilder str = new StringBuilder();
        int size = vetor.length;
    
        // Cabeçalhos
        str.append(String.format("%-8s", "VERTICE"));
        for (int i = 0; i < size; i++) {
            str.append(String.format("%-8s", vetor[i][0]));
        }
        str.append("\n");
    
        str.append(String.format("%-8s", "d"));
        for (int i = 0; i < size; i++) {
            str.append(String.format("%-8s", vetor[i][1]));
        }
        str.append("\n");
    
        str.append(String.format("%-8s", "Pi"));
        for (int i = 0; i < size; i++) {
            str.append(String.format("%-8s", vetor[i][2]));
        }
    
        return str.toString();
    }

    private String[][] dijkstra(){

        String[][] vetorRot = new String[listaAdj.size()][3];
        for(int i=0;i < listaAdj.size(); i++ ){
            Vertice v =listaAdj.get(i);
            vetorRot[i][0] = v.getId();
            vetorRot[i][1] = "i";
            vetorRot[i][2] = "nill";
            v.setFlag('b'); // b significa que não foi processado
        }

        return vetorRot;

    }
    
}
