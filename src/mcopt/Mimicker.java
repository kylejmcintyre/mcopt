package mcopt;

import mcopt.util.Pair;

/*
import dist.DiscreteDependencyTree;
import dist.DiscreteUniformDistribution;
import dist.Distribution;
import opt.EvaluationFunction;
import opt.prob.GenericProbabilisticOptimizationProblem;
import opt.prob.MIMIC;
import opt.prob.ProbabilisticOptimizationProblem;
import shared.Instance;
*/

import java.util.BitSet;

public abstract class Mimicker extends RandomOptimizer<BitSet> {

    /*
    private final int popSize;
    private final int keep;

    private MIMIC mimic;

    public Mimicker(int popSize, int keep) {
        this.popSize = popSize;
        this.keep = keep;

        maxStale = 400;
    }

    public String toString() {
        return "Mimicker(size=" + popSize + ",keep=" + keep + ")";
    }

    public void resetImpl() {
        int[] ranges = new int[problem.getStartConfiguration().length() - 1];
        for (int i = 0; i < ranges.length; i++)
            ranges[i] = 2;

        Distribution dist = new DiscreteDependencyTree(.15, ranges);

        EvaluationFunction func = new EvaluationFunction() {
            @Override
            public double value(Instance d) {
                return Mimicker.this.problem.fitnessOf(instanceToBitSet(d));
            }
        };

        ProbabilisticOptimizationProblem p = new GenericProbabilisticOptimizationProblem(func, new DiscreteUniformDistribution(ranges), dist);

        mimic = new MIMIC(popSize, keep, p);
    }

    private BitSet instanceToBitSet(Instance d) {
        BitSet set = new BitSet(d.size() + 1);
        set.set(d.size(), true);

        for (int i = 0; i < d.getData().size(); i++)
            set.set(i, d.getData().get(i) > 0.5);

        return set;
    }

    @Override
    public Pair<BitSet, Double> iterate() {
        mimic.train();

        BitSet b = instanceToBitSet(mimic.getOptimal());

        double fitness = problem.fitnessOf(b);

        return new Pair(b, fitness);
    }
    */
}
