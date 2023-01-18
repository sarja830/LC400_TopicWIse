package Arrays;

public class FindPivotIndex724 {

    public static void main(String[] args) {
        FindPivotIndex724 a = new FindPivotIndex724();
        System.out.print(a.pivotIndex(new int[]{1,7,3,6,5,6}));
    }

    public int pivotIndex(int[] nums) {
        int sum=0;
        int lsum=0;
        int n =nums.length;
        for(int i:nums)
        {
            sum=sum+i;
        }
        for(int i=0;i<n;i++)
        {
            if(sum-lsum-nums[i]==lsum) return i;
            lsum=lsum+nums[i];

        }
        return -1;
    }
}
