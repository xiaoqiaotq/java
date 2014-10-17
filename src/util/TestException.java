package util;

import org.junit.Test;

public class TestException {
	
	static{
		
	}
	
	public TestException() {
		String s=null;
		s.charAt(0);
	}

	@Test
	public void test(){
		System.err.println("d--");
	}
}
