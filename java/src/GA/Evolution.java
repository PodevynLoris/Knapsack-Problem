package GA;

import java.util.TimerTask;
import java.util.Timer;

public class Evolution {

    public static Population population;
    static final int INITIAL_POPULATION_SIZE = 100;
    public static final int CAPACITY = 50;
    public static int mutationRate = 7;
    public static int newPopAddedSize = 2;


    public static int choice = 0;


    public Evolution() {
        population = new Population(INITIAL_POPULATION_SIZE);
    }

    public void startEvolution(long delay) {

        FitnessChart chart = new FitnessChart();
        TimerTask updateTask = new TimerTask() {
            private int generation = 0;
            @Override
            public void run() {
                double fitness = 0.0;
                population.update();
                if(choice==0) {
                    fitness = population.getAlpha().fitness();
                }
                else {
                    fitness = population.getAlphaTSP().fitnessTSP();
                }

                chart.updateChart(fitness, generation++);
                //System.out.println(population.getAlpha());
            }
        };
        Timer timer = new Timer();
        timer.schedule(updateTask, 0, delay);
    }

    public static void main(String[] args) {
        Evolution evolution = new Evolution();
        evolution.startEvolution(50);
    }



}
