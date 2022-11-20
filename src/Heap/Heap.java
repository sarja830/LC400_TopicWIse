package Heap;

public class Heap {
    int[] arr;
    public Heap(int[] a)
    {
        arr = a;
    }
    public int[] sort(int[] a)
    {
//        build min heap first in order to get the ascending order sorting
//        in min heap root is smaller
        int n = a.length;

//        traversing the internal nodes since the leave are already satisfying  the heap property.
        for(int i=(n/2)-1;i>=0;i--)
        {
            Min_Heapfiy(a,i);
        }
        return a;
    }
    public void Min_Heapfiy(int[] a, int i)
    {
        int l= 2*i+1;
        int r= 2*i+2;
//        for max heap
//        int largest=i;
        int smallest=i;

        int n = a.length;
        if(l<n && a[smallest]>a[l])
        {
            smallest=l;
        }
        if(r<n && a[smallest]>a[r])
        {
            smallest=r;
        }
        if(smallest!=i) {
            {
                swap(a,i,smallest);
                Min_Heapfiy(a, smallest);
            }
        }
    }
    public void swap(int[] a,int i,int j)
    {
        int temp= a[i];
        a[i]= a[j];
        a[j]=temp;
    }
}
