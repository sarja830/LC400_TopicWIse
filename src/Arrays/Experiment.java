//package Arrays;
//
//public class Experiment {
//    int sliding(int window, int quantity, int[][] trade )
//    {
//        int i=0;
//        int j = window-1;
//        int n =trade.length();
//        while(j<n)
//        {
//            double ans =0;
//
//            int quan = 0;
//            while(quan<quantity && j>=i)
//            {
//                quan = Math.min(trade[j][1],quantity);
//                ans=ans+quan*trade[j][0];
//            }
//            System.out.println(ans);
//        }
//    }
//
//}
