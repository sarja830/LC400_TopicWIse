package Multithreading;

class TotalEarnings
{
    int total  = 0;
    synchronized  void earning() {
        for (int i = 0; i < 10; i++)
            total = total + 10;
        this.notify();
    }
}

public class InterthreadCommunication {
    public static void main(String[] args) throws InterruptedException {
        TotalEarnings a = new TotalEarnings();
        Runnable r = ()-> a.earning();
        Thread t = new Thread(r);
        t.start();
        synchronized (a)
        {
            a.wait();
        }

        System.out.println(a.total);



    }
}
