package SegmentTree;

public class NumberOfPairsSatisfyingInequality {
    public static void main(String[] args) {
        NumberOfPairsSatisfyingInequality   a = new NumberOfPairsSatisfyingInequality();
//        int nums1[] = new int[]{5, 4, 2, 0, 5};
//        int nums2[] = new int[]{3, -2, 5, 2, -4};
        int nums1[] = new int[]{-4,-4,4,-1,-2,5};
        int nums2[] = new int[]{-2,2,-1,4,4,3};
//        a.numberOfPairs(nums1,nums2,-4);
        a.numberOfPairs(nums1,nums2,1);
    }

    long count;
    int k;
    public long numberOfPairs(int[] nums1, int[] nums2, int diff)
    {
        this.k = diff;
        int n = nums1.length;
        count = 0;
        for(int i=0;i<n;i++)
        {
            nums1[i] = nums1[i] - nums2[i];
        }
        // nums[i] - nums[j]<=k
        mergeSort(0,nums1.length-1,nums1);
        return count;
    }
    public void mergeSort(int low, int high, int[] nums)
    {
        if(low<high)
        {
            int mid = low + (high-low)/2;
            mergeSort(low,mid,nums);
            mergeSort(mid+1,high,nums);
            merge(low,mid,high,nums);
        }
        return;
    }
    public void merge(int low, int mid, int high, int[] nums)
    {

        int i = low;
        int i1 = 0, j1 = 0;
        int n1 = mid+1-low, n2 = high-mid;
        int[] a = new int[n1], visited = new int[n1], b = new int[n2];
        for(int k=low;k<=mid;k++)
            a[k-low] = nums[k];
        for(int k=mid+1;k<=high;k++)
            b[k-(mid+1)] = nums[k];

        while(i1<n1 && j1<n2)
        {
            if(visited[i1]==0) {
                count = count + n2 - BinarySearch(a[i1] - k, b, 0, n2 - 1);
                visited[i1] = 1;
            }
            if(a[i1]>b[j1])
                nums[i++] = b[j1++];
            else
                nums[i++]= a[i1++];
        }
        while(i1<n1)
        {
            nums[i++] = a[i1];
            if(visited[i1]==0)
                count = count+n2-BinarySearch(a[i1]-k,b,0,n2-1);
            i1++;
        }
        while(j1<n2)
            nums[i++] = b[j1++];
    }
    int BinarySearch(int target, int nums[], int low, int high)
    {
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid]>=target)
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }

}
