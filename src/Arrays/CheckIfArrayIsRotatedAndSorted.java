package Arrays;

public class CheckIfArrayIsRotatedAndSorted {
    public static void main(String[] args) {
        CheckIfArrayIsRotatedAndSorted a = new CheckIfArrayIsRotatedAndSorted();
        a.check(new int[]{3,4,5,1,2});
    }

        public boolean check(int[] nums) {
            boolean flag =false;
            for(int i=1;i<nums.length;i++)
            {
                if(!flag)
                    if(nums[i-1]>nums[i])
                    {
                        if(nums[i]>nums[0])
                            return false;
                        flag=true;
                    }
                    else
                    {
                        if(nums[i]<=nums[0] && nums[i-1]<=nums[i])
                            continue;
                        else
                            return false;
                    }
            }
            return true;
        }

}
