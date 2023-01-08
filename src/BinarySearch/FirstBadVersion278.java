package BinarySearch;

public class FirstBadVersion278 {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    public static void main(String[] args) {
        firstBadVersion(5);
    }
    static Boolean isBadVersion(int n) {
        if (n==4 || n==5) return true ;
        else return false;
    }
        public static int firstBadVersion(int n) {
            int low=1;
            int high=n;
            int res=-1;
            while(low<=high)
            {
                int mid=low-(low-high)/2;
                if(isBadVersion(mid)==true)
                {
                    res=mid;
                    high=mid-1;
                }
                else low=mid+1;
            }
            return res;
        }
    }

