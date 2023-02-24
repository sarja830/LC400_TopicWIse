//package Heap;
//import java.util.*;
//public class TopKFrequentElements347 {
//    public static void main(String[] args) {
//        TopKFrequentElements347 a = new TopKFrequentElements347();
//        a.topKFrequent(new int[]{1,1,1,2,2,3},2);
//    }
//    class Pair
//    {
//        int key;
//        int value;
//        Pair(int a, int b)
//        {
//            key=a;
//            value=b;
//        }
//    }
//    public int[] topKFrequent(int[] nums, int k) {
//        int n = nums.length;
//        HashMap<Integer,Integer> map = new HashMap();
//        PriorityQueue<Pair> pq = new PriorityQueue<>(a,b->a.value-b.value);
//        for(int i=0;i<n;i++)
//        {
//            if(map.containsKey(nums[i]))
//                map.put(nums[i],map.get(nums[i])+1);
//            else
//                map.put(nums[i],1);
//        }
//        for(int key: map.keySet())
//        {
//
//        }
//    }
//}
