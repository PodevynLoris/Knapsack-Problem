package TSP;

import KP.Gene;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenomeTSP {

    public final List<GeneTSP> genomeTSP;
    public static final int genomeTSPSize = 10;


    public GenomeTSP(List<GeneTSP> genome) {
        this.genomeTSP = genome;
    }


    public List<GeneTSP> getGenomeTSP() {
        return this.genomeTSP;
    }

    public static int getGenomeTSPSize() {
        return genomeTSPSize;
    }

    public static GenomeTSP createGenomeTSP() {
        Random random = new Random();
        List<GeneTSP> list = new ArrayList<>();
        for(int i = 0; i< genomeTSPSize; i++) {
            int ranX = random.nextInt(GeneTSP.getMAX_SIZE());
            int ranY = random.nextInt(GeneTSP.getMAX_SIZE());
            GeneTSP gene = new GeneTSP(ranX,ranY);
            list.add(gene);
        }
        return new GenomeTSP(list);
    }





    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for(final GeneTSP gene : this.genomeTSP) {
            builder.append(gene.toString()).append((" "));
        }
        return builder.toString();
    }

}
