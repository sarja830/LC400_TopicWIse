package Arrays;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class NextGreaterElement {
    public static void main(String[] args) {
        NextGreaterElement a = new NextGreaterElement();
        System.out.println(a.nextGreaterElement(230241));
    }

    public int nextGreaterElement(int n1) {
        List<Integer> digits = new LinkedList<>();
        while(n1>0)
        {
            int digit = n1%10;
            digits.add(digit);
            n1 = n1/10;
        }
        Collections.reverse(digits);
        int[] nums = digits.stream().mapToInt(i->i).toArray();

        int n = nums.length;
        int pivotIndex = -1;
        for(int i=n-2;i>=0;i--)
        {

            if(nums[i]<nums[i+1])
            {
                pivotIndex = i;
                break;
            }
        }
        if(pivotIndex==-1)
            return -1;
        for(int i=n-1;i>pivotIndex && pivotIndex>=0;i--)
            if(nums[pivotIndex]<nums[i])
            {
                swap(i,pivotIndex,nums);

                break;
            }

        reverse(pivotIndex+1,n-1,nums);

        int num = 0;
        for(int i=0;i<n;i++)
        {
            num = num*10+nums[i];
        }
        return num;
    }
    void swap(int i , int j, int[] nums)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    void reverse(int i , int j, int nums[])
    {
        while(j>i)
        {
            swap(i,j,nums);
        }
    }
}