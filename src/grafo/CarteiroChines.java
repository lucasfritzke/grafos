package grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarteiroChines {

    private ArrayList<Vertice> listaAdj = new ArrayList<>();

    public CarteiroChines(ArrayList<Vertice> listaAdj) {
        this.listaAdj = listaAdj;

    }

    public String calcularRota(String id) {
        String str = "";
        if (!isEuleriano()) {

            List<Vertice> listaVerticesImpares = this.getVerticesImpares();
            List<VetorRotasDijkstra> vetoresRotaDijkstras = new ArrayList<>();
            Dijkstra d = new Dijkstra(listaAdj);

            for (Vertice v : listaVerticesImpares) {
                VetorRotasDijkstra vrd = d.getVetorRoteamento(v.getId());
                vetoresRotaDijkstras.add(vrd);
                str += vrd.toString() + "\n\n";

            }

            MatrizCusto m = new MatrizCusto(vetoresRotaDijkstras, listaVerticesImpares);

        }

        return str;
    }

    private List<Vertice> getVerticesImpares() {
        List<Vertice> li = new ArrayList<>();
        for (Vertice v : listaAdj) {
            if (v.getListaArestas().size() % 2 != 0) {
                li.add(v);
                ;
            }
        }

        return li;
    }

    public boolean isEuleriano() {
        for (Vertice v : listaAdj) {
            if (v.getListaAdj().length() % 2 != 0) {

                return false;
            }
        }

        return true;

    }

    class MatrizCusto {

        ArrayList<ArrayList<CelulaMatrizCusto>> matriz = new ArrayList<>();
        List<VetorRotasDijkstra> vetoresRotaDijkstras;
        List<Vertice> listaVerticesImpares;

        public MatrizCusto(List<VetorRotasDijkstra> vetoresRotaDijkstras, List<Vertice> listaVerticesImpares) {
            this.vetoresRotaDijkstras = vetoresRotaDijkstras;
            this.listaVerticesImpares = listaVerticesImpares;
            this.gerarMatriz();
        }

        private void gerarMatriz() {

            for (Vertice v : listaVerticesImpares) {

                for (VetorRotasDijkstra vetor : vetoresRotaDijkstras) {


                    if (vetor.getId().equals(v.getId())) {

                        ArrayList<CelulaMatrizCusto> linha = new ArrayList<>();

                        for (Vertice ve : listaVerticesImpares) {
                            CelulaMatrizCusto c = new CelulaMatrizCusto(
                                    v.getId(), ve.getId(), vetor.getDistancia(ve.getId()));
                            linha.add(c);
                        }
                        matriz.add(linha);
                    }
                }

            }

            StringBuilder str = new StringBuilder();

            str.append(String.format("%-8s", "null"));
            for (Vertice v : listaVerticesImpares) {
                str.append(String.format("%-8s", v.getId()));
            }
            str.append("\n");
            for (ArrayList<CelulaMatrizCusto> linha : matriz) {
                str.append(String.format("%-8s", linha.get(0).getIdVertice()));
                for (CelulaMatrizCusto c : linha) {
                    str.append(String.format("%-8s", c.getCusto()));
                }
                str.append("\n");
            }
            System.out.println(str);
        }

    }

    class CelulaMatrizCusto {

        String idVertice;
        String idVerticeAdj;
        int custo;

        public CelulaMatrizCusto(String idVertice, String idVerticeAdj, int custo) {
            this.idVertice = idVertice;
            this.idVerticeAdj = idVerticeAdj;
            this.custo = custo;
        }

        public String getIdVertice() {
            return idVertice;
        }

        public void setIdVertice(String idVertice) {
            this.idVertice = idVertice;
        }

        public String getIdVerticeAdj() {
            return idVerticeAdj;
        }

        public void setIdVerticeAdj(String idVerticeAdj) {
            this.idVerticeAdj = idVerticeAdj;
        }

        public int getCusto() {
            return custo;
        }

        public void setCusto(int custo) {
            this.custo = custo;
        }

    }

}
