package grafo;
import java.util.Comparator;

public class VerticeDijkstraComparator implements Comparator<Vertice>{

    @Override
    public int compare(Vertice o1, Vertice o2) {
        return Integer.compare(o1.getD(), o2.getD());
    }
    
}
