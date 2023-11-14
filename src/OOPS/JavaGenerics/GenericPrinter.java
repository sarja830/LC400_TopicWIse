package OOPS.JavaGenerics;

public class GenericPrinter<T> {
    T t;
    GenericPrinter(T t)
    {
        this.t = t;
    }
    void print()
    {
        System.out.println(t);
    }
}
