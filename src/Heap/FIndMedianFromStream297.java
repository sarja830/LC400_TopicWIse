package Heap;
import java.util.*;
public class FIndMedianFromStream297 {
    public static void main(String[] args) {
        FIndMedianFromStream297 a = new FIndMedianFromStream297();
        a.addNum(5);
        a.addNum(4);
        a.addNum(3);
        a.addNum(2);
        a.addNum(1);
        System.out.println(a.findMedian());
        a.addNum(3);
        System.out.println(a.findMedian());
    }




    PriorityQueue<Integer> lq;
    PriorityQueue<Integer> rq;
    boolean even;

//    public MedianFinder() {
    public FIndMedianFromStream297() {
        lq = new PriorityQueue(Collections.reverseOrder());
        rq = new PriorityQueue();
        even=true;
    }



    public void addNum(int num) {
        if(even)
        {
            rq.add(num);
            lq.add(rq.poll());
        }
        else
        {
            lq.add(num);
            rq.add(lq.poll());
        }
        even=!even;
    }

    public double findMedian() {
        if(even)
            return (lq.peek()+rq.peek())/2;
        else
            return lq.peek();
    }


}
