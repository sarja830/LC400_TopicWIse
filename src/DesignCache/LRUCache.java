package DesignCache;
import java.util.*;
public class LRUCache {
    public static void main(String[] args) {
        LRUCache lr = new LRUCache(2);
        lr.put(1,1);
        lr.put(2,2);
        lr.get(1);
        lr.put(3,3);
        lr.get(2);
        lr.put(4,4);
        lr.get(1);
        lr.get(3);
        lr.get(4);



    }
        class Node
        {
            Node next;
            Node prev;
            int[] KeyVal = new int[2];
            Node(int a, int b)
            {
                KeyVal[0]=a;
                KeyVal[1]=b;
            }
        }
        int capacity;
        Node start;
        Node end;
        Map<Integer,Node> map;
        public LRUCache(int capacity) {
            this.capacity=capacity;
            map = new HashMap();
            start  = new Node(-1,-1);
            end= new Node(-1,-1);
            start.next = end;
            end.prev=start;
            start.prev=null;
            end.next=null;
        }

        public int get(int key) {
            if(map.containsKey(key))
            {
                delete(map.get(key));
                insertAtFirst(map.get(key));
                return map.get(key).KeyVal[1];
            }
            else
            {
                return -1;
            }
        }

        public void put(int key, int value) {
            if(map.size()>capacity )
            {
                if(!map.containsKey(key))
                {
                    Node deleted =deleteLast();
                    map.remove(deleted.KeyVal[0]);
                    map.put(key,new Node(key,value));
                    insertAtFirst(map.get(key));
                }
                else
                {
                    delete(map.get(key));
                    Node toBeInserted = map.get(key);
                    toBeInserted.KeyVal[1] = value;
                    insertAtFirst(toBeInserted);
                    map.put(key,toBeInserted);
                }
            }
            else
            {
                Node newNode = new Node(key,value);
                insertAtFirst(newNode);
                map.put(key,newNode);
            }
        }
        void insertAtFirst(Node temp)
        {
            temp.next=start.next;
            temp.prev=start;
            start.next=temp;
            temp.next.prev=temp;
        }
        void delete(Node del)
        {
            del.prev.next=del.next;
            del.next.prev=del.prev;
        }
        Node deleteLast()
        {
            Node last = end.prev;
            delete(last);
            return last;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

