package sometest;

import java.util.concurrent.Executors;

public class SystemTest {
	public static void main(String[] args) throws Exception{
		System.err.println(System.currentTimeMillis());
		Thread.sleep(1);
		System.err.println("hello world");
		System.err.println("hello world");
		System.err.println("hello world");
		System.err.println(System.nanoTime());
		System.err.println(System.currentTimeMillis());
		System.err.println(System.currentTimeMillis());
		Object a=Executors.newFixedThreadPool(2);
		System.err.println(a);
	}
}	
