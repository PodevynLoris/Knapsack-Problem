package KP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import GA.Evolution;
import GA.Utils;


public class Genome {
//Wondering if the genome should be a list of gene or a list of 0101O0101 etc
    private final List<Gene> genome;
    public final int CAPACITY = Evolution.CAPACITY;

    public Genome(List<Gene> genome) {
        this.genome = Collections.unmodifiableList(genome);
    }

    public List<Gene> getGenome() {
        return genome;
    }

    public int getCAPACITY() {
        return CAPACITY;
    }

    public static Genome createGenome() {

        Random random = new Random();
        List<Stuff> stuffList = new ArrayList<>();
        Collections.addAll(stuffList, Stuff.values());

        final List<Gene> genes = new ArrayList<>();

        for (Stuff stuff : stuffList) {
            //TODO set a threshold for the # of ones and zeros (will help for the initial population)
            int ran = random.nextInt(2);
            genes.add(new Gene(stuff, ran));
        }
        return new Genome(genes);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for(final Gene gene : this.genome) {
            builder.append(gene.toString()).append((" "));
        }
        builder.append(" Fitness score : "+fitness());
        return builder.toString();
    }

    public int fitness(){
        int weight = 0;
        int usefulness = 0;
        for(Gene gene : this.genome) {
            if(gene.getInside()==1) {
                usefulness += gene.getStuff().getUsefulness();
                weight += gene.getStuff().getWeight();
                if(weight>getCAPACITY()) {
                    return 0;
                }
            }
        }
        return usefulness;
    }


    // Random bit flip
    public void  mutate() {
        Random random = new Random();
        int ran = random.nextInt(this.genome.size());
        this.genome.get(ran).setInside(Utils.flip(this.genome.get(ran).getInside()));
    }

    // Single Point CrossOver
    public Genome[] SPCrossOver(final Genome partner) {

        if(this.genome.size()!=partner.getGenome().size()) {
            throw new RuntimeException("The parent genomes are not the same size");
        }
        Random random = new Random();
        int[] parent1Binary = getBinaryArray();
        int[] parent2Binary = partner.getBinaryArray();
        //we consider cutting after the end also so length+1
        int indexCut = random.nextInt(parent1Binary.length+1);

        int[][] childrenBinary = swapArrays(parent1Binary,parent2Binary,indexCut);

        // Testing.....
        //System.out.println("Index cut : "+ indexCut + " and the length of the genome binary array is "+parent1Binary.length);
        // Testing.....

        Genome firstChild = Genome.createGenome();
        Genome secondChild = Genome.createGenome();
        for(int i=0; i<firstChild.getGenome().size(); i++) {
            firstChild.getGenome().get(i).setInside(childrenBinary[0][i]);
            secondChild.getGenome().get(i).setInside(childrenBinary[1][i]);
        }

        Genome[] children = new Genome[2];
        children[0] = firstChild;
        children[1] = secondChild;

        return children;
    }












    //UTILS
    public int[] getBinaryArray() {
        int[] binaryArray = new int[this.genome.size()];
        for(int i =0; i<this.genome.size(); i++) {
            binaryArray[i] = this.genome.get(i).getInside();
        }
        return binaryArray;
    }
    public int[][] swapArrays(int[]a,int[]b,int cut) {
        int m = 2;
        int n = a.length;
        int[][] children = new int[m][n];
        for(int i=0; i<a.length; i++) {
            if(i<=cut) {
                children[0][i] = a[i];
                children[1][i] = b[i];
            }
            else {
                children[0][i] = b[i];
                children[1][i] = a[i];
            }
        }
        return children;
        //int[] child1Binary = new int[parent1Binary.length];
        //int[] child2Binary = new int[parent1Binary.length];
        /* for(int i=0; i<parent1Binary.length; i++) {
            if(i<=indexCut) {
                child1Binary[i] = parent1Binary[i];
                child2Binary[i] = parent2Binary[i];
            }
            else {
                child1Binary[i] = parent2Binary[i];
                child2Binary[i] = parent1Binary[i];
            }
        }*/
    }

}
