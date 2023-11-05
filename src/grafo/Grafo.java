package grafo;
import java.util.ArrayList;
import java.util.List;
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

    public String eulerizarCaixeiroChines(String id){
        String str = "";
        List<Vertice> listaVerticesImpares = this.getVerticesImpares();
        ArrayList<String[][]> vetoresRotaDijkstra = new ArrayList<>();
        Dijkstra d = new Dijkstra(listaAdj);
        int cont=0;
        for (Vertice v : listaVerticesImpares) {
            vetoresRotaDijkstra.add(d.vetorRoteamento(v.getId()));
            str += d.vetorRoteamentoToString(vetoresRotaDijkstra.get(cont))+"\n\n";
            cont++;
        }
        //String[][] matrizD = this.gerarMatrizD(vetoresRotaDijkstra, listaVerticesImpares );

        return str;
    }
    private String[][] gerarMatrizD(ArrayList<String[][]> vetoresRotaDijkstra, List<Vertice> listaVerticesImpares) {

        String[][] matriz = new String[listaVerticesImpares.size()+1][listaVerticesImpares.size()+1];
        matriz[0][0] = " ";
        int cont=0;
        for (Vertice v : listaVerticesImpares) {
            for (String[] vetor : matriz) {
                if(vetor[5].equals(v.getId())){
                    matriz[cont+1][0] = v.getId();
                    matriz[0][cont+1] = v.getId();
                    matriz[cont+1][cont+1] = "0";
                    for (Vertice ve : listaVerticesImpares){
                        for(int i=0; i < vetor.length; i++){
                            if(vetor[0].equals(ve.getId())){

                            }
                        }

                    }

                }
            } 
        }

        return null;
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
