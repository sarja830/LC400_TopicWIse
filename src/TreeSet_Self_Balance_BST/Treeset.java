package TreeSet_Self_Balance_BST;

import java.util.TreeSet;

public class Treeset {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(0);
        set.add(4);
        set.add(5);
        set.add(7);

        Integer floor = set.floor(1);
        Integer floor1 = set.floor(2);
        Integer ceil = set.ceiling(1);
        Integer ceil1 = set.ceiling(2);


    }
}
