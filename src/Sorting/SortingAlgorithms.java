//package Sorting;
//
//public class SortingAlgorithms {
//
//    public static void main(String[] args) {
//        int[]  arr = {6,4,3,5,2,1,8};
//        SortingAlgorithms a = new SortingAlgorithms();
//        a.printArr(a.bubbleSort(arr));
//        int[]  arr1 = {6,4,3,5,2,1,8};
//        a.printArr(a.mergeSort(arr1));
//
//        int[]  arr2 = {6,4,3,5,2,1,8};
//        a.printArr( a.insertionSort(arr2));
//
//        int[]  arr3 = {6,4,3,5,2,1,8};
//        a.quickSort(arr3,0,arr3.length-1);
//        a.printArr(arr3);
//
//    }
//
//    void printArr(int[] arr){
//        for(int i:arr)
//        {
//            System.out.println(i);
//        }
//    }
//
//
//
//    //bubble sort
//    void swap(int[] nums, int i, int j)
//    {
//        int temp = nums[i];
//        nums[i]=nums[j];
//        nums[j]=temp;
//    }
//
//
//    int[] bubbleSort(int[] nums)
//    {
//        int n =nums.length;
//        for(int j=n-1;j>=0;j--)
//        {
//            int i=1;
//            while(j>=i)
//            {
//                if(nums[i]>nums[i-1])
//                {
//                    int temp = nums[i];
//                    nums[i] = nums[i-1];
//                    nums[i-1] = temp;
//                }
//                i++;
//            }
//        }
//        return nums;
//    }
//
//
//
//    //merge sort
//    void  merge(int[] nums ,  int low , int mid, int high)
//    {
//        int n1  = (mid+1)-low;
//        int n2 = high -mid;
//        int[] a = new int[n1];
//        int[] b = new int[n2];
//        int i=0,j=0;
//        for(i=0;i<n1;i++){
//            a[i] = nums[low+i];
//        }
//        for(j=0;j<n2;j++)
//        {
//            b[j]=nums[mid+1+j];
//        }
//        i=0;
//        j=0;
//        int k=low;
//        while(i<n1 && j<n2)
//        {
//            if(a[i]>b[j])
//            {
//                nums[k++]=b[j++];
//            }
//            else
//            {
//                nums[k++]=a[i++];
//            }
//        }
//        while(i<n1)
//        {
//            nums[k++]=a[i++];
//        }
//        while(j<n2)
//        {
//            nums[k++]=b[j++];
//        }
//        return;
//    }
//    void rec(int[] nums, int low,int high)
//    {
//        if(high>low) {
//
//            //take care of this expression
//            int mid = low+ (high - low) / 2;
//            rec(nums, low, mid);
//            rec(nums, mid + 1, high);
//            merge(nums, low, mid, high);
//        }
//        else return;
//    }
//    int[] mergeSort(int nums[])
//    {
//        rec(nums,0,nums.length-1);
//        return nums;
//    }
//
//
//
//    int[] insertionSort(int[] nums)
//    {
//        int n = nums.length;
//        for (int i = 1; i < n; ++i) {
//            int key = nums[i];
//            int j = i - 1;
//
//            /* Move elements of nums[0..i-1], that are
//               greater than key, to one position ahead
//               of their current position */
//            while (j >= 0 && nums[j] > key) {
//                nums[j + 1] = nums[j];
//                j = j - 1;
//            }
//            nums[j + 1] = key;
//        }
//    }
//
//
//
//
//    int[] heapSort(int[] nums)
//    {
//
//        return nums;
//    }
//
////QUICKSORT
//
//    int partition(int a[],int low ,int high)
//    {
//        int i=low-1;
//        int j=low;
//        int pivot =  a[high];
//        for(j=0;j<-high-1;j++)
//        {
//            if(a[j]>pivot)
//            {
//                i++;
//                int temp = a[j];
//                a[j]=a[i];
//                a[i]=temp;
//            }
//        }
//        i++;
//        int temp = a[i];
//        a[i]=a[high];
//        a[high]=temp;
//        return i;
//    }
//
//
//
////    https://github.com/sarja830/DSA/blob/master/sort/Quicksort.java
////    placing each element to its correct place
//    public void quickSort(int a[],int low ,int high)
//    {
//        if(high>=low) {
//            int p = partition(a, low, high);
//            quickSort(a, low, p - 1);
//            quickSort(a, p + 1, high);
//        }
//
//    }
//
//    public static int[] insertionSort(int nums[],int n)
//    {
//        /*Function to sort the array in descending order
//        After sorting return the sorted array */
//
//        for(int i=0;i<n-1;i++)
//        {
//            int max = i;
//            for(int j=i+1;j<n;j++)
//            {
//                if(nums[max]<nums[j])
//                    max = j;
//            }
//            int temp = nums[i];
//            nums[i] = nums[max];
//            nums[max] = temp;
//        }
//        return nums;
//    }
//
//}
