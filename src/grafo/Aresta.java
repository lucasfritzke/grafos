package grafo;

public class Aresta implements Comparable<Aresta> {

    private int custo;
    private Vertice verticeAdj;
    private int flagCaminhoVirtual=0;
    private char flagStatus =' ';   
    private int flagBfsCont = 0;
    
    public int getFlagCaminhoVirtual() {
        return flagCaminhoVirtual;
    }
    public void setFlagCaminhoVirtual(int flagCaminhoVirtual) {
        this.flagCaminhoVirtual = flagCaminhoVirtual;
    }
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
    @Override
    public String toString() {
        return  "| "+this.getVerticeAdj().getId() + " | "+ this.getCusto() +" |";
        
    }

    public char getFlagStatus() {
        return flagStatus;
    }
    public void setFlagStatus(char status) {
        this.flagStatus = status;
    }

    public int getFlagBfsCont() {
        return flagBfsCont;
    }
    public void setFlagBfsCont(int flagBfsCont) {
        this.flagBfsCont = flagBfsCont;
    }
}
