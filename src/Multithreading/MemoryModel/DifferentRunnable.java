package Multithreading.MemoryModel;

import java.util.Arrays;
import java.util.LinkedList;

public class DifferentRunnable {

    public static void main(String[] args) {
        Runnable myRunnable1 = new MyRunnable(new int[]{1,2});
        Runnable myRunnable2 = new MyRunnable(new int[2]);
        Thread t1 = new Thread(myRunnable1);
        Thread t2 = new Thread(myRunnable2);

        t1.start();
        t2.start();
    }

}
