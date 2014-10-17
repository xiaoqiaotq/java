package com.lmx.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 哲学家进餐
 * @author Administrator
 *
 */
public class HavingSupperTest {
	public static final int PERSONS=5;
	public static void main(String[] args) {
		ExecutorService service=Executors.newFixedThreadPool(PERSONS);
		for (int i = 0; i < PERSONS; i++) {
			service.submit(new Supper(i));
		}
//		System.err.println("");
		service.shutdown();
	}
}
class Supper implements Runnable{
	private int index;
	private static Lock[] chopsticks=new Lock[5];
	static{
		for (int i = 0; i < 5; i++) {
			chopsticks[i]=new ReentrantLock();
		}
	}
	public Supper(int index) {
		this.index=index;
	}
	@Override
	public void run() {
		while(true){
			if(chopsticks[index].tryLock()){
				try{
					int right=(index+1)%HavingSupperTest.PERSONS;
					if(chopsticks[right].tryLock()){
						try{
							System.err.println(index+" : success");
							break;
						}finally{
							chopsticks[index].unlock();
//							System.err.println(right+" lock release");
						}
					}else{
//						System.err.println(index+" right error");
					}
				}finally{
					chopsticks[index].unlock();
//					System.err.println(index+" lock release");
				}
			}else{
//				System.err.println(index+" left error");
			}
//			System.err.println(index+ " try again");
		}
		
	}
}
