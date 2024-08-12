package Strings;

public class CompareVersions {
        public static void main(String[] args) {
            CompareVersions a = new CompareVersions();
            a.compareVersion("0.1","1.1");
        }
        public int compareVersion(String version1, String version2) {
            int i=0;
            System.out.println(version1);
            String s1[] = version1.split("//.");
            for(String s: s1)
                System.out.print("Str "+s);
            String s2[] = version2.split(".");
            int n1 = s1.length;
            System.out.println(n1);
            int n2 = s2.length;
            System.out.println(n2);
            while(i<=Math.max(n1,n2))
            {
                int no1 = i<n1?Integer.parseInt(s1[i]):0;
                int no2 = i<n2?Integer.parseInt(s2[i]):0;
                System.out.println(no1);
                System.out.println(no2);
                if(no1>no2)
                    return 1;
                if(no1<no2)
                    return -1;

                i++;
            }
            return 0;
        }


}
