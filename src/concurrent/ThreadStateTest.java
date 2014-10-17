package concurrent;

public class ThreadStateTest {
	public static void main(String[] args) {
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
			  for (int i = 0; i < 1000; i++) {
//				sync
				  for (int j = 0; j < 1000; j++) {
					
				}
				  synchronized (this) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			  }
				
			}
		});
		System.err.println(t.getId()+" "+t.getName()+" "+t.getState());
		t.start();
		while(!t.getState().equals(Thread.State.TERMINATED)){
			System.err.println(t.getId()+" "+t.getName()+" "+t.getState());
		}
	}
}
