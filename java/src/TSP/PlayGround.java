package TSP;

public class PlayGround {

    public static void main(String[] args) {
        GeneTSP geneTSP = new GeneTSP(1,2);
        System.out.println(geneTSP);
        GenomeTSP genomeTSP = GenomeTSP.createGenomeTSP();
        System.out.println(genomeTSP);
    }
}
