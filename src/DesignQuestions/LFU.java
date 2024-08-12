package DesignQuestions;

import java.util.*;

public class LFU {

    int capacity;

    public static void main(String[] args) {

        LFU lfu = new LFU(2);
        lfu.put(1,1);
        lfu.put(2,2);
        lfu.get(1);
        lfu.put(3,3);
        lfu.get(2);
        lfu.get(3);
        lfu.put(4,4);
        lfu.get(1);
        lfu.get(3);
        lfu.get(4);
    }
    class Pair {
        int val;
        int freq;
        int key;

        Pair(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }

        Pair(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    PriorityQueue<Pair> pq;
    HashMap<Integer, Pair> map;

    public LFU(int capacity) {
        this.capacity = capacity;
        pq = new PriorityQueue<Pair>((a, b) -> {
            return a.freq - b.freq;
        });
        map = new HashMap();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Pair p = map.get(key);
            p.freq = p.freq + 1;
            map.put(key, p);
            return map.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Pair p = map.get(key);
            p.val = value;
            p.freq = p.freq + 1;
            map.put(key, p);
        } else {
            if (map.size() == capacity) {
                Pair p = pq.poll();
                map.remove(p.key);
            }
            Pair p1 = new Pair(key, value);
            map.put(key, p1);
            pq.add(p1);


        }
    }
}

