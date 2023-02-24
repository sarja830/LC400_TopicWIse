package Arrays;

public class FindtheArrayConcatenationValue2562 {
    public static void main(String[] args) {
        FindtheArrayConcatenationValue2562 a = new FindtheArrayConcatenationValue2562();
        a.findTheArrayConcVal(new int[]{7,52,2,4});
    }
    public long findTheArrayConcVal(int[] nums) {

        long sum=0;
        for(int i=0,j=nums.length-1;i<=j;i++,j--)
        {
            if(i<j)
            {
                sum=sum+nums[i]
                        *(long)Math.pow(10,(int)Math.log10(nums[j])+1)
                        +nums[j];
            }
            else
            {
                sum=sum+nums[i];
            }
        }
        return sum;
    }
}
