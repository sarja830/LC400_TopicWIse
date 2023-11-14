package SegmentTree;

public class RangeSumQuery {
    public static void main(String[] args) {
        RangeSumQuery a = new RangeSumQuery();
        a.NumArray(new int[]{0,9,5,7,3});
        int a1 = a.sumRange(4,4);
        System.out.println(a1);
//        ,[2,4],[3,3],[4,5],[1,7],[0,8],[1,2],[1,9],[4,4],[3,4]]});

    }
    int[] store;
    int[] nums;
    public void NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        int siz = 4*n;
        store = new int[siz];
        // build segment tree
        store[0] = buildSegmentTree(nums,0,n-1,0);
        for(int i:store)
            System.out.println(" "+i);
    }

    int buildSegmentTree(int[] nums, int low, int high, int i)
    {
        if(low<high)
        {
            int mid = low+(high-low)/2;
            store[2*i+1] = buildSegmentTree(nums,low,mid,2*i+1);
            store[2*i+2] = buildSegmentTree(nums,mid+1,high,2*i+2);
            return store[2*i+1]  + store[2*i+2];
        }
        return nums[low];


    }

    void updateSegmentTree(int low, int high, int idx, int i, int oldVal,int newVal)
    {
        if(idx<=high && idx>=low)
        {
            store[i] = store[i]-oldVal+newVal;
        }
        if(low<high)
        {
            int mid = low+(high-low)/2;
            if(idx<=mid)
                updateSegmentTree(low,mid,idx,2*i+1,oldVal,newVal);
            else
                updateSegmentTree(mid+1,high,idx,2*i+2,oldVal,newVal);
        }
        return;
    }

    public void update(int index, int val) {
        int oldValue = nums[index];
        nums[index] = val;
        int newValue = nums[index];
        updateSegmentTree(0,nums.length-1,index,0,oldValue, newValue);
    }

    public int findSum(int low, int high,  int left, int right, int i)
    {
        int ans = 0;
        if(low==left && high == right)
            return store[i];

        if(low<high)
        {
            int mid = low+ (high-low)/2;
            // the interval lies inside the range
            if(low<=left && high>=right)
            {
                if(mid>=left)
                    ans = findSum(low,mid,left,Math.min(mid,right),2*i+1);

                if(right>=mid+1)
                    ans = ans+ findSum(mid+1,high,Math.max(mid+1,left),right,2*i+2);
            }
        }
        return ans;
    }


    public int sumRange(int left, int right) {
        return findSum(0,nums.length-1,left,right,0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

