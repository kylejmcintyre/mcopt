package mcopt;

import mcopt.util.Pair;

import java.util.Iterator;

public class Annealer<T> extends RandomOptimizer<T> {
    private NeighborFunction<T> neighborFunction;
    protected double temp;
    private final double cooling;
    private Pair<T, Double> current;
    protected int lastChange;
    private final double startTemp;
    private boolean random = true;

    public Annealer(NeighborFunction<T> neighborFunction, double temp, double cooling) {
        this.neighborFunction = neighborFunction;
        this.temp = this.startTemp = temp;
        this.cooling = cooling;
    }

    public void resetImpl() {
        this.temp = startTemp;
        current = null;
        lastChange = 0;
    }

    @Override
    public boolean stopOnStaleScore() {
        return !random;
    }

    public String toString() {
        double itsUntilOne = Math.log(1E-11 / startTemp) / Math.log(cooling);
        return "Annealer(temp=" + startTemp + ",cooling=" + cooling + ",neighbor=" + neighborFunction.getClass().getSimpleName() + ",its=" + itsUntilOne + ")";
    }

    @Override
    public Pair<T, Double> iterate() {
        if (current == null) {
            T start = problem.getStartConfiguration();
            double fitness = problem.fitnessOf(start);
            current = new Pair(start, fitness);
        }

        Iterator<T> neighbors = neighborFunction.getNeighbors(current.getKey());

        random = temp > 1E-11;

        while (neighbors.hasNext()) {
            T neighbor = neighbors.next();
            double fitness = problem.fitnessOf(neighbor);

            if (fitness > current.getValue() || ((random && Math.random() < Math.exp((fitness - current.getValue() - 0.1) / temp)))) {
                lastChange = iteration;
                current = new Pair(neighbor, fitness);
                break;
            }
        }

        if ((iteration - lastChange) > 0) {
            return null;
        }

        temp *= cooling;

        return current;
    }
}
