

import org.junit.Test;

public class DeadLock {
	public static void main(String[] args) {
		
		final DeadLockDemo d1=new DeadLockDemo();
		final DeadLockDemo d2=new DeadLockDemo();
		new Thread(){
			public void run() {
				d1.doA(d2);
			};
		}.start();
		
		new Thread(){
			public void run() {
				d2.doB(d1);
			};
		}.start();
	}
}
class DeadLockDemo{
	public  synchronized void doA(DeadLockDemo d){
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d.doC();
		System.err.println(Thread.currentThread().getName()+"--end---");
	}
	public  synchronized void doB(DeadLockDemo d){
		d.doC();
		System.err.println(Thread.currentThread().getName()+"--end---");
	}
	public  synchronized void doC(){
		System.err.println(Thread.currentThread().getName()+"-------");
	}
}
