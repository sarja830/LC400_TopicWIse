package Prefix;

public class ProductofArrayExceptSelf238 {
    public static void main(String[] args) {
        ProductofArrayExceptSelf238 a = new ProductofArrayExceptSelf238();
        a.productExceptSelf(new int[]{1,2,3,4});
    }
        public int[] productExceptSelf(int[] nums) {
            int n =nums.length;
            int pr=1;
            int po=1;
            int[] prefix = new int[n];
            int[] postfix = new int[n];
            for(int i=0;i<n;i++)
            {
                prefix[i] = nums[i]*pr;
                postfix[n-1-i]=nums[n-1-i]*po;
                pr=prefix[i];
                po =postfix[i];
            }
            for(int i=0;i<n;i++)
            {
                if(i==n-1)
                    nums[i]=prefix[i-1];
                else if(i==0)
                    nums[i]=postfix[i+1];
                else
                    nums[i] = postfix[i+1]*prefix[i-1];
            }
            return nums;

        }

}
