package com.psj.user.controller;

import com.google.common.collect.Maps;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author pengshj
 * @version 1.0
 * @date 2025/3/6-15:07
 * @description TODO
 */
public class Demotest {
    static Integer num = 123;
    static Integer num3 = 123;
    static Integer num4 = 300;
    static Integer num5 = 300;
    static int num2 = 2;


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String message="TOUSER:";

        System.out.println( message.indexOf("TOUSER"));
       /* Thread thread = new Thread();
        thread.getId();
        thread.getId();
        thread.getId();

        String ss="66";
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> callable = () -> {
            System.out.println("Entered Callable");
            Thread.sleep(2000);
            return "Hello from Callable";
        };

        System.out.println("Submitting Callable");
        Future<String> future = executor.submit(callable);

        System.out.println("Do something else while callable is getting executed");
        System.out.println("Retrieved: " + future.get());

        executor.shutdown();


*/










    /*    Callable<String> callable = () -> {
            System.out.println("Entered Callable");
            Thread.sleep(2000);
            return "Hello from Callable";
        };

        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("Do something else while callable is getting executed");
        System.out.println("Retrieved: " + futureTask.get());*/




      /*  ArrayList<Object> objects = new ArrayList<>();
        TreeSet<String> treeSet = new TreeSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("sss");
        TreeMap<String, String> stringStringTreeMap = new TreeMap<>();
        stringStringTreeMap.put("7777","7777");
        treeSet.add("7777");
        treeSet.add("8888");
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/


       /* ArrayList<String> strings = new ArrayList<>();
        strings.add("6666");
        strings.add("8888");
        strings.add("9999");
        strings.add("11111");
        strings.add("222222");
        List<String> subList = strings.subList(0, 2);
        System.out.println("strings====="+strings.toString());
        System.out.println("subList====="+subList.toString());
        //strings.add("5555555");
        System.out.println("subListset====="+subList.toString());
        System.out.println("stringsset====="+strings.toString());
        System.out.println(strings.parallelStream().map(s ->s.equals("9999")).collect(Collectors.toList()).toString());


        System.out.println(6%8);
        System.out.println(6&7);
        Map<String,String>map=Maps.newHashMapWithExpectedSize(7);
        ConcurrentHashMap cmap=  new ConcurrentHashMap<>();
        cmap.put("11","222");*/
      /*
       LinkedList<String> linkedList = new LinkedList<>();
       linkedList.add("666666");
        linkedList.add("22222");
        linkedList.add(1,"333333");
        Iterator<String> stringIterator = linkedList.iterator();
        while (stringIterator.hasNext()){
            System.out.println(stringIterator.next());
        }
        System.out.println("peek该方法用于检索但不移除链表的第一个元素。如果链表为空"+linkedList.peek());
        System.out.println("poll检索并删除此列表的头部（第一个元素）如果此列表为空则返回null"+linkedList.poll());

        System.out.println(linkedList.toString());
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("99999");
        hashSet.add("101010");
        System.out.println(hashSet.contains("101010"));*/


       //System.out.println(0.1+0.2);
        List<String> strings = new ArrayList<String>();
        strings.add("55555");
        strings.add("66666");
        strings.add("77777");
        strings.add("88888");
       // strings.subList(0,1);
        for (String s:strings) {
            if (s.equals("77777")){
                strings.remove(s);
               // strings.add("99999");

            }

        }
        System.out.println(strings.toString());
    //add(strings,"4444");
   // find(strings);
}






    public  static   <T extends Comparable<T>> void  find(List<T> list){
        System.out.println("我是find");
        list.forEach(t -> {
            System.out.println(t.toString());
        } );
    }

    public  static   <T > void  add(List<? super T> list,T element){
        list.add(element);
        System.out.println("我是add");
        list.forEach(t -> {
            System.out.println(t.toString());
        } );
    }

    }
