package TSP;

import GA.Evolution;
import GA.Utils;

import java.util.*;

public class GenomeTSP {

    public final List<GeneTSP> genomeTSP;
    public static final int genomeTSPSize = Evolution.numberOfPointsForTSP;


    public GenomeTSP(List<GeneTSP> genome) {
        this.genomeTSP = Collections.unmodifiableList(genome);
    }

    public List<GeneTSP> getGenomeTSP() {
        return this.genomeTSP;
    }

    public static int getGenomeTSPSize() {
        return genomeTSPSize;
    }

    public static GenomeTSP createGenomeTSP() {

        Random random = new Random();
        List<GeneTSP> original = new ArrayList<>();
        for (int i = 0; i < genomeTSPSize; i++) {
            int ranX = random.nextInt(GeneTSP.getMAX_SIZE());
            int ranY = random.nextInt(GeneTSP.getMAX_SIZE());
            GeneTSP gene = new GeneTSP(ranX, ranY);
            original.add(gene);
        }
        return new GenomeTSP(original);
    }

    public static GenomeTSP createCircleGenomeTSP() {
        Random random = new Random();
        int centerX = 50;
        int centerY = 50;
        int radius = 25;
        List<GeneTSP> data = new ArrayList<>();

        for (int i = 0; i < genomeTSPSize; i++) {

            double angle = random.nextDouble() * 2 * Math.PI;
            int x = (int) (centerX + radius * Math.cos(angle));
            int y = (int) (centerY + radius * Math.sin(angle));
            //double a = random.nextInt(360);
            //int ranX = (int)(circleCenterX+radius*Math.cos(a));
            //int ranY = (int)(circleCenterY+radius*Math.sin(a));
            GeneTSP gene = new GeneTSP(x,y);
            data.add(gene);
        }
        return new GenomeTSP(data);
    }


      //  Collections.shuffle(list);
      //  return new GenomeTSP(list);
      //  for(int i = 0; i< genomeTSPSize; i++) {
        //       int ranX = random.nextInt(GeneTSP.getMAX_SIZE());
        //      int ranY = random.nextInt(GeneTSP.getMAX_SIZE());
        //     GeneTSP gene = new GeneTSP(ranX,ranY);
        //     list.add(gene);

       // return new GenomeTSP(list);


    public double fitnessTSP() {
        double fitness = 0.0;
        for(int i=0; i<this.genomeTSP.size()-1;i++) {
            fitness += Utils.euclideanDistance(this.genomeTSP.get(i),this.genomeTSP.get(i+1));
        }
        fitness += Utils.euclideanDistance(this.genomeTSP.get(this.getGenomeTSP().size()-1),this.genomeTSP.get(0));
        return fitness;
    }

    public void mutateTSP() {
        Random random = new Random();
        int ran = random.nextInt(this.genomeTSP.size());
        int ran2 = random.nextInt(this.genomeTSP.size());

        while(ran == ran2) {
            ran = random.nextInt(this.getGenomeTSP().size());
            ran2 = random.nextInt(this.getGenomeTSP().size());
        }
        GeneTSP temp = new GeneTSP(this.genomeTSP.get(ran).getX(),this.genomeTSP.get(ran).getY());
        this.genomeTSP.get(ran).setX(this.genomeTSP.get(ran2).getX());
        this.genomeTSP.get(ran).setY(this.genomeTSP.get(ran2).getY());
        this.genomeTSP.get(ran2).setX(temp.getX());
        this.genomeTSP.get(ran2).setY(temp.getY());
    }

    public GenomeTSP[] SPCrossOverTSP(final GenomeTSP partner)
    {
        List<GeneTSP> child1 = new ArrayList<>(this.genomeTSP.size());
        List<GeneTSP> child2 = new ArrayList<>(this.genomeTSP.size());

        Random random = new Random();
        int ran = random.nextInt(1,this.genomeTSP.size()-1);
        System.out.println("Cut after element "+(ran+1));

        for(int i=0; i<=ran;i++) {
            child1.add(this.genomeTSP.get(i));
            child2.add(partner.getGenomeTSP().get(i));
        }
        for(int i=ran+1; i<this.genomeTSP.size();i++) {

            child1.add(partner.getGenomeTSP().get(i));
            child2.add(this.genomeTSP.get(i));
        }
        return new GenomeTSP[] {
                new GenomeTSP((child1)),new GenomeTSP(child2)
        };
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for(final GeneTSP gene : this.genomeTSP) {
            builder.append(gene.toString()).append((" "));
        }
        builder.append(" Fitness score : "+fitnessTSP());
        return builder.toString();
    }







}
