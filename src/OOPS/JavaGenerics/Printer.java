package OOPS.JavaGenerics;
import java.util.*;
public class Printer {
    public static void main(String[] args) {
        IntegerPrinter a  = new IntegerPrinter(123);
        DoublePrinter a1  = new DoublePrinter(1123.12);

        // no need to make new class everytime we can just use the same generic class to print all
        GenericPrinter<String> gp = new GenericPrinter("a124");
        GenericPrinter<Integer> gp1 = new GenericPrinter<>(123);
        GenericPrinter<List<Integer>> gp2 = new GenericPrinter<>(Arrays.asList(123,1,2,3,4));

        // a alternative  way for this to accept object instead of integer or double
        List<Object> list = new LinkedList<>();
        // a primitive can be auto-boxed as an associated object type (int autoboxes as Integer) and auto-unboxed (Integer unboxes as int), and the instances of the object types related to primitives (Integer, Long, etc.) are immutable (which is important for behaving like their primitive counterparts), and so the distinction becomes blurry.
        list.add(1);
        list.add("str");
        for(Object l:list)
            System.out.println(l);
        // but if you want to extract object you would not know what object it is int, string then you have to typecast it


        a.print();
        a1.print();
        gp.print();
        gp1.print();
        gp2.print();
    }
}
