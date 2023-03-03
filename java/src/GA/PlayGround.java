package GA;

public class PlayGround {

    public static void main(String[] args) {



        // GA.Population tests
        Population pop = new Population(10);
        System.out.println(pop);
        System.out.println(pop.selection()[0]+" and "+pop.selection()[1]);
        pop.sortPopulation();
        pop.applySPCrosseOver();
        System.out.println(pop);
        System.out.println("////////////////////////////////");
        System.out.println("////////////////////////////////");
        pop.sortPopulation();
        pop.applyMutation(7);

        System.out.println("////////////////////////////////");
        System.out.println("////////////////////////////////");
        pop.growPopulation(3);
        pop.sortPopulation();
        System.out.println(pop);
        // I need to review the selection
        // Need to apply crosserOver
        //System.out.println("Usefulness of the apple : " +apple.getStuff().getUsefulness());
    }

}
