package com.lmx.thread;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class BinarySemaphoreTest {
	public static void main(String[] args) {
		final Printer printer=new Printer();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				public void run() {
					printer.print();
				}
			}).start();
			
		}
	}
}
class Printer {
	private Semaphore semaphore=new Semaphore(2);
	public void print(){
		try {
			semaphore.acquire();
			int time=new Random().nextInt(2);
			System.err.println(Thread.currentThread().getName()+" is printing");
			TimeUnit.SECONDS.sleep(time);
			System.err.println(Thread.currentThread().getName()+" complete printing");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			semaphore.release();
		}
	}
}
