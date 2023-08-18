package JavaBasics;
import java.util.*;
public class JavaArrays {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{1,2,3};
        // does the comparison of content
        System.out.println(Arrays.equals(a,b));

        // does the comparison of reference
        System.out.println((a).equals(b));

    }
}
