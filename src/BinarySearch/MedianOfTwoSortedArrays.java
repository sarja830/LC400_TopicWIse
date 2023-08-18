package BinarySearch;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        MedianOfTwoSortedArrays a= new MedianOfTwoSortedArrays();
     double a1 =    a.findMedianSortedArrays(new int[]{1,2,3,5,6}, new int[]{4});
     double a2 =a1;
    }
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            if(n1==0)
                return n2%2==0?(nums2[(n2-1)/2]+nums2[(n2-2)/2+1])/2.0:nums2[(n2-1)/2];
            if(n2==0)
                return n1%2==0?(nums1[(n1-1)/2]+nums1[(n1-2)/2+1])/2.0:nums1[(n1-1)/2];

            int low =-1,high = n1-1;
            while(low<=high)
            {
                int mid = low+ (high - low)/2;
                int mid2 = (n1+n2+1)/2-(mid+1)-1;
                int l1 = mid>=0 ?nums1[mid]:Integer.MIN_VALUE;
                int l2 = mid2>=0?nums2[mid2]:Integer.MIN_VALUE;
                int r1 = (mid+1>=0 && mid+1<n1)?nums1[mid+1]:Integer.MAX_VALUE;
                int r2 = (mid2+1>=0 && mid2+1<n2)?nums2[mid2+1]:Integer.MAX_VALUE;

                if(l1<=r2 && l2<=r1)
                {
                    int k =Math.max(l1,l2);
                    int j =Math.min(r1,r2);
                    double ans= (k+j)/2;
                    return (n1+n2)%2==0? (k+j)/2:Math.max(l1,l2);
                }
                if(l1>r2)
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            return -1;
        }

}
