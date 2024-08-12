package JavaBasics;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApis {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,1,1,1,2,3,4,5,6,7,89);
        List<Integer> l = list.stream().map(a-> 2*a).collect(Collectors.toList());
        Set<Integer> set = list.stream().collect(Collectors.toSet());
        set.forEach(a->System.out.println(a));
        int[] arr = list.stream().mapToInt(a->a).toArray();
    }
}
