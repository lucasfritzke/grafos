package grafo;

import java.util.ArrayList;
import java.util.List;

public class CarteiroChines {

    private ArrayList<Vertice> listaAdj = new ArrayList<>();
    private Grafo grafo = new Grafo();
    private StringBuilder str = new StringBuilder();

    public CarteiroChines(Grafo gr) {
        this.grafo = gr;
    }

    public String calcularRota(String id) {
        
        grafo.zerarFlags();
        System.out.println(grafo.toString());

        str.append("---------------------- EXECUÇÃO ALGORITMO CARTEIRO CHINES ----------------------");
        str.append("\n");
        str.append("\n");
        List<Vertice> listaVerticesImpares = grafo.getVerticesGrauImpar();
        if (!listaVerticesImpares.isEmpty()) {
            str.append(this.verticesImparToString(listaVerticesImpares));
            List<VetorRotasDijkstra> vetoresRotaDijkstras;

            vetoresRotaDijkstras = this.calcularCaminhoMinimo(listaVerticesImpares);
            MatrizCusto matrizCusto = new MatrizCusto(vetoresRotaDijkstras, listaVerticesImpares);
            str.append("------------------------------- MATRIZ DE CUSTO -------------------------------");
            str.append("\n");
            str.append("\n");
            str.append(matrizCusto.toString() + "\n");
            List<CelulaMatrizCusto> caminhos = matrizCusto.getVerticesMenorCaminho();
            this.criarCaminhosArtificiais(caminhos, vetoresRotaDijkstras);

            int custo = grafo.getCustoTotal();
            str.append("CICLO EULERIANO: \n");
            String cicloEuleriano = grafo.gerarCicloEuleriano(id);;
            System.out.println(grafo.toString());
            System.out.println(custo);

            str.append(cicloEuleriano+"\n");
            str.append("Custo: "+ custo);

        } else {
            str.append("grafo é euleriano");
        }

        return str.toString();
    }

    private List<VetorRotasDijkstra> calcularCaminhoMinimo(List<Vertice> listaVerticesImpares) {
        str.append("\n");
        str.append("\n");
        str.append("------------------------ CAMINHO MINIMO DE CADA VERTICE ------------------------");
        str.append("\n");
        List<VetorRotasDijkstra> vetoresRotaDijkstras = new ArrayList<>();
        Dijkstra d = new Dijkstra(grafo.getListaAdj());
        for (Vertice v : listaVerticesImpares) {
            VetorRotasDijkstra vrd = d.getVetorRoteamento(v.getId());
            vetoresRotaDijkstras.add(vrd);
            str.append("Dijkstra Vertice: " + vrd.getId() + "\n");
            str.append(vrd.toString() + "\n\n");

        }
        return vetoresRotaDijkstras;
    }

    private String verticesImparToString(List<Vertice> listaVerticesImpares) {
        StringBuilder str = new StringBuilder();
        str.append("Vertices Impares = { ");
        for (Vertice v : listaVerticesImpares) {
            str.append(v.getId() + ", ");
        }
        str.append("}");
        String st = str.toString();
        st = st.replaceAll(", }", " }");
        
        return st;
    }

    private void criarCaminhosArtificiais(List<CelulaMatrizCusto> caminhos,
        List<VetorRotasDijkstra> vetoresRotaDijkstras) {
        
        for (CelulaMatrizCusto caminho : caminhos) {
            String idVerticeInicial = caminho.getIdVertice();
            String idVeStringFinal = caminho.getIdVerticeAdj();
            for(VetorRotasDijkstra vetor : vetoresRotaDijkstras){
                if(vetor.getId().equals(idVerticeInicial)){
                    this.duplicarArestas(vetor, caminho.getCusto(),idVerticeInicial, idVeStringFinal);                    
                }
            }
        }
    }

    public void duplicarArestas(VetorRotasDijkstra vetor, int custo, String idVerticeInicial, String idVeStringFinal){
        int custoVerticeFinal = vetor.getDistancia(idVeStringFinal);
        String pai = vetor.getPai(idVeStringFinal);
        if(pai.equals("nill")){
            return;
        }
        int custoPai = vetor.getDistancia(pai);
        grafo.duplicarArestas(idVeStringFinal, pai, (custoVerticeFinal-custoPai));
        custo = custo - custoPai;
        if(custo != 0){
            duplicarArestas(vetor, custo, idVerticeInicial, pai);
        }
    }




    public boolean isEuleriano() {
        for (Vertice v : listaAdj) {
            if (v.getListaAdj().length() % 2 != 0) {

                return false;
            }
        }

        return true;

    }

    public Grafo getGr() {
        return grafo;
    }

    public void setGr(Grafo gr) {
        this.grafo = gr;
    }

}
