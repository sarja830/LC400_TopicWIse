package SlidingWindow;

public class SubarrayProductLessThank713 {
    public static void main(String[] args) {
        SubarrayProductLessThank713 a = new SubarrayProductLessThank713();
        a.numSubarrayProductLessThanK(new int[]{10,5,2,6},100);
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l=0, n=nums.length;
        int count=0;
        int r=0;
        int product= 1;
        while(r<n && l<=r)
        {
            product=product*nums[r];
            if(product<k){
                count++;

            }
            else
            {
                while(l<n && product>=k){
                    product=product/nums[l];
                    l++;
                }
                count=count+r-l+1;
            }
            r++;
        }
        int n1 =r-l-1,nf=1;
        while(n1>0)
        {
            nf=nf+n1;
            n1--;
        }
        count=count+nf;
        return count;
    }

}
