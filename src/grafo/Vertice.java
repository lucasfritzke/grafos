package grafo;

import java.util.ArrayList;
import java.util.List;

public class Vertice implements Comparable<Vertice> {

    private String id;
    private ArrayList<Aresta> listaArestas = new ArrayList<>();
    private char flag = ' ';
    // atributos para Dijkstra
    private int d;
    private String pi;
    private boolean excluido = false; // para fleury

    public Vertice(String id) {
        this.id = id;
    }

    public void addAresta(int custo, Vertice v) {

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

    public String getListaAdj() {
        String str = "" + this.getId() + " ->";

        for (Aresta a : listaArestas) {
            str += "| " + a.getVerticeAdj().getId() + " | " + a.getCusto() + " |->";
            if (a.getFlagCaminhoVirtual() == 1) {
                str += "| " + a.getVerticeAdj().getId() + " | " + a.getCusto() + " |->";
            }
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

    public ArrayList<Aresta> getListaArestas() {

        return this.listaArestas;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    public void addCaminhoVirtual(String idAdj, int custo) {
        for (Aresta aresta : listaArestas) {
            if (aresta.getVerticeAdj().getId().equals(idAdj) && aresta.getCusto() == custo) {
                aresta.setFlagCaminhoVirtual(aresta.getFlagCaminhoVirtual() + 1);
            }
        }
    }

    public void duplicarAresta(String v1, int custo) {
        for (Aresta a : listaArestas) {
            if (a.getVerticeAdj().getId().equals(v1) && a.getCusto() == custo) {
                a.setFlagCaminhoVirtual(1);
            }
        }
    }

    public void setListaArestas(ArrayList<Aresta> listaArestas) {
        this.listaArestas = listaArestas;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }

    public int getQtdArestasFleury() {
        int cont = 0;
        for (Aresta a : listaArestas) {
            if (a.getFlagStatus() != 'e') {
                if (a.getFlagCaminhoVirtual() > 0) {
                    cont += 1 + a.getFlagCaminhoVirtual();
                } else {
                    cont++;
                }
            }
        }
        return cont;
    }

    public List<Aresta> getArestasValidasFleury() {
        ArrayList<Aresta> li = new ArrayList<>();
        for (Aresta a : this.listaArestas) {
            if (a.getFlagStatus() != 'e') {
                li.add(a);
            }
        }

        return li;
    }
}
