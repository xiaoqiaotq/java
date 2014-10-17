package concurrent;

public class ThreadTest extends Thread{
	private boolean done;
	private int value;
	
	@Override
	public void run() {
		while(!done) {   //A
			System.err.println("before");
			Thread.yield();
			System.err.println("end");
		}
		System.out.println(value); //D
	}
	
	public void done() {
		done = true;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public static void main(String[] args) throws Exception{
		ThreadTest r = new ThreadTest();
		r.start();
		Thread.sleep(1);
		r.setValue(1); //B
		r.done(); //C
	}
}
