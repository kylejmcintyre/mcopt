mcopt
=====

Java library for randomized optimization. Includes several toy problems and experimentation harness.

This code was developed primarily in support of my enrollment in CS7641 at Georgia Tech. It
supports hill-climbing, simulated annealing, genetic algorithms (extensible crossover/mutation capabilities) as well
as a wrapper around ABAGAIL's (https://github.com/pushkar/ABAGAIL) implementation of  the
MIMIC algorithm. 

Highlights include:
  * Uses Java generics to represent the problem's encoding type. Thus the algorithms are 
    separate from various possible encoding types. 
  * Toy problems for "I'm thinking of a number", Four Peaks, and Graph Maximum Cut
  * Support for automatic termination of the optimization loop
  * Support for automatic restarts
  * Experiment harness handles invoking RO algorithm multiple times and computing summary statistics on performance
  * Computes useful metrics such as the average number of fitness function evaluations to
    maximize a problem with a known solution, or the cost in fitness function evals per unit 
    of fitness for problems where the optimum is unkown.
    
See example.tsv in this directory for example experiment output from the four peaks problem. 

mcopt can be used for continuous space problems. I used it to optimize weights in an ANN. However,
no continous examples are currently included in the repo. MIMIC only works on BitSet problems.

Dependencies:
  * Apache commons lang3
  * Apache commons math
  * ABAGAIL (optional, required to use MIMIC)
