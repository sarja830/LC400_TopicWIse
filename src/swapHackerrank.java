import java.util.List;

public class swapHackerrank {
    public static void main(String[] args) {
       System.out.println(maxMemory(new int[]{5,1,4,2,4,1,2,3},8 ));
       System.out.println(maxMemory(new int[]{2,4,1,3},4 ));
       System.out.println(maxMemory(new int[]{2,3,1,5,4,5},6 ));
    }
    static int maxMemory(int[] nums, int n )
    {
        int i=0, j=n-1;
        int sum = 0;
        while(j>i)
        {
            if (nums[i] > nums[j])
                sum = sum + (i + 1) * nums[j] + (j + 1) * nums[i];
            else
                sum = sum + (i + 1) * nums[i] + (j + 1) * nums[j];
            i++;
            j--;
        }
        return sum;
    }


}
