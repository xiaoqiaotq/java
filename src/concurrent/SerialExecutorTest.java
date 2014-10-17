package concurrent;

import java.util.concurrent.Executors;

public class SerialExecutorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SerialExecutor executor=new SerialExecutor(Executors.newFixedThreadPool(10));
		executor.execute(new Runnable() {
			public void run() {
				System.err.println("ok");
			}
		});

	}

}
