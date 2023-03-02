import java.util.Arrays;

public class PlayGround {

    public static void main(String[] args) {


        Genome genome1 = Genome.createGenome();
        Genome genome2 = Genome.createGenome();
        System.out.println(genome1);
        System.out.println("Fitness : "+genome1.fitness(27));
        genome1.mutate();
        System.out.println(genome1);
        System.out.println("Fitness : "+genome1.fitness(27));
        System.out.println(Arrays.toString(genome1.SPCrossOver(genome2)));
        System.out.println("////////////////////////////////");
        System.out.println("Genome 1 :" +genome1);
        System.out.println("Fitness : "+genome1.fitness(27));
        System.out.println("Genome 2 :" +genome2);
        System.out.println("Fitness : "+genome2.fitness(27));
        Genome[] children = genome1.SPCrossOver(genome2);
        System.out.println("Child 1 :" +children[0]);
        System.out.println("Fitness : "+children[0].fitness(27));
        System.out.println("Child 2 :" +children[1]);
        System.out.println("Fitness : "+children[1].fitness(27));


        // Population tests
        Population pop = new Population(10);
        System.out.println(pop);
        System.out.println(pop.selection()[0]+" and "+pop.selection()[1]);
        pop.getPopulation().add(pop.selection()[0].SPCrossOver(pop.selection()[1])[0]);
        pop.getPopulation().add(pop.selection()[0].SPCrossOver(pop.selection()[1])[1]);
        System.out.println(pop);
        System.out.println("////////////////////////////////");
        System.out.println("////////////////////////////////");
        pop.applyMutation(7);
        // I need to review the selection
        // Need to apply crosserOver
        //System.out.println("Usefulness of the apple : " +apple.getStuff().getUsefulness());
    }

}
