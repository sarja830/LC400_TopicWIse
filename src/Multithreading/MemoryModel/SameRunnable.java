package Multithreading.MemoryModel;

import java.util.LinkedList;

public class SameRunnable {
    public static void main(String[] args) {

        Runnable myRunnable = new MyRunnable(new int[2]);
        // since they are accessing the same runnable object
        // it is shared between thread classes hence it is shared among different threads
        // Hence all the global variables are accessed by all the threads
        //but the variable under the run methods will be different for all since they are initialized for threads
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);
        Thread t3 = new Thread(myRunnable);
        Thread t4 = new Thread(myRunnable);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
