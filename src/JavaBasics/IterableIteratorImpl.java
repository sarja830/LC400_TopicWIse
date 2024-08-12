//package JavaBasics;
//
//import org.jetbrains.annotations.NotNull;
//
//import java.util.*;
//import java.util.function.Consumer;
//
//class Person
//{}
//
//class Persons implements  Iterable
//{
//    private List<Person> persons = new ArrayList<Person>();
//
//    public Iterator<Person> iterator() {
//        return this.persons.iterator();
//    }
//    @NotNull
//    @Override
//    public Iterator iterator() {
//        return null;
//    }
//
//    @Override
//    public void forEach(Consumer action) {
//        Iterable.super.forEach(action);
//    }
//
//    @Override
//    public Spliterator spliterator() {
//        return Iterable.super.spliterator();
//    }
//}
//
//public class IterableIteratorImpl {
//    public static void main(String[] args) {
//
//    }
//}
