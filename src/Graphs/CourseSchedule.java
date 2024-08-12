package Graphs;
import java.util.*;
public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule a = new CourseSchedule();
        a.canFinish(20, new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}});
    }
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] adjList= new List[numCourses];
            int[] indegree = new int[numCourses];

            for( int[] prereq: prerequisites )
            {
                adjList[prereq[1]].add(prereq[0]);
                indegree[prereq[0]]++;
            }
            Queue<Integer> q = new LinkedList();
            // start from the courses which does not have any dependency
            int count = 0;
            for(int i=0;i<numCourses;i++)
                if(indegree[i]==0)
                    q.add(i);

            while(!q.isEmpty())
            {
                int temp = q.poll();
                count++;
                for(int neighbor: adjList[temp])
                {
                    indegree[neighbor]--;
                    if(indegree[neighbor]==0)
                        q.add(neighbor);
                }
            }
            System.out.println(count);
            return count==numCourses;

        }
    }

