package OOPS.AccessModifier.package2;

import OOPS.AccessModifier.package1.A;

//public class B extends A {
//    public static void main(String[] args) {
//        B obj = new B();
//        obj.display();
//
//    }
//
//}
public class B {
    public static void main(String[] args) {
        B obj = new B();
        A obj1 = new A();
        obj1.displayPublicVariable();

    }

}
