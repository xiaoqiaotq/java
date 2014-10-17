package concurrent;


public class FianlizeTest {
	public static void main(String[] args) throws Throwable {
		FianlizeTest fianlizeTest=new FianlizeTest();
//		fianlizeTest=null;
//		System.gc();
		fianlizeTest.finalize();
		
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.err.println("exit.....");
	}

}
