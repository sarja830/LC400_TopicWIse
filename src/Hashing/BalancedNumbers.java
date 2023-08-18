package Hashing;
import java.util.*;
public class BalancedNumbers {
    public static void main(String[] args) {
        BalancedNumbers a = new BalancedNumbers();
//        a.countBalancedNumbers(new LinkedList<>(Arrays.asList(5,3,1,2,4)));
        System.out.println(a.countBalancedNumbers(new LinkedList<>(Arrays.asList(5,3,1,2,4))));
        System.out.println(a.countBalancedNumbers(new LinkedList<>(Arrays.asList(1,5,3,2,4))));
        System.out.println(a.countBalancedNumbers(new LinkedList<>(Arrays.asList(4,1,3,2))));
        System.out.println(a.countBalancedNumbers(new LinkedList<>(Arrays.asList(1,5,3,2,4))));
    }
    public String countBalancedNumbers(List<Integer> p)
    {
        int n = p.size();
        String ans ="";
        int[] nums = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(p.get(i),i);
        }
        for(int k=1;k<=n;k++)
        {

            nums[k-1] = map.get(k);
        }
       ans=ans+"1";
        int max= Integer.MIN_VALUE;
      for(int r=1;r<n;r++) {
           max= Math.max(nums[r],max);
          if(Math.abs(nums[0]-max)>r)
          {
              ans=ans+"0";
          }
          else {
              ans=ans+"1";
          }
      }
      return ans;

    }

}
