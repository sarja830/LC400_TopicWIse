package DP_1d;

public class NumberOfLIS673 {
    public static void main(String[] args) {
        NumberOfLIS673 a = new NumberOfLIS673();
        a.findNumberOfLIS(new int[]{1,3,5,4,7});
    }
        public int findNumberOfLIS(int[] nums) {
            int[] res = new int[nums.length];
            int[] count = new int[nums.length];
            int n = nums.length;
            int max =Integer.MIN_VALUE;
            int finalCount=0;
            for(int i=0;i<nums.length;i++)
            {
                res[i]=1;
                count[i]=1;
                int j = i-1;
                while(j>=0)
                {


                    if(nums[i]>nums[j])
                    {
                        if(res[i]<res[j]+1) count[i]=0;
                        res[i]=  Math.max(res[i],res[j]+1);
                        if(res[i]==res[j]+1)
                            count[i]=count[j]+count[i];
                    }

                    j--;
                }
                if(max<res[i])
                {
                    max=res[i];
                    finalCount=count[i];
                }
                else if(max==res[i])
                {
                    finalCount = finalCount+count[i];
                }

            }

            return finalCount;


        }

}
