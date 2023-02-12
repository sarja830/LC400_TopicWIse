package Heap;
import java.util.*;
public class MergeKSortedList23 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode start = new ListNode();
        ListNode temp=start;
        int k =lists.length;
        for(int i=0;i<k;i++)
        {
            if(lists[i]!=null)
                pq.add(lists[i]);
        }
        while(pq.size()!=0)
        {
            ListNode p = pq.poll();
            start.next = p;
            p=p.next;
            start.next.next=null;
            start=start.next;
            if(p!=null)
                pq.add(p);
        }
        return temp.next;
    }

    public ListNode amergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode start = new ListNode();
        ListNode prev = lists[0];
        for(int i=1;i<lists.length;i++)
        {
            prev = merge(lists[i],prev);
        }
        return prev;
    }

    ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode start = new ListNode();
        ListNode temp = start;
        while(l1!=null && l2!=null)
        {
            if(l1.val>l2.val)
            {
                start.next=l2;
                l2=l2.next;
                start.next.next=null;
            }
            else
            {
                start.next=l1;
                l1=l1.next;
                start.next.next=null;
            }
            start=start.next;
        }
        if(l1==null)
        {
            start.next=l2;
        }
        else
        {
            start.next=l1;
        }
        return temp.next;
    }

}
