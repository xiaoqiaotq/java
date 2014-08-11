package sometest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;

import org.junit.Test;

public class OgnlTest {
	@Test
	public void test1() throws Exception{
		Map map=new HashMap();
		map.put("head", "xiaoniu");
		Xn xn=new Xn();
		Ognl.setValue("head",xn, "33");
//		System.err.println(Ognl.getValue("@java.lang.Runtime@getRuntime().exit(1)", xn));
		System.err.println(Ognl.getValue("new String('head')", xn));
		System.err.println(Ognl.getValue("#headd+'aaaa'", map,xn));
		System.err.println(xn);
		System.err.println('\u0023');
		System.err.println('\u003d'); 
	}
}
class Xn{
	private String head;
	private int foot;
	@Override
	public String toString() {
		return "Xn [head=" + head + ", foot=" + foot + "]";
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public int getFoot() {
		return foot;
	}
	public void setFoot(int foot) {
		this.foot = foot;
	}
	
}
