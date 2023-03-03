package KP;

public enum Stuff
{
    APPLE {
        @Override
        public String getName() {
            return "Apple";
        }

        @Override
        public int getUsefulness() {
            return 5;
        }

        @Override
        public int getWeight() {
            return 6;
        }

    },
    ORANGE {
        @Override
        public String getName() {
            return "Orange";
        }

        @Override
        public int getUsefulness() {
            return 6;
        }

        @Override
        public int getWeight() {
            return 6;
        }

    },
    LEMON {
        @Override
        public String getName() {
            return "Lemon";
        }

        @Override
        public int getUsefulness() {
            return 4;
        }

        @Override
        public int getWeight() {
            return 2;
        }

    },
    BLUEBERRY {
        @Override
        public String getName() {
            return "Blueberry";
        }

        @Override
        public int getUsefulness() {
            return 3;
        }

        @Override
        public int getWeight() {
            return 1;
        }

    },
    STRAWBERRY {
        @Override
        public String getName() {
            return "Strawberry";
        }

        @Override
        public int getUsefulness() {
            return 2;
        }

        @Override
        public int getWeight() {
            return 3;
        }

    },
    CARROT {
        @Override
        public String getName() {
            return "Carrot";
        }

        @Override
        public int getUsefulness() {
            return 5;
        }

        @Override
        public int getWeight() {
            return 2;
        }

    },
    PEAR {
        @Override
        public String getName() {
            return "Pear";
        }

        @Override
        public int getUsefulness() {
            return 6;
        }

        @Override
        public int getWeight() {
            return 6;
        }

    },
    KIWI {
        @Override
        public String getName() {
            return "Kiwi";
        }

        @Override
        public int getUsefulness() {
            return 1;
        }

        @Override
        public int getWeight() {
            return 1;
        }

    },

    GLOVES {
        @Override
        public String getName() {
            return "Gloves";
        }

        @Override
        public int getUsefulness() {
            return 6;
        }

        @Override
        public int getWeight() {
            return 2;
        }

    },
    JACKET {
        @Override
        public String getName() {
            return "Jacket";
        }

        @Override
        public int getUsefulness() {
            return 8;
        }

        @Override
        public int getWeight() {
            return 7;
        }

    },
    FANTA {
        @Override
        public String getName() {
            return "Fanta";
        }

        @Override
        public int getUsefulness() {
            return 2;
        }

        @Override
        public int getWeight() {
            return 4;
        }

    },
    COCA {
        @Override
        public String getName() {
            return "Coca";
        }

        @Override
        public int getUsefulness() {
            return 2;
        }

        @Override
        public int getWeight() {
            return 4;
        }

    },


    SHOES {
        @Override
        public String getName() {
            return "Shoes";
        }

        @Override
        public int getUsefulness() {
            return 3;
        }

        @Override
        public int getWeight() {
            return 3;
        }

    },
    HAT {
        @Override
        public String getName() {
            return "Hat";
        }

        @Override
        public int getUsefulness() {
            return 4;
        }

        @Override
        public int getWeight() {
            return 2;
        }

    },
    GLASSES {
        @Override
        public String getName() {
            return "Glasses";
        }

        @Override
        public int getUsefulness() {
            return 7;
        }

        @Override
        public int getWeight() {
            return 1;
        }

    },
    PC {
        @Override
        public String getName() {
            return "Pc";
        }

        @Override
        public int getUsefulness() {
            return 10;
        }

        @Override
        public int getWeight() {
            return 10;
        }

    },
    Phone {
        @Override
        public String getName() {
            return "Phone";
        }

        @Override
        public int getUsefulness() {
            return 9;
        }

        @Override
        public int getWeight() {
            return 2;
        }

    },
    WATER {
        @Override
        public String getName() {
            return "Water";
        }

        @Override
        public int getUsefulness() {
            return 9;
        }

        @Override
        public int getWeight() {
            return 3;
        }

    },


    MCDO {
        @Override
        public String getName() {
            return "McDo";
        }

        @Override
        public int getUsefulness() {
            return 1;
        }

        @Override
        public int getWeight() {
            return 10;
        }

    },
    BEANS {
        @Override
        public String getName() {
            return "Beans";
        }

        @Override
        public int getUsefulness() {
            return 10;
        }

        @Override
        public int getWeight() {
            return 2;
        }

    },
    WATERMELON {
        @Override
        public String getName() {
            return "Watermelon";
        }

        @Override
        public int getUsefulness() {
            return 3;
        }

        @Override
        public int getWeight() {
            return 9;
        }


    };
    public abstract int getWeight();
    public abstract String getName();
    public abstract int getUsefulness();

}
