package JavaBasics;

import java.util.*;

public class ListImpl {
    public static void main(String[] args) {

        //shorthand to access list
        List<Integer> list = new LinkedList(Arrays.asList(1,2,34,4));
//        List<Integer> list = new LinkedList();
        for(int i:list)
        {
            System.out.println(i);
        }


    }
}
