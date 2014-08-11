package com.lmx.producerConsumer;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMyBlockingQueue {
	public static void main(String[] args) {
		final ExecutorService pool=Executors.newCachedThreadPool();
		final MyBlockingQueue<String> blockingQueue=new MyBlockingQueue(2);
		for (int i = 0; i < 5; i++) {
			pool.submit(new Runnable() {
				public void run() {
					String aa=new Random().nextInt(3)+"";
					System.err.println("is putting "+aa);
					blockingQueue.put(aa);
				}
			});
		}
		for (int i = 0; i < 10; i++) {
			final String res=blockingQueue.take();
			pool.submit(new Runnable() {
				public void run() {
					System.err.println(res);
				}
			});
		}
	}
}
interface Consumerable<T>{
	public void consume(T t);
}
interface Productable<T>{
	public T produce();
}
