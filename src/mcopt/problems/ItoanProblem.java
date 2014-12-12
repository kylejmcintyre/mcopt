package mcopt.problems;

import mcopt.OptimizationProblem;

import java.util.BitSet;
import java.util.Random;

/**
 * I'm Thinking of a Number - Simple optimization problem with a single
 * global optimum. Naturally, RHC dominates this problem...
 */

public class ItoanProblem extends OptimizationProblem<BitSet> {
    private BitSet number;
    private int bits;

    public ItoanProblem(int bits, int seed) {
        this. bits = bits;

        Random r = new Random(seed);

        number = new BitSet(bits + 1);

        for (int i = 0; i < bits; i++)
            number.set(i, r.nextBoolean());

        number.set(bits, true);
    }

    public String[] getColumns() {
        return new String[]{"bits"};
    }

    public String[] getData() {
        return new String[] {String.valueOf(bits)};
    }
    @Override
    public Double fitnessOfImpl(BitSet o) {
        double fitness = 0.0;

        for (int i = 0; i < number.length() - 1; i++) {
            if (o.get(i) == number.get(i))
                fitness += 1;
        }

        return fitness;
    }

    @Override
    public BitSet getStartConfiguration() {
        return getRandomConfiguration();
    }

    @Override
    public BitSet getRandomConfiguration() {
        Random r = new Random();
        BitSet c = new BitSet(bits + 1);
        for (int i = 0; i <= bits; i++)
            c.set(i, r.nextBoolean());

        c.set(bits, true);
        return c;
    }

    @Override
    public Double getTarget() {
        return (double)(number.length() - 1);
    }
}
