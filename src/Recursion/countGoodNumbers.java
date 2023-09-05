package Recursion;

public class countGoodNumbers {
    public static void main(String[] args) {
        countGoodNumbers a = new countGoodNumbers();
        System.out.println(a.countGoodNumbers(50));
    }
        public int countGoodNumbers(long n) {
            long res = 1;
            for(int i=0;i<n;i++)
            {
                if(i%2==0)
                    res=res*5;
                else
                    res=res*4;
            }
            return (int)res;
        }

}
