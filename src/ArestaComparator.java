import java.util.Comparator;

public class ArestaComparator implements Comparator<Aresta> {

   
    public int compare(Aresta aresta, Aresta outraAresta) {
        
        return Integer.compare(aresta.getCusto(), outraAresta.getCusto());
    }
    
}
