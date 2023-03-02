
public class Gene {

    private  int inside;
    private  Stuff stuff;

    //Constructor
    public Gene(Stuff stuff, int inside) {
        this.stuff = stuff;
        this.inside = inside;
    }
    //Getters
    public Stuff getStuff() {
        return this.stuff;
    }

    public int getInside() {
        return this.inside;
    }

    public void setInside(int in) {
         this.inside = in;
    }


    @Override
    public String toString() {
        return "[" + this.stuff + ","+this.inside + "]";
    }

}
