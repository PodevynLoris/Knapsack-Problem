public class Main {


    static final int INITIAL_POPULATION_SIZE = 11;
    static Population population = new Population(INITIAL_POPULATION_SIZE);
    public static void main(String[] args) {

        System.out.println(population);
        population.update1(7, 0, 100);
        //TODO : Either I change in the toString method the max weight every time, or I create a max weight instance for the genome
        // Max weight is used in sort() mutate() , applyMutation(), and toString() for the genome
        System.out.println("Final population of size " + population.getPopulation().size());
        System.out.println("Alpha genome : " + population.selection()[0]);

    }
}
