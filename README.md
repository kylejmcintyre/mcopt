mcopt
=====

Java library for randomized optimization. Includes several toy problems and experimention harness.

This code was developed primarily in support of my enrollment in CS7641 at Georgia Tech. It
supports hill-climbing, simulated annealing, genetic algorithms (single and uniform crossover) as well
as a wrapper around ABAGAIL's (https://github.com/pushkar/ABAGAIL) implementation of  the
MIMIC algorithm. 

Highlights include:
  * Uses Java generics to represent the problem's encoding type. Thus the algorithms are 
    separate from various possible encoding types. Toy problems all use a BitSet representation.
  * Toy problems for "I'm thinking of a number", Four Peaks, and Graph Maximum Cut
  * Support for automatic termination of the optimization loop
  * Support for automatic restarts
  * Computes useful metrics such as the average number of fitness function evaluations to
    maximize a problem with a known solution, or the cost in fitness function evals per unit 
    of fitness for problems where the optimum is unkown.
    
The last three bullets distinguish this library from ABAGAIL which requires the user
to specify the number of iterations which is generally unknown to the user and may result in
running an algorithm long after it has converged. See example.tsv in this directory for 
example experiment output. 

mcopt can be used for continuous space problems. I used it to optimize weights in an ANN. However,
no continous examples are currently included in the repo. MIMIC only works on BitSet problems.
