package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class LockTest {

	public static void main(String[] args) {
		final Printer printer=new Printer();
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.err.printf("%s start \n",Thread.currentThread().getName());
			
					printer.print();
					System.err.printf("%s end \n",Thread.currentThread().getName());
				}
			}).start();
		}
	}

}
class Printer {
	private Lock lock=new ReentrantLock();
	public void print(){
		lock.lock();
		try{
			
			System.err.printf("%s: is printing\n",Thread.currentThread().getName());
		}finally{
			
			lock.unlock();
			System.err.println("locked");
		}
		System.err.println("hahah");
	}
	
}
