package mcopt.experiments;

import mcopt.*;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class FourPeaksGlobalExperimenter extends FourPeaksLocalExperimenter {
    public static void main(String[] args) throws Exception {
        FourPeaksGlobalExperimenter exp = new FourPeaksGlobalExperimenter();
        exp.run("four-peaks-global", 10, Integer.MAX_VALUE);
    }

    @Override
    public List<RandomOptimizer<BitSet>> getOptimizers() {
        List optimizers = new ArrayList();

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
        optimizers.add(new Mimicker(200, 5));
        optimizers.add(new Mimicker(200, 10));

        optimizers.add(new Mimicker(400, 2));
        optimizers.add(new Mimicker(400, 5));
        optimizers.add(new Mimicker(400, 10));
        */

        return optimizers;
    }
}
