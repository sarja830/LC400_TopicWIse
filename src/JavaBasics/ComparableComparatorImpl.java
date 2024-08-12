package JavaBasics;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Student  implements Comparable<Student>
{
    int marks;
    int roll_No;
    int age;
    public Student(int marks, int roll_No, int age) {
        this.marks = marks;
        this.roll_No = roll_No;
        this.age = age;
    }

    //consider this as a is self and b is the passed object
    @Override
    public int compareTo( Student o) {
      if(marks>o.marks)
          return -1;
      else if(marks==o.marks)
          return roll_No-o.roll_No;
      else return 1;
    }
    void print()
    {
        System.out.println(roll_No);
    }
}
public class ComparableComparatorImpl {
    public static void main(String[] args) {
        Student a = new Student(98,1,12);
        Student a1 = new Student(99,2,12);
        Student a2 = new Student(99,3,12);
        Student a3 = new Student(100,4,12);
        ArrayList<Student> st = new ArrayList<>();
        st.add(a);
        st.add(a1);
        st.add(a2);
        st.add(a3);

//

        class RankingComparator implements  Comparator<Student>
        {

            @Override
            public int compare(Student o1, Student o2) {
                if( o1.marks>o2.marks)
                    return -1;
                else if(o1.marks==o2.marks)
                        return o1.roll_No - o2.roll_No;
                else return 1;
            }
        }
        Collections.sort(st,new RankingComparator());
        Collections.sort(st, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        });

        Collections.sort(st, (a11,b11)-> a11.roll_No-b11.roll_No);
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(a1);
        pq.add(a2);
        pq.add(a3);

        for(Student s: pq)
            s.print();
        System.out.println("based on custom comparator");
        for (Student student : st) {
            student.print();
        }
        HashSet<Integer> set = new HashSet<>();
        for(int ikk: set)
            System.out.println(ikk);

int[] stones = new int[]{1,2,3,45};

        PriorityQueue<Integer> pq111 = new PriorityQueue(Arrays.stream(stones).boxed().collect(Collectors.toList())
                );

    }

}
