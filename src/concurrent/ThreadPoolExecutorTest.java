package concurrent;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
 public static void main(String[] args) {
	Server server=new Server();
	for (int i = 0; i <20; i++) {
		final int index=i;
		server.executeTask(new Runnable() {
			public void run() {
//				try {
					System.err.println(Thread.currentThread().getName()+" task "+index+" is running");
//					TimeUnit.SECONDS.sleep(new Random().nextInt(2));
					System.err.println(Thread.currentThread().getName()+" task "+index+" is end");
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		});
	}
	server.endServer();
	System.err.println("----end----");
 }
}
class Server{
	private ThreadPoolExecutor pool=(ThreadPoolExecutor) Executors.newCachedThreadPool();
	public void executeTask(Runnable task){
		
		pool.execute(task);
		System.err.println("server: pool size "+pool.getPoolSize());
		System.err.println("server: active count "+pool.getActiveCount());
		System.err.println("server: MaximumPoolSize "+pool.getMaximumPoolSize());
		System.err.println("server: CompletedTaskCount "+pool.getCompletedTaskCount());
	}
	public void endServer(){
		pool.shutdown();
		pool.shutdownNow();
	}
}
