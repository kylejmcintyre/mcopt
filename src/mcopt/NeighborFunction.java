package mcopt;

import java.util.Iterator;

public interface NeighborFunction<T> {
    public Iterator<T> getNeighbors(T t);

}
