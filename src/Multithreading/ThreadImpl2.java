package Multithreading;

// creating a subclass of the thread class and overrifing the method run
public class ThreadImpl2 {
    //by implementing runnable interface
    public static class MyRunnable implements Runnable
   {
       @Override
       public void run() {
           System.out.println("my thread is running");
           System.out.println("my thread is completed");
       }
   }
    public static void main(String[] args) {
        //pass instance of the myRunnable class
        // which implements the runnable interface to the constructor of the thread class
        Thread my = new Thread(new MyRunnable());
        //when a thread is started it then executes the run method
        my.start();

    }
}