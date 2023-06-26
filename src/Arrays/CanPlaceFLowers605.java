package Arrays;

public class CanPlaceFLowers605 {
    public static void main(String[] args) {
        CanPlaceFLowers605 a = new CanPlaceFLowers605();
        a.canPlaceFlowers(new int[]{1,0,0,0,0,1},1);
    }
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int current=0;
            int prev=-1;
            int ahead=1;
            int n1= flowerbed.length, count=0;
            while(current<n1)
            {
                boolean flag=true;
                if(prev>=0 && prev<n1 && flowerbed[prev]==1)
                    flag=false;
                if(ahead>=0 && ahead<n1 && flowerbed[ahead]==1)
                    flag=false;
                if(flag==true && flowerbed[current]!=1)
                {
                    flowerbed[current]=1;
                    count++;
                }
                prev++;
                current++;
                ahead=ahead++;

            }
            return count==n?true:false;
        }

}
