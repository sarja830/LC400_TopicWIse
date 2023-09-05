package DesignCache;

import java.util.HashMap;
public class LFU {
    public static void main(String[] args) {
        LFU lfu = new LFU();
        LFUCache lr = lfu.new LFUCache(2);
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
    class LFUCache {

        private int capacity;
        private  int currSize;
        private int minFreq;
        HashMap<Integer,DoubleLinkedList> countMap;
        HashMap<Integer,DoubleLinkedList.Node> nodeMap;
        class DoubleLinkedList
        {
            int size;
            Node start;
            Node end;


            void remove(Node node)
            {
                Node before = node.prev;
                Node after = node.next;
                before.next=after;
                after.prev=before;
                size--;
            }
            Node removeLast()
            {
                Node before = end.prev;
                if(before==start) return null;

                remove(before);
                return before;

            }
            void addNodeToStart(Node node)
            {
                node.next=start.next;
                node.next.prev = node;
                start.next = node;
                node.prev = start;
                size++;
            }
            void addNodeToEnd(Node node)
            {
                node.prev = end.prev;
                node.prev.next = node;
                node.next=end;
                end.prev= node;
                size++;
            }
            public DoubleLinkedList()
            {
                start = new Node(-1);
                end = new Node(-1);
                start.next = end;
                end.prev = start;
                size=0;
            }
            class Node
            {
                int value;
                int count;
                Node next,prev;
                public Node(int value)
                {
                    this.value= value;
                    this.count=1;
                    this.next= null;
                    this.prev = null;
                }
            }

        }

        public LFUCache(int capacity) {

            this.capacity= capacity;
            minFreq=0;
            countMap = new HashMap();
            nodeMap = new HashMap();
        }



        public int get(int key) {
            DoubleLinkedList.Node node = nodeMap.getOrDefault(key,null);
            updateNode(node, node.count+1);
            return node.value;
        }

        public void put(int key, int value) {

            if(nodeMap.containsKey(key))
            {
                DoubleLinkedList.Node node  = nodeMap.get(key);
                node.value = value;
                updateNode(node,node.count+1);
            }
            else {
                if(currSize==capacity) {
                    DoubleLinkedList minFreqDl = countMap.get(minFreq);
                    DoubleLinkedList.Node node = minFreqDl.removeLast();
                    nodeMap.remove(node);
                    currSize--;
                }
                DoubleLinkedList dl = countMap.getOrDefault(1,new DoubleLinkedList());
                DoubleLinkedList.Node newNode =  dl.new Node(value);
                dl.addNodeToStart(newNode);
                nodeMap.put(key,newNode);
                countMap.put(1,dl);
                currSize++;
                minFreq=1;
            }

        }

        void updateNode(DoubleLinkedList.Node node, int count)
        {
            DoubleLinkedList dl = countMap.get(node.count);
            dl.remove(node);
            if(dl.size==0)
            {
                while(!countMap.containsKey(minFreq))
                        minFreq++;
            }
            node.count=count;
            DoubleLinkedList newdl = countMap.getOrDefault(count,new DoubleLinkedList());
            newdl.addNodeToStart(node);
            countMap.put(count,newdl);
        }


    }

}
