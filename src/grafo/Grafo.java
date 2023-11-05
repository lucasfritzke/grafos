package grafo;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

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
        return d.vetorRoteamentoToString(id);
    }

    public boolean isEuleriano(){

        for (Vertice v : listaAdj) {
             if(v.getListaAdj().length() % 2 != 0){

                return false;
             } 
        }

        return true;

    }

    public String getCicloEureliano(String id){
        if(this.isEuleriano()){
            this.zerarFlags();
            int contCusto =0;
            Vertice temp;
            int grauVerticeTemp =0;
            String ciclo ="Ciclo ={ ";
            
            /*
             * flag -> Arestas: ' ' ainda nao descoberto | 'r' removido
             * flag -> Vertice: ' ' nao descoberto | 'd' descoberto | 'f' fechado 
             */
            Vertice u = this.getVertice(id);
            u.setFlag('d');
            ciclo += u.getId()+" ";
            
            ArrayList<Aresta> arestasAdj = u.getListaArestas();
            for (Aresta aresta : arestasAdj) {
                if(aresta.getFlag() != 'r'){
                    
                }
            }

            return ciclo += " } \n Custo Total: "+contCusto;

        } else {
            return "Nao é euleriano";
        }
    }

    private void zerarFlags() {

        for (Vertice v : listaAdj) {
            v.zerarFlags();
        }
    }

    

   

  

}
