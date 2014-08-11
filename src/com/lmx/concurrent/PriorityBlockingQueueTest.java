package com.lmx.concurrent;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTest {
	public static void main(String[] args) throws Exception{
		PriorityBlockingQueue<String> priorityBlockingQueue=new PriorityBlockingQueue(); 
		priorityBlockingQueue.offer("abc");
		priorityBlockingQueue.offer("bcd");
		priorityBlockingQueue.offer("acd");
		System.err.println(priorityBlockingQueue);
		System.err.println(priorityBlockingQueue.poll());
		System.err.println(priorityBlockingQueue.take());
		System.err.println(priorityBlockingQueue.take());
		System.err.println(priorityBlockingQueue.poll());
		System.err.println(priorityBlockingQueue.poll());
		System.err.println(priorityBlockingQueue.take());
		System.err.println(priorityBlockingQueue);
	}
}
