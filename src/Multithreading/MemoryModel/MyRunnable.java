package Multithreading.MemoryModel;

import java.util.*;
import java.util.List;

public class MyRunnable implements Runnable{
    private int count;
    private int[] list;
    MyRunnable(int[] list)
    {
        this.list= list;
    }
    @Override
    public void run() {

        int[] insideRun = new int[]{1,2,3};
        System.out.println("insideRun" + insideRun);
        for(int i=0;i<100000;i++) {
            synchronized (this){
                this.count++;
            }
        }

        System.out.println(Thread.currentThread().getName()+" count "+ count);
        System.out.println("globalList"+this.list);
    }

}
