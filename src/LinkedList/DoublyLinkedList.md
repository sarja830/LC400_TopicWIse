#### reverse a DLL
```java

public class Solution
{
    public static Node reverseDLL(Node head)
    {
        Node prev = null;
        Node curr = head;
        while(curr!=null)
        {
            Node next = curr.next;
            curr.next = curr.prev;
            curr.prev = next;
            prev = curr;
            curr= next;

        }
        return prev;
    }
}
```