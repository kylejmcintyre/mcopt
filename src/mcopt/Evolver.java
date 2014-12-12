package mcopt;

import mcopt.util.Pair;

import java.util.*;

/**
 * Genetic Algorithm implementation. Takes breeder (crossover implementation) and mutator
 * as input.
 */
public class Evolver<T> extends RandomOptimizer<T> {
    private List<T> population;
    private int popKeep;
    private int popSize;
    private Breeder<T> breeder;
    private Mutator<T> mutator;
    private Random r = new Random();

    private int toMutate;

    /**
     * Use this interface to implement various types of population breeding
     * @param <T>
     */
    public interface Breeder<T> {
        public T breed(T m, T d);
    }

    /**
     * Use this interface to implement various types of mutations
     * @param <T>
     */
    public interface Mutator<T> {
        public T mutate(T t);
    }

    public String toString() {
        return "Evolver(size=" + popSize + ",keep=" + popKeep + ",breeder=" + breeder.getClass().getSimpleName() + ",toMutate=" + toMutate + ",mutator=" + (mutator == null ? null : mutator.getClass().getSimpleName()) + ")";
    }

    public void resetImpl() {
        this.population = new ArrayList<T>(popSize);

        for (int i = 0; i < popSize; i++)
            population.add(problem.getRandomConfiguration());
    }

    public Evolver(int popSize, int popKeep, Breeder<T> breeder, Mutator<T> mutator, int toMutate) {

        this.popKeep = popKeep;
        this.popSize = popSize;

        this.mutator = mutator;
        this.breeder = breeder;

        this.toMutate = toMutate;

        this.maxStale = 10;
    }

    @Override
    public Pair iterate() {
        final Map<T, Double> scored = new HashMap();

        for (int i = 0; i < population.size(); i++) {
            T individual = population.get(i);
            scored.put(individual, problem.fitnessOf(individual));
        }

        Comparator<T> comparator = new Comparator<T>() {
            public int compare(T a, T b) {
                if (scored.get(a) >= scored.get(b)) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };

        SortedMap<T, Double> sorted = new TreeMap(comparator);
        sorted.putAll(scored);

        List<T> studs = new ArrayList<T>();

        for (Map.Entry<T, Double> entry : sorted.entrySet())
            if (studs.size() < popKeep)
                studs.add(entry.getKey());
            else
                break;

        population = new ArrayList<T>();

        // We've got our studs, now reproduce
        for (int i = popKeep; i < popSize; i++) {
            // Creepily, your mom could be your dad.
            T m = studs.get(r.nextInt(popKeep));
            T d = studs.get(r.nextInt(popKeep));

            population.add(breeder.breed(m, d));
        }

        population.addAll(studs);

        assert(population.size() == popSize);

        // Lastly, mutate
        if (mutator != null) {
            for (int i = 0; i < toMutate; i++) {
                int idx = r.nextInt(popSize);
                T man  = population.get(idx);
                T xman = mutator.mutate(man);
                population.set(idx, xman);
            }
        }

        assert(population.size() == popSize);

        Map.Entry<T, Double> localBest = sorted.entrySet().iterator().next();

        return new Pair<T, Double>(localBest.getKey(), localBest.getValue());
    }
}
