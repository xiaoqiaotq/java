package concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
	public static void main(String[] args) {
		final CountDownLatch countDownLatch=new CountDownLatch(2);
			new Thread(new Runnable() {
				public void run() {
					try {
					countDownLatch.await();
					System.err.println("-----end-----");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				}
			}).start();
		for (int i = 0; i < 3; i++) {
			final int order=i;
			new Thread(new Runnable() {
				public void run() {
					new Conference("00"+order, countDownLatch).arrive();
				}
			}).start();
		}
	}
}
class Conference{
	private CountDownLatch countDownLatch;
	private String name;

	public Conference(String name,CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
		this.name=name;
	}
	public void arrive(){
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(3));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		countDownLatch.countDown();
		System.err.println(name+ "is arrived waiting for "+countDownLatch.getCount());
	}
	
	
}