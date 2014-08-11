public class TestInterrupt implements Runnable {

	@Override
	public void run() {
		while(true)
		{
			try{
				Thread.sleep(5000);
				System.out.println("running");
			}catch(Exception e)
			{
			   e.printStackTrace();
			   System.err.println("³öÏÖÒì³£....");
			}
		}
	
	}
	public static void main(String []ars)
	{	
		System.err.println(System.err);
		System.err.println("err1");
		System.err.println("err2");
		System.out.println("out1");
		System.err.println("err3");
		System.out.println("out3");
		System.err.println("err4");
		System.out.println("out2");
		System.out.println("out4");
	}

}