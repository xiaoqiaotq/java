package com.lmx.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ArrayListTest {
	public static void main(String[] args) {
		final CountDownLatch countDownLatch=new CountDownLatch(10000);
//		final List list=new CopyOnWriteArrayList();
		final List list=new ArrayList();
		for (int i = 0; i < 10000; i++) {
			new Thread(new Runnable() {
				public void run() {
					list.add(new Random().nextInt(8));
					countDownLatch.countDown();
				}
			}).start();
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println(list.size());
	}
}
