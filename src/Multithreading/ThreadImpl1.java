package Multithreading;

public class ThreadImpl1 {
    // by extending the thread class and overriding the run method
     static class myThread extends Thread
    {
        @Override
        public void run() {

            System.out.println("my thread is running");
            System.out.println("my thread is completed");
        }
    }

    //main method here is executed by a thread when JVM starts up the application
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        for(int i=0;i<100;i++) {
            myThread my = new myThread();
            //when a thread is started it then executes the run method
            my.start();
        }
    }
}
