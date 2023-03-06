package GA;

import KP.Genome;
import TSP.GeneTSP;
import TSP.GenomeTSP;

import java.util.*;

public class Population {

    public final List<Genome> population;
    public final List<GenomeTSP> populationTSP;
    public final int populationSize;
    public static int mutationRate = Evolution.mutationRate;
    public static int newPopAddedSize = Evolution.newPopAddedSize ;
    public int choice = Evolution.choice;

    public Population(int populationSize) {
        if(this.choice==0) {
            this.population = start(populationSize);
            this.populationTSP = null;
        }
        else {
            this.populationTSP = startTSP(populationSize);
            this.population = null;
        }
        this.populationSize = populationSize;
    }



    public int getPopulationSize(){
        return this.populationSize;
    }

    List<Genome> getPopulation() {
        return this.population;
    }

    List<GenomeTSP> getPopulationTSP() {
        return this.populationTSP;
    }


    void update() {
        if(this.choice ==0) {
            updateKP();
        }
        if(this.choice ==1) {
            updateTSP();
        }
    }
    void updateKP() {
            selection();
            applySPCrosseOver();
            applyMutation();
            growPopulation();
    }
    private void updateTSP() {
        selectionTSP();
        applySPCrosseOver();
        applyMutation();
        //growPopulation();
    }
    void update1(int numberOfGeneration) {
       int i = 0;
       while(i<numberOfGeneration) {
        selection();
        applySPCrosseOver();
        applyMutation();
        growPopulation();
        i++;
        }
    }


    public List<Genome> start(final int populationSize) {
        final List<Genome> startingPop = new ArrayList<>();
        for(int i=0; i<populationSize;i++) {
            final Genome genome = Genome.createGenome();
            startingPop.add(genome);
        }
        return startingPop;
    }
    private List<GenomeTSP> startTSP(int populationSize) {
        final List<GenomeTSP> startingPop = new ArrayList<>();
        GenomeTSP genome = GenomeTSP.createGenomeTSP();
        startingPop.add(genome);

        for (int i = 1; i < populationSize; i++) {
            List<GeneTSP> shuffledGenes = new ArrayList<>(genome.getGenomeTSP());
            Collections.shuffle(shuffledGenes);
            GenomeTSP newGenome = new GenomeTSP(shuffledGenes);
            startingPop.add(newGenome);
        }

        return startingPop;
    }


    public void applyMutation() {
        Random random = new Random();
        for(int i=0; i<=populationSize/mutationRate; i++) {
            int ran = random.nextInt(populationSize);
            //System.out.println("KP.Genome "+ this.population.get(ran) + " is being mutated" );
            if(choice==0) {
                this.population.get(ran).mutate();
            }
            else {
                this.populationTSP.get(ran).mutateTSP();
            }

            //System.out.println("Mutation applied it became : " + this.population.get(ran));
        }
    }


    public void growPopulation() {
        if(choice==0) {
            this.population.addAll(start(newPopAddedSize));
        }
        else {
            this.populationTSP.addAll(startTSP(newPopAddedSize));
        }
    }

    // TODO CHANGE THE FITNESS OF TSP TO 1/FITNESS OR CHANGE THIS METHOD !!!! Because it will sort the collection from big to small fitness
    // TODO NOW IVE SET THE FITNESS TO 1/FITNES , but we could keep this method and just change the selection method to renth the two last elements and the getAlpha
    public void sortPopulation() {
        if(choice==0) {
            Collections.sort(this.population, (one, two) -> Integer.compare(two.fitness(), one.fitness()));
        }
        else {
            Collections.sort(this.populationTSP, (one, two) -> Double.compare(two.fitnessTSP(), one.fitnessTSP()));
        }
    }

    public void applySPCrosseOver() {
        if(choice==0) {
            this.population.add(selection()[0].SPCrossOver(selection()[1])[0]);
            this.population.add(selection()[0].SPCrossOver(selection()[1])[1]);
        }
        else {
            this.populationTSP.add(selectionTSP()[0].SPCrossOverTSP(selectionTSP()[1])[0]);
            this.populationTSP.add(selectionTSP()[0].SPCrossOverTSP(selectionTSP()[1])[1]);
        }
    }

    //TODO CHANGE METHOD SELECTION AND APPLY CROSSOVER AND CROSSEVER DEPENDING ON THE ELTISM SIZE
    // AND DEPENDING ON IF WE CROSSOVER THE BESTS TOGETHER OR RANDOMS TOGETHER

    Genome[] selection() {
        sortPopulation();
        Genome[] best = new Genome[2];
        best[0] = this.population.get(0);
        best[1] = this.population.get(1);
        return best;
    }
    GenomeTSP[] selectionTSP() {
        sortPopulation();
        GenomeTSP[] best = new GenomeTSP[2];
        best[0] = this.populationTSP.get(0);
        best[1] = this.populationTSP.get(1);
        return best;
    }

    Genome getAlpha() {
            sortPopulation();
            return this.population.get(0);
    }

    GenomeTSP getAlphaTSP() {
        sortPopulation();
        return this.populationTSP.get(0);
    }


    public int getAverageFitness() {
        int avg =  0;
        for(Genome genome : this.population) {
            avg+= genome.fitness();
        }
        avg = avg / this.populationSize;
        return avg;
    }


    @Override
    public String toString() {
        if (choice==0) {
            final StringBuilder builder = new StringBuilder();
            System.out.println("Initial GA.Population of size : " + this.populationSize);
            for (final Genome genome : this.population) {
                builder.append(genome.toString()).append(("\n"));
            }
            return builder.toString();
        }
        else {
            final StringBuilder builder = new StringBuilder();
            System.out.println("Initial GA.Population of size : " + this.populationSize);
            for (final GenomeTSP genome : this.populationTSP) {
                builder.append(genome.toString()).append(("\n"));
            }
            return builder.toString();
        }
    }


}
