package com.lmx.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureTest {
	public static void main(String[] args) {
		List<Callable<String>> list=new ArrayList();
		for (int i = 0; i < 100; i++) {
			Callable<String> callable=new Callable<String>() {
				@Override
				public String call() throws Exception {
					// TODO Auto-generated method stub
					System.err.println("calling is invoke1 "+Thread.currentThread().getName());
					Thread.sleep(1);
					return Thread.currentThread().getName();
				}
			};
			list.add(callable);
			
		}
		ExecutorService executorService=Executors.newFixedThreadPool(4);
		try {
			String val=executorService.invokeAny(list);
			System.err.println(val);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		executorService.shutdown();
		try {
			boolean aa=executorService.awaitTermination(1, TimeUnit.MILLISECONDS);
			System.err.println(aa);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("main is end");
	}
}
