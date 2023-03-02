public class Evolution {

    static final int initialPopulationSize = 10;

    public static void main(String[] args) {

        Population population = new Population(initialPopulationSize);
        System.out.println(population);
        population.update(7,2,100);
        System.out.println("Final population of size "+ population.getPopulation().size());
        System.out.println(population);
    }
}
