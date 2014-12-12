package mcopt;

import mcopt.util.Pair;

/**
 * Base class for a random optimization algorithm. An instance of an optimizer
 * must be provided with an instance of an OptimizationProblem of the same
 * generic type to solve. Tracks the number of iterations, best configuration seen,
 * number of stale iterations, etc.
 *
 * @param <T> the type of the problem encoding
 */

public abstract class RandomOptimizer<T> {
    protected OptimizationProblem<T> problem;
    private Pair<T, Double> best;
    protected int iteration = 0;
    private int bestNumCalcs = 0;
    protected int maxStale = 100;

    public void setProblem(OptimizationProblem<T> problem) {
        this.problem = problem;

        reset();
    }

    public void reset() {
        best = null;
        iteration = 0;
        bestNumCalcs = 0;

        resetImpl();
    }

    public int getBestNumCalcs() {
        return bestNumCalcs;
    }

    public abstract void resetImpl();

    public abstract Pair<T, Double> iterate();

    public int getMaxStale() {
        return maxStale;
    }

    public void setMaxStale(int maxStale) {
        this.maxStale = maxStale;
    }

    public boolean stopOnStaleScore() {
        return true;
    }

    public void train() {
        int stale = 0;
        Double staleScore = null;

        while (true) {
            iteration++;

            if (stopOnStaleScore() && stale == maxStale) {
                break;
            }

            Pair<T, Double> current = iterate();

            // Indicates the optimizer has exhausted its search
            if (current == null)
                break;

            if (best != null && current.getValue() <= best.getValue()) {
                if (staleScore == null)
                    staleScore = current.getValue();

                if (current.getValue().equals(staleScore)) {
                    stale++;
                } else {
                    staleScore = current.getValue();
                    stale = 0;
                }

                continue;
            }

            stale = 0;
            staleScore = null;
            best = current;
            bestNumCalcs = problem.numFitnessCalculations();

            if (problem.getTarget() != null && best.getValue() >= problem.getTarget()) {
                break;
            }
        }
    }

    public Pair<T, Double> getBest() {
        return best;
    }
}
