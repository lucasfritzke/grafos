package grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Grafo {

    private ArrayList<Vertice> listaAdj = new ArrayList<>();
    private StringBuilder str = new StringBuilder();

    public void addVertice(Vertice v) {

        if (listaAdj.contains(v)) {
            throw new IllegalArgumentException("Verice ja adicionado");
        } else {
            listaAdj.add(v);
        }
        listaAdj.sort(null);

    }

    public void addVertice(String id) {

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
            if (v.getId().equals(v2)) {
                v.duplicarAresta(v1, custo);
            }
            if (v.getId().equals(v1)) {
                v.duplicarAresta(v2, custo);
            }
        }
    }

    @Override
    public String toString() {
        String str = " ";
        for (Vertice v : listaAdj) {
            str += v.getListaAdj() + "\n";
        }
        return str;
    }

    public int getCustoTotal() {
        int cont = 0;
        for (Vertice v : listaAdj) {
            ArrayList<Aresta> listaAresta = v.getListaArestas();
            for (Aresta a : listaAresta) {
                cont += a.getCusto();
                if (a.getFlagCaminhoVirtual() > 0) {
                    cont += a.getCusto() * a.getFlagCaminhoVirtual();
                }
            }
        }
        return cont / 2;
    }

    public String gerarCicloEuleriano(String id) {
        str = new StringBuilder();
        Vertice v = this.getVertice(id);
        int contBfs = 0;
        for (Vertice ve : listaAdj) {
            if (!ve.isExcluido()) {
                contBfs++;
            }
        }
        percorrerGrafo(v, contBfs);
        return str.toString();
    }

    public void percorrerGrafo(Vertice v, int contBfs) {

        str.append(v.getId() + " - "); // ADD VERTICE VISITADO
        int qtdArestas = v.getQtdArestasFleury();
        List<Aresta> arestas = v.getArestasValidasFleury();
        if (qtdArestas == 1) { // SE FOR O UNICO NAO PRECISA TESTAR SE E PONTE
            Aresta a = arestas.get(0);
            v.setExcluido(true);
            this.removeVirtual(v.getId(), a.getVerticeAdj().getId(), a.getCusto());
            Vertice vAdj = a.getVerticeAdj();
            contBfs--;
            percorrerGrafo(vAdj, contBfs);
            return;
        } else {
            for (Aresta a : arestas) {
                if (a.getFlagStatus() != 'p' && !this.isPonte(a.getVerticeAdj(), a, contBfs)) {
                    this.removeVirtual(v.getId(), a.getVerticeAdj().getId(), a.getCusto());
                    percorrerGrafo(a.getVerticeAdj(), contBfs);
                    return;
                }
            }
        }

    }

    private boolean isPonte(Vertice v, Aresta a, int contBfs) {
        int contVerticesAtingidos = 0; // CONTA O VERTICE INICIAL
        a.setFlagStatus('p'); // indica que é ponte
        Vertice va = a.getVerticeAdj();
        ArrayList<Aresta> arestas = va.getListaArestas();
        for (Aresta aresta : arestas) {
            if(aresta.getVerticeAdj().equals(v)){
                aresta.setFlagStatus('p'); // SELECIONA PAR O OUTRO VERTICE
            }
        }

        contVerticesAtingidos += this.bfsCont(v);
        if (contVerticesAtingidos == contBfs) {
            a.setFlagStatus(' ');
            return false;

        } else {
            return true;
        }

    }

    private int bfsCont(Vertice v) {
        this.zerarFlagsBfsCont();
        HashMap<String, Vertice> verticesEncontrado = new HashMap<>();
        verticesEncontrado.put(v.getId(), v);
        verticesEncontrado = this.percorrerBfs(v, verticesEncontrado);
        return verticesEncontrado.size();
    }

    private HashMap<String, Vertice> percorrerBfs(Vertice v, HashMap<String, Vertice> verticesEncontrado) {
        ArrayList<Aresta> arestas = v.getListaArestas();
        for (Aresta a : arestas) {
            if (a.getFlagStatus() != 'e') {
                if ((a.getFlagStatus() == 'p' && a.getFlagBfsCont() > 1) || 
                a.getFlagStatus() != 'p' && a.getFlagBfsCont() >= 1) {
                    if (!verticesEncontrado.containsKey(a.getVerticeAdj().getId())) {
                        verticesEncontrado.put(v.getId(), v);
                        a.setFlagBfsCont(a.getFlagBfsCont() - 1);
                        percorrerBfs(a.getVerticeAdj(), v, verticesEncontrado);
                    } else {
                        a.setFlagBfsCont(a.getFlagBfsCont() - 1);
                        percorrerBfs(a.getVerticeAdj(), v, verticesEncontrado);
                    }
                }
            }
        }
        return verticesEncontrado;
    }

    private HashMap<String, Vertice> percorrerBfs(Vertice v, Vertice vPai,
            HashMap<String, Vertice> verticesEncontrado) {

        ArrayList<Aresta> arestas = v.getListaArestas();
        for (Aresta a : arestas) {
            if (a.getVerticeAdj().equals(vPai)) {
                a.setFlagBfsCont(a.getFlagBfsCont() - 1);
            }
        }
        for (Aresta a : arestas) {
            if (a.getFlagStatus() != 'e') {
                if ((a.getFlagStatus() == 'p' && a.getFlagBfsCont() > 1) || 
                a.getFlagStatus() != 'p' && a.getFlagBfsCont() >= 1) {
                    if (!verticesEncontrado.containsKey(a.getVerticeAdj().getId())) {
                        verticesEncontrado.put(a.getVerticeAdj().getId(), a.getVerticeAdj());
                        a.setFlagBfsCont(a.getFlagBfsCont() - 1);
                        return percorrerBfs(a.getVerticeAdj(), v, verticesEncontrado);
                    } else {
                        a.setFlagBfsCont(a.getFlagBfsCont() - 1);
                        return percorrerBfs(a.getVerticeAdj(), v, verticesEncontrado);
                    }
                }
            }
        }
        return verticesEncontrado;

    }

    private void zerarFlagsBfsCont() {
        for (Vertice v : listaAdj) {
            ArrayList<Aresta> li = v.getListaArestas();
            for (Aresta aresta : li) {
                if (aresta.getFlagCaminhoVirtual() > 0) {
                    aresta.setFlagBfsCont(aresta.getFlagCaminhoVirtual() + 1);
                } else {
                    aresta.setFlagCaminhoVirtual(1);
                }
                if (aresta.getFlagStatus() == 'e') {
                    aresta.setFlagBfsCont(-1);
                }
            }

        }
    }

    private void removeVirtual(String id, String id2, int custo) {
        for (Vertice v : listaAdj) {
            if (v.getId().equals(id)) {
                ArrayList<Aresta> a = v.getListaArestas();
                for (Aresta ar : a) {
                    if (ar.getVerticeAdj().equals(id2) && ar.getCusto() == custo) {
                        if (ar.getFlagCaminhoVirtual() > 0) {
                            ar.setFlagCaminhoVirtual(ar.getFlagCaminhoVirtual() - 1);
                        } else {
                            ar.setFlagStatus('e');
                        }
                    }
                }

            } else if (v.getId().equals(id2)) {
                ArrayList<Aresta> a = v.getListaArestas();
                for (Aresta ar : a) {
                    if (ar.getVerticeAdj().equals(id) && ar.getCusto() == custo) {
                        if (ar.getFlagCaminhoVirtual() > 0) {
                            ar.setFlagCaminhoVirtual(ar.getFlagCaminhoVirtual() - 1);
                        } else {
                            ar.setFlagStatus('e');
                        }
                    }
                }

            }
        }
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
