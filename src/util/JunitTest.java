package util;

import javaDoc.TestExportAPI;

import org.junit.Test;

public class JunitTest extends S {
	static{
		 System.err.println("------static JunitTest-----------");
	 }
	 public JunitTest() {
//		 super("dd");
		 System.err.println("------ JunitTest constructor block-----------");
		 // TODO Auto-generated constructor stub
	 }
	 {
		 
	 }
	@Test
	public void test1(){
		System.err.println(this);
	}
	@Test
	public void test2(){
		System.err.println(this);
		TestExportAPI api=new TestExportAPI();
		D a=new D();
	}
	@Test
	public void test(){
		System.err.println("super:");
		super.say();
		System.err.println("test()--"+this);
		System.err.println("this:"+this.toString());
	}
	 public void say(){
		 System.err.println(this+"---------say child------------");
	 }
}
 abstract class S{
	 public S(){
		 try {
			System.err.println("-------construtor-S-----------"+this.getClass().getSuperclass().newInstance());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public S(String s){
		 System.err.println("-------"+s+"-----------"+this);
	 }
	 static{
		 System.err.println("------static S-----------");
	 }
	 public void say(){
		 System.err.println("---------say------------");
		 
	 }
 }
class D extends S{
	
	public void test(){
		System.err.println("super:"+super.toString());
		System.err.println("this:"+this.toString());
	}
}