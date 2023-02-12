package JavaBasics;


    abstract class Shape {
        public static void main(String[] args) {
            Shape s = new Circle1();
            s.draw();
            s.cool();
        }
        abstract void draw();
        void cool()
        {
            System.out.println("Hellpo cool");
        }

    }



