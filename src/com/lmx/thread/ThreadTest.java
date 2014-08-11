package com.lmx.thread;

import org.junit.Test;

public class ThreadTest {
	@Test
	public void test1()throws Exception{
		System.err.println("---main start-----");
		Thread t=new Thread(new Runnable() {
			public void run() {
				System.err.println("---sub start---");
			}
		});
		t.start();
		Thread.sleep(2);
		System.err.println(t.isAlive());
		synchronized(this){
			
			this.wait();
		}
	}
}
