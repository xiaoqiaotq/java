package com.lmx.producerConsumer;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class CompleteServiceTest {
	private ExecutorService executorService=Executors.newFixedThreadPool(4);
	private final CompletionService<String> completionService=new ExecutorCompletionService(executorService);
	public static void main(String[] args)throws Exception {
		CompleteServiceTest completeServiceTest=new CompleteServiceTest();
		Producer producer=completeServiceTest.new Producer();
		Consumer consumer=completeServiceTest.new Consumer();
		for (int i = 0; i < 10; i++) {
			new Thread(producer).start();
		}
		new Thread(consumer).start();
//		Thread.sleep(50);
		completeServiceTest.executorService.shutdown();
		
	}
	class Producer implements Runnable{
		public void run() {
			
			completionService.submit(new Callable<String>() {
				public String call() throws Exception {
					String random=new Random().nextInt(3)+"";
					System.err.println("producing .."+random);
					return random;
				}
			});
		}
	}
	 class Consumer implements Runnable{
		public void run() {
			while(true){
				Future<String> dd;
				try {
					dd = completionService.poll(3,TimeUnit.SECONDS);
					if(dd==null){
						break;
					}
					System.err.println(dd.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
}
