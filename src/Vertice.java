import java.util.ArrayList;
import java.util.List;

public class Vertice implements Comparable<Vertice>{

    private String id;
    private ArrayList<Aresta> listaArestas = new ArrayList<>();
    private char flag = ' ';

    public Vertice(String id) {
        this.id = id;
    }
    
    public void addAresta(int custo, Vertice v){

        Aresta a = new Aresta();
        a.setVerticeAdj(v);
        a.setCusto(custo);
        listaArestas.add(a);
        listaArestas.sort(null);

    }

    @Override
    public int compareTo(Vertice o) {
        
        return this.id.compareTo(o.id);
    }

    public String getListaAdj(){
        String str=""+ this.getId() + " ->";

        for (Aresta a : listaArestas) {
            str += "| "+ a.getVerticeAdj().getId() + " | "+ a.getCusto()+" |->";
        }

        return str;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public char getFlag() {
        return flag;
    }

    public void setFlag(char flag) {
        this.flag = flag;
    }
    
    

}
