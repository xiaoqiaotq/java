package com.lmx.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		int parties=Runtime.getRuntime().availableProcessors();
		final CyclicBarrier barrier=new CyclicBarrier(parties,new  Runnable() {
			public void run() {
				System.err.println("haha!!!");
			}
		});
		for (int i = 0; i < parties; i++) {
			final int index=i;
			new Thread(new Runnable() {
				public void run() {
					while(true){
						
						System.err.println("waiting..."+index);
						try {
							barrier.await();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (BrokenBarrierException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
		System.err.println("hhhhh");
		
	}
}
