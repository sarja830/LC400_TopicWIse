package JavaBasics;

class ChildClass extends Constructors
{
    ChildClass() {
        System.out.println("Hello Child");
    }
}

public class Constructors {
    public static void main(String[] args) {
        ChildClass c = new ChildClass();
    }
    Constructors()
    {
        System.out.println("Hello parent");
    }
}
