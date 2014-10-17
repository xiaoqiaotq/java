package reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class SomeTest {
	public class DDD{
		
	}
	@Test
	public void test1()throws Exception{
		Class<A> a=(Class<A>) new A().getClass();
		A<String> b=new A<String>();
		TypeVariable[] t=a.getTypeParameters();
		System.err.println(t[0].getName());
		Method m=a.getDeclaredMethod("tes", String.class);
		System.err.println(m.getTypeParameters()[0].getGenericDeclaration());
	
	}
	@Test
	public void test2()throws Exception{
		Class<A> b=A.class;
		System.err.println(b.getGenericSuperclass());
		Type type=b.getGenericSuperclass();
		System.err.println(((ParameterizedType)type).getActualTypeArguments()[0]);
		System.err.println(b.getSuperclass());
	}
	@Test
	public void test3()throws Exception{
		test4(new ArrayList());
	}
	public void test4( List e)throws Exception{
		System.err.println(e instanceof List);
	}
	 @Test
	 public void test5(){
		 int  index="abcd".indexOf("cd");
		 System.err.println(index);
		 System.err.println(new Double[]{});
		 System.err.println(new String[][]{});
		 System.err.println();
	 }
	 @Test
	 public void test(){}
}
class A<T > extends LinkedList<String> implements Iface<List<T>>{
	A a;
	int b;
	public A() {
		 TypeVariable[] typeVariable=this.getClass().getTypeParameters();
		 for (TypeVariable typeVariable2 : typeVariable) {
			System.err.println(typeVariable2.getGenericDeclaration());
		}
	}
	public <T> T tes(T a){
		try {
			T t=(T)a.getClass().newInstance();
			class C{
				
			}
			new C(){};
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	static class CCC{}
	 class DDD{}
	 
	 class MyClassLoader extends ClassLoader{
		 
	 }
}
