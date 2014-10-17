package com.lmx.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadOrder2 {
	public static void main(String[] args) {
		int threads=7;
		final Account account=new Account(1,3);
			new Thread(new Runnable() {
				public void run() {
//					System.err.println((char)('A'+index));
					try {
						while(true){
							account.increment();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
			new Thread(new Runnable() {
				public void run() {
//					System.err.println((char)('A'+index));
					try {
						while(true){
							
							account.decrement();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
	}
}
class Account{
	private int max;
	private int min;
	private int money;
	private Lock lock=new ReentrantLock();
	public Account(int min,int max) {
		this.max=max;
		this.min=min;
	}
	Condition notMaxCondition=lock.newCondition();
	Condition notMinCondition=lock.newCondition();
	public void increment() throws InterruptedException{
		lock.lock();
		try{
			while(money>=max){
				notMaxCondition.await();
			}
			System.err.println(money);
			money++;
			notMinCondition.signal();
		}finally{
			lock.unlock();
		}
	}
	public void decrement() throws InterruptedException{
		lock.lock();
		try{
			while(money<=min){
				notMinCondition.await();
			}
			System.err.println(money);
			money--;
			notMaxCondition.signal();
		}finally{
			lock.unlock();
		}
	}
}
