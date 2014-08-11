package com.lmx.producerConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue <T>{
  private T[] items;
  private int index;
  private Lock lock=new ReentrantLock();
  private Condition notFull=lock.newCondition();
  private Condition notEmpty=lock.newCondition();

public MyBlockingQueue(int size) {
	super();
	this.items = (T[]) new Object[size];
}
public void put(T t){
	lock.lock();
	try{
		if(index>items.length-1){
			notFull.await();
		}
		items[index]=t;
		index++;
		notEmpty.signal();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
		lock.unlock();
	}
}
public T take(){
	lock.lock();
	try{
		if(items.length==0){
			try {
				notEmpty.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		index--;
		notFull.signal();
		return items[index];
	}
	finally{
		lock.unlock();
	}
}
  
}
