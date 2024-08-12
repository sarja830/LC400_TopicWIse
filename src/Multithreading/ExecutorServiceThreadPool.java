//package Multithreading;
//
//import java.util.concurrent.*;
//
//public class ExecutorServiceThreadPool {
//    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 10; i++) {
//
//            executor.submit();
//        }
//        executor.shutdown();
//        while (!executor.isTerminated()) {
//        }
//        System.out.println("Finished all threads");
//    }
//}
