package reference;

import static org.junit.Assert.*;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ReferenceTest {
     public static void main(String[] args) throws InterruptedException {
		Computer computer=new Computer();
		computer=null;
		System.gc();
		TimeUnit.SECONDS.sleep(5);
		
     }
     @Test
	public void test1() throws Exception {
    	 Computer computer=new Computer();
//    	 Computer computer2=computer;
    	 ReferenceQueue<Computer> queue=new ReferenceQueue<Computer>();
    	 WeakReference<Computer> ref=new WeakReference<Computer>(computer, queue);
    	 System.err.println(ref.get()==computer);
    	 computer=null;
    	 System.gc();
    	 TimeUnit.SECONDS.sleep(5);
    	 Reference<? extends Computer> c=queue.poll();
    	 System.err.println(c);
    	 System.err.println(c==ref);
    	 System.err.println(ref.get());
    	 
		
	}
}
class Computer{

	public void finalliz() {
		// TODO Auto-generated method stub
		System.err.println(this+" is finallizing");
	}
}