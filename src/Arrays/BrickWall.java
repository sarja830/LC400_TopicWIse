//package Arrays;
//import  java.util.*;
//public class BrickWall {
//    public static void main(String[] args) {
//        leastBricks()
//    }
//        public static int leastBricks(List<List<Integer>> wall)
//        {
//            List<Integer> list1  = wall.get(0);
//            int min = Integer.MAX_VALUE;
//            int sum = 0;
//            int ansIdx = 0;
//            for(int i:list1)
//                sum = sum+i;
//
//            int[] ans = new int[sum];
//            Arrays.fill(ans,wall.size());
//            for(int i=0;i<wall.size();i++)
//            {
//                List<Integer> list = wall.get(i);
//                sum = 0;
//                for(int j=0;j<list.size()-1;j++)
//                {
//                    sum = list.get(j);
//                    ans[sum] =  ans[sum] -1;
//
//                }
//            }
//            return min;
//        }
//
//
//}
