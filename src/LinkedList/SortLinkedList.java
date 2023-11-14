package LinkedList;

public class SortLinkedList {
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static void main(String[] args) {

         ListNode start = new ListNode(4);
         ListNode head = start;
         start.next = new ListNode(2);
         start.next.next =new ListNode(1);
         start.next.next.next =new ListNode(3);
        SortLinkedList a = new SortLinkedList();
        a.sortList(head);
    }
        ListNode ans;
        public ListNode sortList(ListNode head) {
            return divide(head);

        }

        ListNode divide(ListNode start)
        {
            if(start!=null && start.next!=null)
            {
                ListNode mid = divideListInMiddle(start);
                ListNode left  = divide(start);
                ListNode right = divide(mid);
                return merge(left, right);
            }
            return start;
        }
        ListNode divideListInMiddle(ListNode start)
        {
            if(start==null || start.next==null)
                return start;
            ListNode dummy = new ListNode();
            dummy.next = start;
            ListNode slow = dummy;
            ListNode fast = dummy;
            while(fast!=null && fast.next!=null)
            {
                slow=slow.next;
                fast=fast.next.next;
            }
            ListNode res = slow.next;
            slow.next = null;
            return res;
        }
        ListNode merge(ListNode left, ListNode right)
        {
            ListNode dummy = new ListNode();
            ListNode res = dummy;
            while(left!=null && right!=null)
            {
                if(left.val<right.val)
                {
                    dummy.next = left;
                    left=left.next;
                }
                else
                {
                    dummy.next = right;
                    right = right.next;
                }
                dummy = dummy.next;
            }
            if(left==null)
                dummy.next = right;
            if(right == null)
                dummy.next = left;

            return res.next;
        }


}
