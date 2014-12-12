package mcopt.problems;

import mcopt.*;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class MaximumCutGlobalExperimenter extends MaximumCutLocalExperimenter {

    public static void main(String[] args) throws Exception {
        MaximumCutGlobalExperimenter exp = new MaximumCutGlobalExperimenter();
        exp.run("max-cut-globals", Integer.MAX_VALUE, 50);
    }

    @Override
    public List<RandomOptimizer<BitSet>> getOptimizers() {
        List optimizers = new ArrayList();

        optimizers.add(new Evolver(100, 25, new NeighborFunctions.SingleCrossover(), new NeighborFunctions.SingleBitMutator(), 10));
        optimizers.add(new Evolver(200, 50, new NeighborFunctions.SingleCrossover(), new NeighborFunctions.SingleBitMutator(), 20));
        optimizers.add(new Evolver(300, 75, new NeighborFunctions.SingleCrossover(), new NeighborFunctions.SingleBitMutator(), 30));
        optimizers.add(new Evolver(400, 100, new NeighborFunctions.SingleCrossover(), new NeighborFunctions.SingleBitMutator(), 40));

        /* Vary pop size over fixed keep and mutate % */
        optimizers.add(new Evolver(100, 25, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 10));
        optimizers.add(new Evolver(200, 50, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 20));
        optimizers.add(new Evolver(300, 75, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 30));
        optimizers.add(new Evolver(400, 100, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 40));
        optimizers.add(new Evolver(500, 125, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 50));
        optimizers.add(new Evolver(1000, 250, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 100));

        optimizers.add(new Evolver(400,  10, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 40));
        optimizers.add(new Evolver(400,  50, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 40));
        optimizers.add(new Evolver(400, 100, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 40));
        optimizers.add(new Evolver(400, 150, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 40));
        optimizers.add(new Evolver(400, 200, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 40));

        optimizers.add(new Evolver(400, 100, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 10));
        optimizers.add(new Evolver(400, 100, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 50));
        optimizers.add(new Evolver(400, 100, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 100));
        optimizers.add(new Evolver(400, 100, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 150));
        optimizers.add(new Evolver(400, 100, new NeighborFunctions.UniformCrossover(), new NeighborFunctions.SingleBitMutator(), 200));

        /*
        optimizers.add(new Mimicker(200, 2));
        optimizers.add(new Mimicker(200, 5));
        optimizers.add(new Mimicker(200, 10));
        optimizers.add(new Mimicker(200, 25));

        optimizers.add(new Mimicker(400, 2));
        optimizers.add(new Mimicker(400, 5));
        optimizers.add(new Mimicker(400, 10));
        optimizers.add(new Mimicker(400, 25));
        */

        return optimizers;
    }
}
