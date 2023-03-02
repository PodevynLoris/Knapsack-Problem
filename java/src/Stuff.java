
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
