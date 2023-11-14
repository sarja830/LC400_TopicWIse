package SlidingWindow;

public class MinimumWIndowSubsequence {
    public static void main(String[] args) {
        System.out.println(minWindow("bbaaaaabaabbaaabbba" ,"abaaa" ));
    }

        public static String minWindow(String s, String t) {
            int i1=0,j1=0;
            int i=0,j=0;
            int count =0, min=Integer.MAX_VALUE,min_index=-1;
            while(j<s.length())
            {
                char c =  s.charAt(j);
                if(c==t.charAt(j1))
                {
                    count++;
                    j1++;
                }

                if(count==t.length())
                {
                    int k=j;
                    int temp = t.length()-1;
                    while(temp>=0)
                    {
                        if(t.charAt(temp)==s.charAt(k))
                            temp--;
                        k--;
                    }
                    if(min>j-k+1)
                    {
                        min= j-(k+1)+1;
                        min_index = k+1;
                    }
                    i=k+2;
                    j =k+2;
                    count=0;
                    j1=0;
                }
                else {
                    j++;
                }

            }
            if(min_index==-1) return "";
            return s.substring(min_index,min_index+min);

        }
}
