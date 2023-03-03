package GA;

import java.util.TimerTask;
import java.util.Timer;

public class Evolution {

    static final int INITIAL_POPULATION_SIZE = 5;
    public static Population population;
    public static final int CAPACITY = 50;

    public Evolution() {
        population = new Population(INITIAL_POPULATION_SIZE);
    }

    public void startEvolution(int mutationRate, int newPopAddedSize, long delay) {

        FitnessChart chart = new FitnessChart();
        TimerTask updateTask = new TimerTask() {
            private int generation = 0;
            @Override
            public void run() {
                population.update(mutationRate, newPopAddedSize);
                int fitness = population.getAlpha().fitness();
                chart.updateChart(fitness, generation++);
                //System.out.println(population.getAlpha());
            }
        };
        Timer timer = new Timer();
        timer.schedule(updateTask, 0, delay);
    }

    public static void main(String[] args) {
        Evolution evolution = new Evolution();
        evolution.startEvolution(7, 1, 50); // Update population every 1 second
    }



}
