package Multithreading;

public class ThreadImpl4 {
    //using java lambda expression
    public static void main(String[] args) {

        Runnable runnable = ()->{
            String name = Thread.currentThread().getName();
            System.out.println(" my thread is "+ name+" running");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                //to print the stack trace of the error;
              e.printStackTrace();
            }
            System.out.println("my thread is "+ name+"  completed");
        };
        for(int i=0;i<100;i++) {
            Thread my = new Thread(runnable, "Thread_sarja"+i);
            my.start();
        }
    }
}
