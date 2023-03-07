package TSP;

import GA.Population;

public class PlayGround {

    public static void main(String[] args) {

       /*
       * GenomeTSP genomeTSP = GenomeTSP.createGenomeTSP();
        GenomeTSP genomeTSP2 = GenomeTSP.createGenomeTSP();
        System.out.println(genomeTSP);
        System.out.println(genomeTSP.fitnessTSP());
        genomeTSP.mutateTSP();
        System.out.println(genomeTSP);
        System.out.println(genomeTSP.fitnessTSP());
        System.out.println("////////////");
        GenomeTSP[] array;
        System.out.println(genomeTSP);
        System.out.println(genomeTSP.fitnessTSP());
        System.out.println(genomeTSP2);
        System.out.println(genomeTSP2.fitnessTSP());
        array = genomeTSP.SPCrossOverTSP(genomeTSP2);
        GenomeTSP child1 = array[0];
        GenomeTSP child2 = array[1];
        System.out.println("Child1 -> "+array[0]);
        System.out.println(Math.round(child1.fitnessTSP()));
        System.out.println("Child2 -> "+array[1]);

        System.out.println(child2.fitnessTSP());
       * */


        Population pop = new Population(5);
        System.out.println(pop);
        pop.sortPopulation();
        System.out.println(pop);
        System.out.println(pop.getAlphaTSP());
        System.out.println(pop);

       // GenomeTSP genomeTest = GenomeTSP.createCircleGenomeTSP();
       // System.out.println(genomeTest);


    }
}
