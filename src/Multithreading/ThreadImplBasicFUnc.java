package Multithreading;

public class ThreadImplBasicFUnc {

    public static class RunnableStoppable implements Runnable {
        private boolean stopRequested = false;

        synchronized void requestStop() {
            this.stopRequested = true;
            System.out.println("stop requested");
        }

        synchronized boolean isStopRequested() {
            return this.stopRequested;
        }


    @Override
    public void run() {
        while(!isStopRequested())
        {
            sleep(100);

            System.out.println("my thread is running1 "+Thread.currentThread().getName());
        }
        System.out.println("my thread is stopped");

    }

    // this will let the
    public void sleep(long millisec)
    {
        try{
            Thread.sleep(millisec);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}


    public static void main(String[] args) {
        RunnableStoppable rs = new RunnableStoppable();
        RunnableStoppable rs1 = new RunnableStoppable();
        Thread myThread = new Thread(rs, "secondaryThread");
        Thread myThread1 = new Thread(rs1, "secondaryThreadDameon");
        myThread1.setDaemon(true);
        myThread.setDaemon(true);
        myThread1.start();
        //daemon thread is stopped in undefined thread state

        myThread.start();


        // this will let the main thread sleep
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        try{
            // the join function will let the secondary thread complete its job then only it will end the main thread
            myThread.join();
            myThread1.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }


//        rs.requestStop();

        for(int i=0;i<100;i++)
            System.out.println("i am active main thread" + Thread.currentThread().getName());

        // if a thread is running then the JVM keeps alive In this case even though main thread has finished execution
        // still the secondary thread keeps on running
        // to change this behavior to stop all secondary thread when main thread is finished running its task
        // we set setDamaeon to true this will stop the secondary threads id the main thread is completed
    }
}
