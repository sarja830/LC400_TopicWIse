package DP_Rec_Memoization;
import java.util.*;

public class JumpGame55 {
    
        public boolean canJump(int[] nums) {

//            Recursive solution
//            return recursive(nums,0)==1?true:false;

//            int[] memoize = new int[nums.length];
//            Arrays.fill(memoize,-1);
//            return recMemoize(nums,0,memoize)==1?true:false;
//

// Normal backtraversing solution in O(n) time   
            return BackTraversing(nums);
        }


// O(n) solution using backtraversing  
        public boolean BackTraversing(int[] nums)
        {
            int n= nums.length;
            boolean[] result = new boolean[n];
// mark last array as true since we need to reach there  
                result[n-1]=true;

// from 2nd last element try to find if you can reach last element similary try this consequent solutions, if they can reach their nearest true with the cost of operations they have for all other index till 0   
            for(int i=n-2;i>=0;i--)
            {
                for(int j=1;j<=nums[i] && i+j<n;j++)
                {
                    if(result[i+j]==true)
                    {
                        result[i]=true;
                        break;
                    }
                }
            }
            return result[0];
        }

// **recursive Solution**  
        public int recursive(int[] nums,int i)
        {
// if you reach the end return true or 1  
            if(i>=nums.length-1) return 1;

// if  you get 0 you can not move anymore hence return false but if you get 0 in the end you return true hence the i>=nums.length-1 condition is checked above  
            if(nums[i]==0)
                return 0;
    
        

// Inductive step  
            int result= 0;

// trying all possible steps  
            for(int j=1;j<=nums[i];j++)
            {

// storing or of the result  
                    result=result|recursive(nums,i+j);
                if(result==1)
                {
                    return result;
                }
            }
            return result;
        }


// **Memoized Solution**  
        public int recMemoize(int[] nums,int i,int[] memoize)
        {
            if(i>=nums.length-1) return 1;
            if(nums[i]==0)
                return 0;
            if(memoize[i]!=-1) return memoize[i];

            int result= 0;
            for(int j=1;j<=nums[i];j++)
            {

                result=result|recMemoize(nums,i+j,memoize);

// if you get true at anytime no need of looping other paths  
                if(result==1)
                {
                    memoize[i]=result;
                    return memoize[i];
                }
            }
            memoize[i]=result;
            return memoize[i];
        }
    
}
