package grafo;
import java.util.ArrayList;
import java.util.List;


public class Grafo {

    private ArrayList<Vertice> listaAdj = new ArrayList<>();

    public void addVertice(Vertice v) {

        if (listaAdj.contains(v)) {
            throw new IllegalArgumentException("Verice ja adicionado");
        } else {
            listaAdj.add(v);
        }
        listaAdj.sort(null);

    }
    public void addVertice(String id){

       Vertice v = new Vertice(id);
       if (listaAdj.contains(v)) {
            throw new IllegalArgumentException("Verice ja adicionado");
        } else {
            listaAdj.add(v);
        }
        listaAdj.sort(null);
    }
    public String getListaAdj() {

        String str = "";
        for (Vertice v : listaAdj) {
            str += v.getListaAdj() + "\n";
        }
        return str;
    }
    public void addAresta(String idVertice1, String idVertice2, int custo) {

        Vertice v1 = this.getVertice(idVertice1);
        Vertice v2 = this.getVertice(idVertice2);
        if (v1 != null && v2 != null && !v1.equals(v2)) {
            v1.addAresta(custo, v2);
            v2.addAresta(custo, v1);
        } else {
            throw new IllegalArgumentException("Entrada invalida");
        }
    }
    public Vertice getVertice(String id) {

        for (Vertice v : listaAdj) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public String getVetorRotasDijkstra(String id) {
        Dijkstra d = new Dijkstra(listaAdj);
        VetorRotasDijkstra ve = d.getVetorRoteamento(id);
        return ve.toString();
    }

    public String calcularCarteiroChines(String id){
        CarteiroChines cc = new CarteiroChines(this.listaAdj);
        return cc.calcularRota(id);

    }

    private void zerarFlags() {

        for (Vertice v : listaAdj) {
            v.zerarFlags();
        }
    }
    
    private List<Vertice> getVerticesImpares() {
        List<Vertice> li = new ArrayList<>();
        for (Vertice v : listaAdj) {
             if(v.getListaArestas().size() % 2 != 0){
                li.add(v);
                ;
             } 
        }

        return li;
    }

    

   

  

}
