package mcopt.experiments;

import mcopt.*;
import mcopt.problems.ItoanProblem;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class ItoanExperimenter extends Experiment<BitSet> {
    public static void main(String[] args) throws Exception {
        ItoanExperimenter exp = new ItoanExperimenter();
        exp.run("itoan", 50, Integer.MAX_VALUE);
    }

    @Override
    public List<OptimizationProblem<BitSet>> getProblems() {
        List problems = new ArrayList();

        problems.add(new ItoanProblem(50, 19));
        problems.add(new ItoanProblem(100, 31));
        problems.add(new ItoanProblem(200, 51));

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

        optimizers.add(new Evolver(100, 50, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 10));
        optimizers.add(new Evolver(100, 50, new NeighborFunctions.SingleCrossover(), new NeighborFunctions.SingleBitMutator(), 10));
        optimizers.add(new Evolver(200, 50, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 10));
        optimizers.add(new Evolver(200, 50, new NeighborFunctions.SingleCrossover(), new NeighborFunctions.SingleBitMutator(), 10));
        optimizers.add(new Evolver(200, 100, new NeighborFunctions.SingleCrossover(), new NeighborFunctions.SingleBitMutator(), 10));
        optimizers.add(new Evolver(200, 100, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 10));
        optimizers.add(new Evolver(400, 100, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 10));
        optimizers.add(new Evolver(400, 100, new NeighborFunctions.SingleCrossover(), new NeighborFunctions.SingleBitMutator(), 10));
        optimizers.add(new Evolver(400, 200, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 10));
        optimizers.add(new Evolver(400, 200, new NeighborFunctions.SingleCrossover(), new NeighborFunctions.SingleBitMutator(), 10));

        /*
        optimizers.add(new Mimicker(200, 2));
        optimizers.add(new Mimicker(200, 4));
        optimizers.add(new Mimicker(200, 6));

        optimizers.add(new Mimicker(400, 2));
        optimizers.add(new Mimicker(400, 4));
        optimizers.add(new Mimicker(400, 6));
        */

        return optimizers;
    }
}
