package com.lmx.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTaskTest {
 public static void main(String[] args) {
	FutureTask<String> futureTask=new FutureTask<String>(new Callable<String>() {
		public String call() throws Exception {
			System.err.println("task: "+Thread.currentThread().getName());
			TimeUnit.SECONDS.sleep(3);
			int a=1/0;
			return "dd";
		}
	});
	futureTask.run();
	try {
		System.err.println("main: "+Thread.currentThread().getName());
		System.err.println("waiting to get result");
		String result=futureTask.get(2,TimeUnit.SECONDS);
		System.err.println(result);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ExecutionException e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
	} catch (TimeoutException e) {
		futureTask.cancel(true);
		e.printStackTrace();
	}
	
 }
}
