package com.cy.java.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
//JUC

public class ThreadPoolTests {
    public static void main(String[] args) {
        int corePoolSize=2;
        int maximumPoolSize=3;
        int keepAliveTime=60;
        TimeUnit unit=TimeUnit.SECONDS;
        //任务队列,存储要执行的任务
        BlockingQueue<Runnable> workQueue=
                new ArrayBlockingQueue<>(1);
        //创建线程的工厂
        ThreadFactory threadFactory=new ThreadFactory() {
            private String prefix="db-service-thread-";
            private AtomicInteger atomicInteger=new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable task) {
                return new Thread(task,prefix+atomicInteger.incrementAndGet());
            }
        };
        RejectedExecutionHandler handler=
          //new ThreadPoolExecutor.AbortPolicy();//不能执行任务时抛出异常
          new ThreadPoolExecutor.CallerRunsPolicy();//由调用者去执行
        //构建线程池对象
        ThreadPoolExecutor threadPool= new ThreadPoolExecutor(
                        corePoolSize,
                        maximumPoolSize,
                        keepAliveTime,
                        unit,
                        workQueue,
                        threadFactory,
                        handler);
        threadPool.execute(new Runnable() {//task
            @Override
            public void run() {
                String tName=Thread.currentThread().getName();
                System.out.println(tName+"->execute->task1");
                try{Thread.sleep(5000);}catch (Exception e){}
            }
        });
        threadPool.execute(new Runnable() {//task
            @Override
            public void run() {
                String tName=Thread.currentThread().getName();
                System.out.println(tName+"->execute->task2");
                try{Thread.sleep(5000);}catch (Exception e){}
            }
        });
        threadPool.execute(new Runnable() {//task
            @Override
            public void run() {
                String tName=Thread.currentThread().getName();
                System.out.println(tName+"->execute->task3");
            }
        });
        threadPool.execute(new Runnable() {//task
            @Override
            public void run() {
                String tName=Thread.currentThread().getName();
                System.out.println(tName+"->execute->task4");
                try{Thread.sleep(5000);}catch (Exception e){}
            }
        });
        threadPool.execute(new Runnable() {//task
            @Override
            public void run() {
                String tName=Thread.currentThread().getName();
                System.out.println(tName+"->execute->task5");
                try{Thread.sleep(5000);}catch (Exception e){}
            }
        });

    }
}
