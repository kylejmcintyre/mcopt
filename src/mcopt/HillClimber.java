package mcopt;

import mcopt.util.Pair;

import java.util.Iterator;

/**
 * Basic hill-climbing optimizer. Terminates when no neighbors offer
 * higher fitness than the current configuration.
 */
public class HillClimber<T> extends RandomOptimizer<T> {
    private NeighborFunction<T> neighborFunction;
    private Pair<T, Double> current = null;

    public HillClimber(NeighborFunction<T> neighborFunction) {
        this.neighborFunction = neighborFunction;
    }

    public void resetImpl() {
        current = null;
    }

    @Override
    public String toString() {
        return "HillClimber(neighbor=" + neighborFunction.getClass().getSimpleName() + ")";
    }

    @Override
    public Pair<T, Double> iterate() {
        boolean changed = false;

        if (current == null) {
            T start = problem.getStartConfiguration();
            double fitness = problem.fitnessOf(start);
            current = new Pair(start, fitness);
            changed = true;
        }

        Iterator<T> neighbors = neighborFunction.getNeighbors(current.getKey());

        while (neighbors.hasNext()) {
            T neighbor = neighbors.next();

            double fitness = problem.fitnessOf(neighbor);

            if (fitness > current.getValue()) {
                current = new Pair(neighbor, fitness);
                changed = true;
                break;
            }
        }

        if (changed) {
            return current;
        } else {
            // No neighbor was better
            return null;
        }
    }
}
