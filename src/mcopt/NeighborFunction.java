package mcopt;

import java.util.Iterator;

/**
 * Howdy neighbor! Basic interface for a class that computes
 * neighbors of a configuration.
 */
public interface NeighborFunction<T> {
    public Iterator<T> getNeighbors(T t);

}
