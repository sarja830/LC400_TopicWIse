package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class MAxPointsOnLine {
        public static void main(String[] args) {
            MAxPointsOnLine a = new MAxPointsOnLine();
//            a.maxPoints(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}});

            System.out.println(a.maxPoints(new int[][]{{3,3},{1,4},{1,1},{2,1},{2,2}}));
//            a.maxPoints(new int[][]{{0,0},{1,-1},{1,1}});

//            a.maxPoints(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}});
//            a.maxPoints(new int[][]{{1,1},{2,2},{3,3}});
        }
        public int maxPoints(int[][] points) {
            HashMap<Double, HashSet<int[]>> map = new HashMap<>();
            int n = points.length;
            int max = 0;
            for(int i=0;i<n-1;i++)
                for(int j=i+1;j<n;j++)
                {
                    double slope = Integer.MAX_VALUE;
                    if( (points[j][0]-points[i][0])!=0)
                        slope = (points[j][1]-points[i][1])/(points[j][0]-points[i][0]);
                    if(!map.containsKey(slope))
                        map.put(slope, new HashSet());
                    map.get(slope).add(points[i]);
                    map.get(slope).add(points[j]);
                    if(map.get(slope).size()>max)
                        max = map.get(slope).size();
                }

            return max;


        }

}
