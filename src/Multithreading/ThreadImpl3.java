package Multithreading;

import Multithreading.MemoryModel.MyRunnable;

import javax.swing.plaf.TableHeaderUI;

public class ThreadImpl3 {
    public static void main(String[] args) {



        // to implement the runnable interface as an anonymous class
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("my thread is running1");
                System.out.println("my thread is completed1");
            }
        };
        Thread my1 = new Thread(runnable);
        my1.start();
        Thread my = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("my thread is running");
                System.out.println("my thread is completed");
            }
        });
        my.start();
    }
}
