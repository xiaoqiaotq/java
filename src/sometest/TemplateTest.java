package sometest;

import org.junit.Test;

public class TemplateTest {
	@Test
     public void a(){
		 final String a="dfds";
    	 myTemplate(new SomeBussiness() {
			public void doBusiness() {
				System.err.println(a +" is working");
				
			}
		});
     }
     public void b(){
    	 
     }
     public void myTemplate(SomeBussiness bussiness){
    	 System.err.println("---start--");
    	 bussiness.doBusiness();
    	 System.err.println("---end--");
    	 
     }
}
interface SomeBussiness{
	void doBusiness();
}
