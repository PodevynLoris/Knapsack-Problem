package TSP;

public class PlayGround {

    public static void main(String[] args) {

        GenomeTSP genomeTSP = GenomeTSP.createGenomeTSP();
        GenomeTSP genomeTSP2 = GenomeTSP.createGenomeTSP();
        System.out.println(genomeTSP);
        System.out.println(Math.round(genomeTSP.fitnessTSP()));
        genomeTSP.mutateTSP();
        System.out.println(genomeTSP);
        System.out.println(Math.round(genomeTSP.fitnessTSP()));
        System.out.println("////////////");
        GenomeTSP[] array;
        System.out.println(genomeTSP);
        System.out.println(genomeTSP2);
        array = genomeTSP.SPCrossOverTSP(genomeTSP2);
        System.out.println("Child1 -> "+array[0]);
        System.out.println("Child2 -> "+array[1]);
    }
}
