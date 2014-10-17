package concurrent;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class ConcurrentTest {
	@Test
	public void test1(){
		Queue queue=new LinkedList();
		queue.offer("av");
		queue.offer("aaa");
		Object o1=queue.poll();
		Object o2=queue.element();
		Object o3=queue.peek();
		Object o4=queue.poll();
		Object o5=queue.element();
		System.err.println(o1);
		System.err.println(o2);
		System.err.println(o3);
	}
}
