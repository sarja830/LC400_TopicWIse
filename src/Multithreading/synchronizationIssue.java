package Multithreading;
class bookRunnable implements Runnable{
    int seatsToBook;
    bookRunnable(int seats)
    {
        seatsToBook =seats;
    }

    int totalSeats = 10;

    // either you can use a synchronized method or a synchronized block
    void  bookSeats() throws InterruptedException {

        synchronized(this)
        {
            Thread.sleep(10000);
            System.out.println("inside first"+ " "+Thread.currentThread());
            if (seatsToBook <= totalSeats) {
                System.out.println("seats booked " + Thread.currentThread());
                totalSeats = totalSeats - seatsToBook;
                System.out.println("seats booked " + totalSeats);
            } else
                System.out.println("seats cannot be booked");
        }
        synchronized(this) {
            for(int i=0;i<10;i++) {
                System.out.println(i+ " "+Thread.currentThread());
            }

        }
    }
    @Override
    public void run()  {
        try {
            bookSeats();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class synchronizationIssue {


    public static void main(String[] args) throws Exception {
        Runnable r = new bookRunnable(7);
        Thread t = new Thread(r);
        Thread t1 = new Thread(r);



        t.start();
        t1.start();

//        t.join();
//        t1.join();


        System.out.println(((bookRunnable) r).totalSeats);
    }
}