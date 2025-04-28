package com.psj.user.controller;

import com.psj.user.designpattern.mydisign.handler.UserPermission;
import com.psj.user.designpattern.mydisign.handler.UserTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pengshj
 * @version 1.0
 * @date 2025/3/12-15:40
 * @description TODO
 */
public class BingfaTest {
    private static final int WORKER_COUNT = 3;
    private static int countIndex = 0;
    private static final ReentrantLock LOCK = new ReentrantLock();

    public static void main(String[] args){
        UserTest  userTest =new UserTest();
        userTest.setUserPermission(UserPermission.BASIC);
           System.out.println(userTest.getUserPermission());
           System.out.println(UserPermission.BASIC.name());





      /*  final List<Condition> conditions = new ArrayList<>();
        for(int i=0; i< WORKER_COUNT; i++){
            // 为每一个线程分配一个condition
            Condition condition = LOCK.newCondition();
            conditions.add(condition);
            Worker worker = new Worker(i, conditions);
            worker.start();
        }
*/
    }

    static class Worker extends Thread{

        int index;
        List<Condition> conditions;

        public Worker(int index, List<Condition> conditions){
            super("Thread-"+index);
            this.index = index;
            this.conditions = conditions;
        }

        private void signalNext(){
            int nextIndex = (index + 1) % conditions.size();
            conditions.get(nextIndex).signal();
        }

        @Override
        public void run(){
            while(true) {
                //锁住 保证操作间同时只有一个线程
                LOCK.lock();
                try {
                    // 如果当前线程不满足打印条件，则等待
                    if (countIndex % 3 != index) {
                        conditions.get(index).await();
                    }
                    if (countIndex > 100) {
                        // 唤醒下一个线程，保证程序正常退出
                        signalNext();
                        // 退出循环 线程运行结束
                        return;
                    }
                   // System.out.println((this.getName() + " " + countIndex));
                  char ch=  (char)(65+countIndex%3);
                    System.out.println((this.getName() + " "+ch));
                    // 计数器+1
                    countIndex ++;
                    // 通知下一个干活
                    signalNext();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    LOCK.unlock();
                }
            }
        }
    }
   /* private static final Object LOCK = new Object();
    private static volatile int count = 0;
    private static final int MAX = 100;

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Thread(new Seq(i)).start();
        }

    }

    static class Seq implements Runnable {

        private final int index;

        public Seq(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            while (count < MAX) {
                synchronized (LOCK) {
                    try {
                        while (count % 4 != index) {
                            LOCK.wait();
                        }
                        if(count <=MAX){
                            System.out.println("Thread-" + index + ": " + count);
                        }
                        count++;
                        LOCK.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }*/
    }







   /* volatile int number = 0;
    AtomicInteger atomicInteger=new AtomicInteger(0);
    public void increase() {
        atomicInteger.getAndAdd(1);
    }

    public static void main(String[] args) {
        BingfaTest volatileAtomDemo = new BingfaTest();
        for (int j = 0; j < 10; j++) {
            new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    volatileAtomDemo.increase();
                }
            }, String.valueOf(j)).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() +
                " final number result = " + volatileAtomDemo.atomicInteger);
    }*/


