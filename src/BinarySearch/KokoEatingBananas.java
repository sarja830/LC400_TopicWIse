package BinarySearch;

public class KokoEatingBananas {

    public static void main(String[] args) {
        KokoEatingBananas a=  new KokoEatingBananas();
        a.minEatingSpeed(new int[]{805306368,805306368,805306368},1000000000);
    }
        int[] piles;
        int n;
        public int minEatingSpeed(int[] piles, int h) {
            this.piles = piles;
            n=piles.length;
            int max=0;
            for(int i=0;i<piles.length;i++)
                max= Math.max(piles[i],max);
            int low=1;
            int high = max;
            int ans=0;
            while(low<=high)
            {
                int mid=low+(high-low)/2;
                //since it is taking more time we need to increase the intake
                if(count(mid)<=h)
                {
                    ans=mid;
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            return ans;
        }
        double count(int k)
        {
            double hours=0;
            for(int i=0;i<n;i++)
                hours=hours + (int) Math.ceil((double)piles[i]/k);
            return hours;
        }

}
