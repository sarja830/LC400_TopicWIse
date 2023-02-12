package DivideAndConquer;

public class ReversePairs493 {
    public static void main(String[] args) {
        ReversePairs493 a = new ReversePairs493();
        a.reversePairs(new int[]{1,3,2,3,1});
    }
    int nums[];
    int count;
    public int reversePairs(int[] nums) {
        this.nums=nums;
        count=0;
        mergeSort(0,nums.length-1);
        return count;
    }
    void mergeSort(int l, int r)
    {
        if(r>l)
        {
            int mid=l-(l-r)/2;
            mergeSort(l,mid);
            mergeSort(mid+1,r);
            merge(l,mid,r);
        }
        return;
    }
    void merge(int l, int mid, int r)
    {
        int n1=mid+1-l, n2=r-mid;
        int i=0, j=0;
        int[] a= new int[n1];
        int[] b= new int[n2];
        for( i=0;i<n1;i++)
            a[i]=nums[l+i];
        for( i=0;i<n2;i++)
            b[i]=nums[mid+1+i];

        // counting the pairs step
        i=0;j=0;
        while(i<n1 && j<n2)
        {
            while(j<n2 && new Long(a[i])>2*new Long(b[j]))
                j++;
            if(j==n2) break;
            while(i<n1 && new Long(a[i])<=2*new Long(b[j]))
            {
                count=count+j;
                i++;
            }
        }
        while(i<n1)
        {
            count=count+j;
            i++;
        }

        // normal merge step
        i=0; j=0;
        int k=l;
        while(i<n1 && j<n2)
        {
            if(a[i]>b[j])
                nums[k++]=b[j++];
            else
                nums[k++]=a[i++];
        }

        while(i<n1)
        {
            nums[k++]=a[i++];
        }
        while(j<n2)
        {
            nums[k++]=b[j++];
        }
    }




// O(n^2) solution TLE
// class Solution {
//     public int reversePairs(int[] nums) {
//         int count=0;
//         for(int i=0;i<nums.length-1;i++)
//         {
//             for(int j=i+1;j<nums.length;j++)
//                 if(new Long(nums[i])>2* new Long(nums[j]))
//                  count++;
//         }
//         return count;
//     }
// }
}
