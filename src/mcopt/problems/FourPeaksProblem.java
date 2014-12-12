package mcopt.problems;

import mcopt.OptimizationProblem;

import java.util.BitSet;
import java.util.Random;

/**
 * "Four peaks" optimization problem. Contains four optima, two of which global.
 * Described more thoroughly in the following paper:
 * paper: http://papers.nips.cc/paper/1328-mimic-finding-optima-by-estimating-probability-densities.pdf
 */
public class FourPeaksProblem extends OptimizationProblem<BitSet> {
    private int length;
    private int t;

    public FourPeaksProblem(int length, int t) {
        this.length = length;
        this.t = t;
    }

    public String[] getColumns() {
        return new String[]{"length", "t"};
    }

    public String[] getData() {
        return new String[] {String.valueOf(length), String.valueOf(t)};
    }

    @Override
    public Double getTarget() {
        return (double)(length + (length - (t + 1)));
    }

    @Override
    public Double fitnessOfImpl(BitSet bitSet) {
        int idx = 0;

        int heads = 0;
        while (idx < length && bitSet.get(idx)) {
            heads++;
            idx++;
        }

        idx = length - 1;

        int tails = 0;
        while (idx >= 0 && !bitSet.get(idx)) {
            tails++;
            idx--;
        }

        int bonus = 0;

        if (heads > t && tails > t)
            bonus = length;

        return (double)(Math.max(heads, tails) + bonus);
    }

    @Override
    public BitSet getStartConfiguration() {
        BitSet set = new BitSet(length + 1);

        Random r = new Random();

        for (int i = 0; i < length; i++)
            set.set(i, r.nextBoolean());

        set.set(length, true);

        return set;
    }

    @Override
    public BitSet getRandomConfiguration() {
        return getStartConfiguration();
    }
}
