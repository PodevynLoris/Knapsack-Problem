import java.util.*;
import java.util.stream.Collectors;

public class Population {


    private final List<Genome> population;
    private final int populationSize;


    Population(int populationSize) {
        this.population = start(populationSize);
        this.populationSize = populationSize;
    }

    List<Genome> getPopulation() {
        return this.population;
    }


    private List<Genome> start(final int populationSize) {
        final List<Genome> startingPop = new ArrayList<>();
        for(int i=0; i<populationSize;i++) {
            final Genome genome = Genome.createGenome();
            startingPop.add(genome);
        }
        return startingPop;
    }


    /**
     * @param mutationRate : from 1 to population size , the bigger it is , the less the number of mutation
     */ //TODO Figure out if I need to
    public void applyMutation(int mutationRate) {
        Random random = new Random();
        for(int i=0; i<this.population.size()/mutationRate; i++) {
            int ran = random.nextInt(this.population.size());

            System.out.println("Genome "+ this.population.get(ran) + " is being mutated" );
            this.population.get(ran).mutate();
            System.out.println("Mutation applied it became : " + this.population.get(ran));
        }
    }


     Genome[] selection() {
        Collections.sort(this.population, (one, two) -> Integer.compare(two.fitness(27), one.fitness(27)));
        Genome[] best = new Genome[2];
        best[0] = this.population.get(0);
        best[1] = this.population.get(1);
        return best;
    }


    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        System.out.println("Initial Population of size : "+ this.populationSize);
        for(final Genome genome : this.population) {
            builder.append(genome.toString()).append(("\n"));
        }
        return builder.toString();
    }



}
