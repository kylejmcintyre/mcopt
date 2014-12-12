package mcopt.experiments;

import mcopt.*;
import mcopt.problems.FourPeaksProblem;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class FourPeaksLocalExperimenter extends Experiment<BitSet> {
    public static void main(String[] args) throws Exception {
        FourPeaksLocalExperimenter exp = new FourPeaksLocalExperimenter();
        exp.run("four-peaks-local", 100, Integer.MAX_VALUE);
    }

    @Override
    public List<OptimizationProblem<BitSet>> getProblems() {
        List problems = new ArrayList();

        problems.add(new FourPeaksProblem(10, 1));
        problems.add(new FourPeaksProblem(20, 2));
        problems.add(new FourPeaksProblem(30, 3));
        problems.add(new FourPeaksProblem(40, 4));
        problems.add(new FourPeaksProblem(50, 5));
        problems.add(new FourPeaksProblem(60, 6));
        problems.add(new FourPeaksProblem(70, 7));
        problems.add(new FourPeaksProblem(80, 8));

        return problems;
    }

    @Override
    public List<RandomOptimizer<BitSet>> getOptimizers() {
        List optimizers = new ArrayList();

        optimizers.add(new HillClimber(new NeighborFunctions.SingleBitFlipper()));

        optimizers.add(new Annealer(new NeighborFunctions.SingleBitFlipper(), 1000, 0.1));
        optimizers.add(new Annealer(new NeighborFunctions.SingleBitFlipper(), 1000, 0.2));
        optimizers.add(new Annealer(new NeighborFunctions.SingleBitFlipper(), 1000, 0.3));
        optimizers.add(new Annealer(new NeighborFunctions.SingleBitFlipper(), 1000, 0.4));
        optimizers.add(new Annealer(new NeighborFunctions.SingleBitFlipper(), 1000, 0.5));
        optimizers.add(new Annealer(new NeighborFunctions.SingleBitFlipper(), 1000, 0.6));
        optimizers.add(new Annealer(new NeighborFunctions.SingleBitFlipper(), 1000, 0.7));
        optimizers.add(new Annealer(new NeighborFunctions.SingleBitFlipper(), 1000, 0.8));
        optimizers.add(new Annealer(new NeighborFunctions.SingleBitFlipper(), 1000, 0.9));
        optimizers.add(new Annealer(new NeighborFunctions.SingleBitFlipper(), 1000, 0.99));

        return optimizers;
    }
}
