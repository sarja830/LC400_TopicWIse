package Multithreading;

public class ThreadJoin {

    public static void main(String[] args) throws Exception{
        Runnable a1 = () ->{for (int i=0;i<9;i++) System.out.println(i);};
        Runnable a = new Runnable()  {
            @Override
            public void run() {
                for(int i=0;i<5;i++)
                {
                    System.out.println("jello "+i);
                    try{
                        Thread.sleep(100);
                    }
                    catch (Exception e)
                    {}

                }
            }
        };
        Thread t1 =  new Thread(a);
        t1.start();
        t1.join();
        for(int i=0;i<5;i++)
        {
            System.out.println("Hello "+i);
            Thread.sleep(1);
        }

    }
}
