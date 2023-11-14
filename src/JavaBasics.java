import Heap.MergeKSortedList23;

import java.math.BigInteger;
import java.util.*;
public class JavaBasics {

    public static void main(String[] args) {

//        Character to Integer
        char a='1';
        int a1=1;
        int ascii = 97;
        char asciiChar = (char)(ascii);
        int digit = '1'-'0'; //ascii of "1"
        char charDigit = (char)(digit+'0');

        String abra = "abra";
        String dabra ="dabra";
        System.out.println("abra lexicographicaly compared to dabra abra.compareTo(dabra) "+abra.compareTo(dabra));
        System.out.println("dabra lexicographicaly compared to abra abra.compareTo(dabra)"+dabra.compareTo(abra));


        System.out.println(charDigit);
        System.out.println( Character.getNumericValue(a) );
        System.out.println( Character.forDigit(a1,10) );
        System.out.println( Character.valueOf('a'));



//      Type conversion
        int integer =2;
        double adouble  =(double) 2;
        System.out.println("PRINTING DOUBLE "+adouble);
//        Whenever diving int by double please use type conversion or else wrong answer will come
        System.out.println("dividing double by integer without type casting integer "+adouble/2);
        System.out.println("dividing double by integer by typecasting integer "+adouble/(double)2);

//BigInteger for OA questions
        BigInteger aBig,bBig;
        aBig= BigInteger.valueOf((long)122);
        bBig= BigInteger.valueOf((long)100);
        aBig.add(bBig);
        aBig.divide(bBig);
        aBig.multiply(bBig);
        aBig.divide(BigInteger.valueOf(2));

//Binary operator on int
//        System.out.println(" 1|0 "+(int)1|(int)0);
//        System.out.println(" 1&0 "+(int)1&(int)0);

//        Arrays
// declare an array using values initialized
        int[] nums = new int[]{1,2,3,4,5,6};
        System.out.println("nums to string "+nums.toString());

        // Array to string conversion
        String res= Arrays.toString(nums);
        System.out.println(" to string" +res);

//String to chararray
        String str= "Sarthak Jain";
        char[] ch = str.toCharArray();
        System.out.println(" printing char array of string" +ch.toString());
//charArray to string
        char character='a';
        String stringValueOfChar = String.valueOf(character);
        System.out.println("character  to string value " +stringValueOfChar);

//LIST collection interface
        List<Integer> sourceList = new ArrayList<>();
        sourceList.addAll(Arrays.asList(1,2,3,4));
        sourceList.add(1);


//set from list

        sourceList.addAll(Arrays.asList(1,2,3,4));
        sourceList.add(1);
        sourceList.add(2);
        sourceList.add(2);
        Set<Integer> targetSet = new HashSet<>(sourceList);
        System.out.println(" set  created from list " +targetSet);

//set from array

        Arrays.toString(nums);
//        for nested array
        int[] ab= new int[]{5,4,3,2,1};
        int[] b= new int[]{5,4,3,2,1};
        int[][] deepArray= new int[][]{{5, 4, 3, 2, 1},{5,4,3,2,1},{5,4,3,2,1}};
        String deepArrayString =Arrays.deepToString(deepArray);
        System.out.println("nested array to string" +deepArrayString);


//                sorting an array
        Arrays.sort(ab);


//        sorting a 2d array
        int[][] aaa = new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        Arrays.sort(aaa,(ar,br)->Integer.compare(ar[0],br[0]));
//        will not work in all the cases wont work in the above corner case
        Arrays.sort(aaa,(ar,br)->ar[0]-br[0]);
        Arrays.sort(aaa,(a11,b11)->
                {
                    //if a is greater than b place it to the right 1 denotes positive means to the right
                    if(a11[0]>b11[0])
                        return 1;
                    else
                        return -1;
                }
        );


        System.out.println(" sorted array " +ab.toString());
//        checking equality of 2 arrays
        Arrays.equals(b,ab);
        System.out.println(" equality of array " +Arrays.equals(b,ab));



//        Array to ArrayList

//        List<Integer> arrayOfArrayList= new ArrayList<>(Arrays.asList(a));
//        System.out.println(arrayOfArrayList.toString());

        List<List<Integer>> finalList = new LinkedList<>();

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,3);
        map.put(3,4);
        map.put(4,5);

        System.out.println(map.isEmpty());
        System.out.println(map.size());
        for(Integer value: map.values())
        {
            System.out.println(value);
        }
        for(Integer key: map.keySet())
        {
            System.out.println(key);
        }

//        String
        String s = "There is no substitute for hardwork.";
        String t="There is no substitute for hardwork.";
        // split the string such that it gets splitter based on multiple slashes or single slash
        s.split(" ");
        int start=0;
        int end=5;
//        start inclusive and end exclusive
        s.substring(start,end);
//        In simple words, == checks if both objects point to the same memory location whereas .equals() evaluates to the comparison of values in the objects.
        System.out.println(s==t);
        System.out.println(s.equals(t));


        // gives small first
        PriorityQueue<Integer> pq = new PriorityQueue<>();
//         if we want to create pq of explicit ojects in java
//         PriorityQueue<MergeKSortedList23.ListNode> pq1 = new PriorityQueue<>((a, b)->a.val-b.val);


        StringBuilder sb = new StringBuilder();
        sb.append("s");    // to add at last
        sb.insert(0,'s');
        System.out.println(sb.toString());



//       Reverse a string
        String hi = "Hello Sarthak";
        String reversedHi = new StringBuilder(hi).reverse().toString();



//        Stack
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.add(3);

        //top element without delete
        st.peek();
//        popping top element
        st.pop();
//        pushing to the top
        st.push(1);
//        delete everything from the stack
        st.clear();


    }
}
