package grafo;

import java.util.ArrayList;
import java.util.List;

public class CarteiroChines {

    private ArrayList<Vertice> listaAdj = new ArrayList<>();

    public CarteiroChines(ArrayList<Vertice> listaAdj) {
        this.listaAdj = listaAdj;

    }

    public String calcularRota(String id){
        String str = "";
        if(!isEuleriano()){

            List<Vertice> listaVerticesImpares = this.getVerticesImpares();
            List<VetorRotasDijkstra> vetoresRotaDijkstras = new ArrayList<>();
            Dijkstra d = new Dijkstra(listaAdj);

            for (Vertice v : listaVerticesImpares) {
                VetorRotasDijkstra vrd = d.getVetorRoteamento(v.getId());
                vetoresRotaDijkstras.add(vrd);
                str += vrd.toString()+"\n\n";

            }
            

        } 

        return str;
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

    public boolean isEuleriano(){
        for (Vertice v : listaAdj) {
             if(v.getListaAdj().length() % 2 != 0){

                return false;
             } 
        }

        return true;

    }

    
}
