import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Population {


    private final List<Genome> population;
    private final int populationSize;


    Population(int populationSize) {
        this.population = start(populationSize);
        this.populationSize = populationSize;
    }

    public int getPopulationSize(){
        return this.populationSize;
    }

    List<Genome> getPopulation() {
        return this.population;
    }


    void update(int mutationRate, int newPopAddedSize, int numberOfGeneration) {
        int i = 0;
        while(i<numberOfGeneration) {

            sortPopulation();
            selection();
            applySPCrosseOver();
            applyMutation(mutationRate);
            growPopulation(newPopAddedSize);
            i++;
        }

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
     */ //TODO Check question in report
    public void applyMutation(int mutationRate) {
        Random random = new Random();
        for(int i=0; i<=this.population.size()/mutationRate; i++) {
            int ran = random.nextInt(this.population.size());
            //System.out.println("Genome "+ this.population.get(ran) + " is being mutated" );
            this.population.get(ran).mutate();
            //System.out.println("Mutation applied it became : " + this.population.get(ran));
        }
    }


    public void growPopulation(int newPopAddedSize) {
        this.population.addAll(start(newPopAddedSize));
    }

    public void sortPopulation() {
        Collections.sort(this.population, (one, two) -> Integer.compare(two.fitness(27), one.fitness(27)));
    }

    public void applySPCrosseOver() {
        this.population.add(selection()[0].SPCrossOver(selection()[1])[0]);
        this.population.add(selection()[0].SPCrossOver(selection()[1])[1]);
    }

    //TODO CHANGE METHOD SELECTION AND APPLY CROSSOVER AND CROSSEVER DEPENDING ON THE ELTISM SIZE
    // AND DEPENDING ON IF WE CROSSOVER THE BESTS TOGETHER OR RANDOMS TOGETHER

    Genome[] selection() {
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
