package BinarySearch;

import java.util.HashMap;

public class IntegerToRoman {
    public static void main(String[] args) {

    }
        public String intToRoman(int num) {
            HashMap<Integer,String> map = new HashMap();
            map.put(1,"I");
            map.put(2,"II");
            map.put(3,"III");
            map.put(4,"IV");
            map.put(5,"V");
            map.put(6,"VI");
            map.put(7,"VII");
            map.put(8,"VIII");
            map.put(9,"IX");
            map.put(40,"XL");
            map.put(90,"XC");
            map.put(400,"CD");
            map.put(900,"CM");
            map.put(10,"X");
            map.put(50, "L");
            map.put(100,"C");
            map.put(500,"D");
            map.put(1000,"M");
            int i=0;
            String res = "";

            res = getRoman(num,map);

            return res;
        }
        String getRoman(int digit, HashMap<Integer,String> map)
        {
            if(digit==0)
                return "";

            if(map.containsKey(digit))
                return map.get(digit);

            int[] nums = new int[]{1,5,10,50,100,500,1000};

            int value = binarySearchLowerBound(nums,digit);
            if(digit-value==0)
                return map.get(digit);
            else
                return  map.get(value)+getRoman(digit-value,map);
        }

        int binarySearchLowerBound(int[] nums, int value)
        {
            int low = 0, n = nums.length, high = n-1;
            while(low<=high)
            {
                int mid = low + (high-low)/2;
                if(nums[mid]==value)
                    return value;
                else if( nums[mid]>value)
                    high = mid-1;
                else
                    low = mid+1;
            }
            return nums[low];
        }

}
