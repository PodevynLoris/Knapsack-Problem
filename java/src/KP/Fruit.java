package KP;

public enum Fruit {
    APPLE("Apple", 5, 6),
    ORANGE("Orange", 6, 6),
    LEMON("Lemon", 4, 2),
    BLUEBERRY("Blueberry", 3, 1),
    STRAWBERRY("Strawberry", 2, 3),
    CARROT("Carrot", 5, 2),
    PEAR("Pear", 6, 6),
    KIWI("Kiwi", 1, 1),
    MCDO("McDo", 1, 10),
    BEANS("Beans", 10, 2),
    WATERMELON("Watermelon", 3, 9);

    private final String name;
    private final int usefulness;
    private final int weight;

    Fruit(String name, int usefulness, int weight) {
        this.name = name;
        this.usefulness = usefulness;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getUsefulness() {
        return usefulness;
    }

    public int getWeight() {
        return weight;
    }
}
