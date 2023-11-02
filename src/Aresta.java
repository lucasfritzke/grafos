public class Aresta implements Comparable<Aresta> {

    private int custo;
    private Vertice verticeAdj;

    public Aresta() {
    }


    public Aresta(int custo, Vertice verticeAdj) {
        this.custo = custo;
        this.verticeAdj = verticeAdj;
    }


    public int getCusto() {
        return custo;
    }
    public void setCusto(int custo) {
        this.custo = custo;
    }
    public Vertice getVerticeAdj() {
        return verticeAdj;
    }
    public void setVerticeAdj(Vertice verticeAdj) {
        this.verticeAdj = verticeAdj;
    }


    @Override
    public int compareTo(Aresta o) {
        // TODO Auto-generated method stub
        return this.verticeAdj.getId().compareTo(o.getVerticeAdj().getId());
    }
    

    
    
}
