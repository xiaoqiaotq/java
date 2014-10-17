package concurrent;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class BinarySemaphoreTest {
	public static void main(String[] args) {
		final Drawer drawer=new Drawer();
		for (int i = 0; i < 4; i++) {
			new Thread(new Runnable() {
				public void run() {
					drawer.draw();
				}
			}).start();
		}
	}

}
class Drawer {
	private Semaphore semaphore=new Semaphore(1);
	public void draw(){
		try {
			semaphore.acquire(2);
			System.err.println(Thread.currentThread().getName()+" is drawing");
			int time=new Random().nextInt(2);
			TimeUnit.SECONDS.sleep(time);
			System.err.println(Thread.currentThread().getName()+" finish drawing spend "+time +" seconds");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			semaphore.release(2);
		}
	}
}
