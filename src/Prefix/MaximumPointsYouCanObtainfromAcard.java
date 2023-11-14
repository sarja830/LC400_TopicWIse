package Prefix;

public class MaximumPointsYouCanObtainfromAcard {
    public static void main(String[] args) {
        MaximumPointsYouCanObtainfromAcard a = new MaximumPointsYouCanObtainfromAcard();
        a.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3);
    }
        // the problem is to find the min sum subarray of size n-k
        public int maxScore(int[] cardPoints, int k) {
            int n = cardPoints.length;
            int siz = n-k, min=Integer.MAX_VALUE;
            int prevSum =0;
            for(int i=0;i<n;i++)
            {
                cardPoints[i] = cardPoints[i]+prevSum;
                prevSum=cardPoints[i];
            }

            if(n<=k) return cardPoints[n-1];
            min  = cardPoints[n-k-1];
            for(int i=n-k;i<n;i++)
            {
                min = Math.min(cardPoints[i-(n-k)],min);
            }
            return cardPoints[n-1]-min;

        }

}
