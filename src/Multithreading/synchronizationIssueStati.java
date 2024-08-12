package Multithreading;
class MovieBookinng{

//    MovieBookinng(int seats)
//    {
//        totalSeats = seats;
//    }

   static int totalSeats = 20;

    // either you can use a synchronized method or a synchronized block
   synchronized  static void  bookSeats(int seatsToBook) throws InterruptedException {

//        synchronized(this)
        {

            System.out.println("inside first"+ " "+Thread.currentThread());
            if (seatsToBook <= totalSeats) {
                System.out.println("seats booked " + Thread.currentThread());
                totalSeats = totalSeats - seatsToBook;
                System.out.println("seats booked " + totalSeats);
            } else
                System.out.println("seats cannot be booked");
        }
//      static  synchronized {
//            for(int i=0;i<10;i++) {
//                System.out.println(i+ " "+Thread.currentThread());
//            }
//
//        }
    }
}
public class synchronizationIssueStati {


    public static void main(String[] args) throws Exception {
        MovieBookinng a = new MovieBookinng();
        MovieBookinng a1 = new MovieBookinng();

        Runnable r = ()-> {
            try {
                a.bookSeats(9);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable r1 = ()-> {
            try {
                a.bookSeats(9);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread t = new Thread(r);
        Thread t1 = new Thread(r);

        Thread t11 = new Thread(r1);
        Thread t111 = new Thread(r1);



        t.start();
        t1.start();
        t11.start();
        t111.start();

//        t.join();
//        t1.join();


//        System.out.println(((bookRunnable) r).totalSeats);
    }
}