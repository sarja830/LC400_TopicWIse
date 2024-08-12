package JavaBasics;
import OOPS.AccessModifier.package1.A;

import java.util.*;
public class Circle1 extends Shape{
    @Override
    void draw() {
        System.out.print("cicel");
    }

    public static void main(String[] args) {
        Shape ss = new Circle1();
        Circle1 ss2 = new Circle1();
        ss.draw();
        ss2.listTest();
    }

    List<Integer> listTest()
    {
        ArrayList<Integer> a = new ArrayList<>();
        return a;
    }
    //In real scenario, implementation is provided by others i.e. unknown by end user

}
