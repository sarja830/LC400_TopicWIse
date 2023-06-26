package Arrays;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int maxR=0;
        for(int l=0;l<n-1;l++)
        {

            maxR=0;
            for (int r=n-1;r>=0;r--)
                if(r>=0 && maxR<height[r]){
                    maxR = height[r];
                    maxArea = Math.max(maxArea,(r-l)*Math.min(height[l],height[r]));
                    r--;
                }

        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater a = new ContainerWithMostWater();
        a.maxArea(new int[]{1,2,3,4,5,25,24,3,4});
    }
}
