package com.lmx.thread;

import java.util.concurrent.Exchanger;

public class SendAndReceiver{
   private final Exchanger<StringBuilder> exchanger = new Exchanger<StringBuilder>();
   private class Sender implements Runnable{
      public void run(){
         try{
            StringBuilder content = new StringBuilder("Hello");
            content = exchanger.exchange(content);
            System.err.println(Thread.currentThread().getName()+": "+content);
         }catch(InterruptedException e){
            Thread.currentThread().interrupt();
         }
      }
   }
   private class Receiver implements Runnable{
      public void run(){
         try{
            StringBuilder content = new StringBuilder("World");
            content = exchanger.exchange(content);
            System.err.println(Thread.currentThread().getName()+": "+content);
         }catch(InterruptedException e){
            Thread.currentThread().interrupt();
         }
      }
   }
   public static void main(String[] args) {
	   SendAndReceiver sendAndReceiver=new SendAndReceiver();
	   new Thread(sendAndReceiver.new Sender(),"sender").start();
	   new Thread(sendAndReceiver.new Receiver(),"receiver").start();
   }
}