package grafo;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;



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
    public ArrayList<Vertice> getListaAdj() {
        return this.listaAdj;
    
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
   
    public List<Vertice> getVerticesGrauImpar() {
        List<Vertice> li = new ArrayList<>();
        for (Vertice v : listaAdj) {
            if (v.getListaArestas().size() % 2 != 0) {
                li.add(v);
                ;
            }
        }

        return li;
    }
    public void duplicarArestas(String v1, String v2, int custo) {
        for (Vertice v : listaAdj) {
            if(v.getId().equals(v2)){
                v.duplicarAresta(v1, custo);
            }
            if(v.getId().equals(v1)){
                v.duplicarAresta(v2, custo);
            }
        }
    }

    @Override
    public String toString() {
        String str =" ";
        for (Vertice v : listaAdj) {
            str += v.getListaAdj()+"\n";
        }
        return str;
    }
    public int getCustoTotal() {
        int cont =0;
        for (Vertice v : listaAdj) {
            ArrayList<Aresta> listaAresta = v.getListaArestas();
            for (Aresta a : listaAresta) {
                cont += a.getCusto();
                if(a.getFlagCaminhoVirtual() > 0){
                    cont += a.getCusto() * a.getFlagCaminhoVirtual();
                }
            }
        }
        return cont / 2;
    }
    public String gerarCicloEuleriano(String id) {
        StringBuilder str = new StringBuilder();
        ArrayList<Vertice> listaVerticesNaoProcessado = this.listaAdj;

        Vertice v = this.getVertice(id);
        
        if(!v.isExcluido()){
            str.append(v.getId()+" - ");
           List<Aresta> la = v.getListaArestas();
           for (Aresta a : la) {
                if(a.getFlagStatus() != 'e'){ // e = excluido 
                    
                    
                } 
           }
        }


        






        return null;
    }
    public void zerarFlags() {

        for (Vertice v : listaAdj) {
            v.setFlag(' ');
            v.setD(Integer.MAX_VALUE);
            v.setPi("nill");
            ArrayList<Aresta> li = v.getListaArestas();
            for (Aresta a : li) {
                a.setFlagCaminhoVirtual(0);
                a.setFlagStatus(' ');
            }
        }
    }

}
