package JavaBasics;
import java.util.*;
public class CollectionInterface {
//Collection Interface
//    List, Set, Queue



    //    List <T> al = new ArrayList<> ();
//
//    List <T> ll = new LinkedList<> ();
//
//    List <T> v = new Vector<> ();
//    Set<T> hs = new HashSet<> ();
//
//    Set<T> lhs = new LinkedHashSet<> ();
//
//    Set<T> ts = new TreeSet<> ();
//
////    it extends set interface
//    SortedSet<T> ts = new TreeSet<> ();
//    Queue <T> pq = new PriorityQueue<> ();
//
//    Queue <T> ad = new ArrayDeque<> ();
    static class Pair
    {
        int key;
        int value;
        Pair(int a, int b)
        {
            key=a;
            value=b;
        }
    }

    public static void main(String[] args) {
        List<Pair> list = new LinkedList<Pair>();
        list.add(new Pair(1, 2));


//    List of int[] to array of int[][]
        List<int[]> ans = new ArrayList<>();
        Collections.addAll(ans,new int[]{1,2}, new int[]{1,2}, new int[]{1,2});
        int[][] ansar = ans.toArray(new int[ans.size()][]);

        Collections.addAll(list, new Pair(11,2),new Pair(12,12),new Pair(13,112));
        Collections.reverse(list);
        List<Integer> original = new LinkedList();
        List<Integer> copied = new LinkedList();
        Collections.addAll(original,1,2,3,4,5,60);
        Collections.addAll(copied,11,12,13,14,15,160);

//        list must be of same length source and copy in this case it will throw error deep copy
        Collections.copy(copied,original);
        copied.clear();
//      It is used to get the comparator that imposes the reverse of the natural ordering on a collection of objects which implement the Comparable interface.
        PriorityQueue<Pair> pq= new PriorityQueue<>(Collections.reverseOrder());
        //dont forget to write public in int compare
        Comparator<Pair> c = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.value - o1.value;
            }
        };
        Collections.sort(list, c);

        HashSet<Integer> set = new HashSet<>();
        Collections.addAll(set,1,2,3,4,5,6);
        LinkedList<Integer> list1 = new LinkedList<>(set);
        list1.add(1);
        HashSet<Integer> set1 = new HashSet<>(list1);
//generally the member of collection interface allows changing there type eg is from set ot list list to queue etc.
//        privided the object type should be same
        Collection<Integer> c111 = new ArrayList<>();
        Collections.addAll(c111,1,1,1,1,1,1,12,1,2,1,2,1,2,1,12);
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>( c111);


/*
//        PRIORITY QUEUE CLASS
//        declaration of priority queue with constructor
        1. PriorityQueue(): Creates a PriorityQueue with the default initial capacity (11) that orders its elements according to their natural ordering.

                PriorityQueue<E> pq = new PriorityQueue<E>();

        2. PriorityQueue(Collection<E> c): Creates a PriorityQueue containing the elements in the specified collection.

                PriorityQueue<E> pq = new PriorityQueue<E>(Collection<E> c);
        3. PriorityQueue(int initialCapacity): Creates a PriorityQueue with the specified initial capacity that orders its elements according to their natural ordering.

                PriorityQueue<E> pq = new PriorityQueue<E>(int initialCapacity);

        4. PriorityQueue(int initialCapacity, Comparator<E> comparator): Creates a PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator.

                PriorityQueue<E> pq = new PriorityQueue(int initialCapacity, Comparator<E> comparator);

        5. PriorityQueue(PriorityQueue<E> c): Creates a PriorityQueue containing the elements in the specified priority queue.

                PriorityQueue<E> pq = new PriorityQueue(PriorityQueue<E> c);


        #METHODS implements queue interface
        The example below explains the following basic operations of the priority queue.

        boolean add(E element): This method inserts the specified element into this priority queue.
        public peek(): This method retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
        public poll(): This method retrieves and removes the head of this queue, or returns null if this queue is empty.

*/

        PriorityQueue<int[]> pqa = new PriorityQueue<>((a,b)->(a[0]-a[0]));

    }
}
