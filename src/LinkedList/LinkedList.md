#### 876. Middle of the Linked List

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
```

#### 141. Linked List Cycle
```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast) return true;
        }
        return false;

    }
}
```

#### 142. Linked List Cycle II 
```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
       
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast)
            {
    
                while(head!=slow)
                {   
                    head = head.next;
                    slow = slow.next; 
                }
                return head;
            }
        }
        return null;
    }
}

```

#### 206. Reverse Linked List

```java

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
        }
        return prev;
    }
}
```

#### 92. Reverse Linked List II
```java

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1;
        ListNode curr = head;
        //introduce a dummy node
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode leftB = dummy;
        
        while(count!=right && curr!=null)
        {
            if(count == left-1)
                leftB = curr;
            curr=curr.next;
            count++;
        }
        ListNode rightPointer = curr;
        ListNode prev = rightPointer.next;
        curr = leftB.next;
        System.out.println("rp"+rightPointer.val);
        System.out.println("prev"+prev.val);
        System.out.println("curr"+curr.val);
        System.out.println();
        // System.out.println();
        while(curr!= rightPointer.next)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
        }
        leftB.next = prev;
      return dummy.next;
    }
}
```

####  234. Palindrome Linked List
```java

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow);
        while(slow!=null )
        {
            if(slow.val!=head.val) return false;
            slow = slow.next; 
            head = head.next;
        }
        return true;

    }
    ListNode reverse(ListNode curr)
    {
        ListNode prev = null;
        while(curr!=null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
```

#### 328. Odd Even Linked List
```java

class Solution {
    public ListNode oddEvenList(ListNode head) {
        int count = 0;
        if(head==null || head.next==null)
          return head;
         ListNode curr = head;
        ListNode headEven = new ListNode();
        ListNode curre = headEven;
    
        ListNode headOdd = new ListNode();
        ListNode curro = headOdd;
       
        while(curr!=null)
        {
            ListNode next = curr.next;
            curr.next = null;
            if(count%2==0)
            {
                curre.next = curr;
                curre = curre.next;
            }
            else
            {
                curro.next = curr;
                curro = curro.next;
            }
            count++;
            curr=next;
        }
        curre.next = headOdd.next;
        head = headEven.next;
        

        return head;
    }
}
```

#### 19. Remove Nth Node From End of List
```java

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null || head.next==null)
            return null;
        ListNode curr = new ListNode();
        curr.next = head;
        ListNode currn = curr;
        int count = 0;
        while(count!=n)
        {
            currn=currn.next;
            count++;
        }
        //we want to stop at the element prior to the node to be deleted
        if(currn.next==null) 
            return head.next;
        while(currn.next!=null)
        {
            currn = currn.next;
            curr = curr.next;
        }
        curr.next=curr.next.next;
        return head;
    }
}
```

####  2095. Delete the Middle Node of a Linked List

```java
class Solution {
    public ListNode deleteMiddle(ListNode head)
    {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow==dummy)
            return head.next;
        slow.next = slow.next.next;
        return head;

    }
}
```

#### Sort a linked List
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
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
```

#### 83. Remove Duplicates from Sorted List (Easy)

```Java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        if(curr==null || curr.next==null)
            return head;
        ListNode next = curr.next;
        while(next!=null)
        {
            while(next!=null && curr.val == next.val)
            {
                next = next.next;
            }
            curr.next = next;
            curr =curr.next;
            if(next!=null)
                next = next.next;
        }
        return head;
    }
}
```

#### 82. Remove Duplicates from Sorted List II
we just keep 2 nodes:
Prev - it is used to add unique elements to the list
Curr - to iterate over the list
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode curr = head;
        ListNode prev = dummy;
        while(curr!=null)
        {
            if(curr.next!=null && curr.val==curr.next.val)
            {
                while(curr.next!=null && curr.val==curr.next.val)
                {
                    curr = curr.next;
                }
                prev.next = curr.next;
            }
            else
                prev = prev.next;
               
            
             curr = curr.next;
        }
        return dummy.next;
    }
}
```


#### 61. Rotate List
```java

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
      if(head==null ) return head;
        int count = 1;
        ListNode curr = head;
        while(curr.next!=null)
        {
            count++;
            curr = curr.next;
        }
          k=k%count;
        if(k%count==0) return head;
        curr = head;
        int n = 1;
        while(curr!=null && n!=count-k)
        {
            n++;
            curr= curr.next;
        }
        ListNode ans = curr.next;
        curr.next = null;
        curr = ans;
        while(curr.next!=null)
            curr = curr.next;
        curr.next = head;
        return ans;
    }
}
```

```java
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap();
        if(head == null)
           return head;
        Queue<Node> q = new LinkedList();
        Node node = head;
        q.add(node);
        map.put(node,new Node(node.val));
        while(!q.isEmpty())
        {
            Node temp = q.poll();
            Node copy = map.get(temp);
            if(temp.next!=null)
            {
                if(!map.containsKey(temp.next))
                {
                    map.put(temp.next,new Node(temp.next.val));
                    
                    q.add(temp.next);
                }
                copy.next = map.get(temp.next);
            }
            if(temp.random!=null)
            {
                if(!map.containsKey(temp.random))
                {   
                    map.put(temp.random,new Node(temp.random.val));
                    
                    q.add(temp.random);
                }
                copy.random = map.get(temp.random);
              
            }
        }
        return map.get(head);
    }
}
```