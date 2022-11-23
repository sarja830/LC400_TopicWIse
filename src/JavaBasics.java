import java.math.BigInteger;
import java.util.*;
public class JavaBasics {

    public static void main(String[] args) {

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


//set from list
        List<Integer> sourceList = new ArrayList<>();
        sourceList.add(1);
        sourceList.add(2);
        sourceList.add(2);
        Set<Integer> targetSet = new HashSet<>(sourceList);
        System.out.println(" set  created from list " +targetSet);

//set from array

        Arrays.toString(nums);
//        for nested array
        int[] a= new int[]{5,4,3,2,1};
        int[] b= new int[]{5,4,3,2,1};
        int[][] deepArray= new int[][]{{5, 4, 3, 2, 1},{5,4,3,2,1},{5,4,3,2,1}};
        String deepArrayString =Arrays.deepToString(deepArray);
        System.out.println("nested array to string" +deepArrayString);


//                sorting an array
        Arrays.sort(a);
        System.out.println(" sorted array " +a.toString());
//        checking equality of 2 arrays
        Arrays.equals(b,a);
        System.out.println(" equality of array " +Arrays.equals(b,a));



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
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
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
