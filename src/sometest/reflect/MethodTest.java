package sometest.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class  MethodTest<D extends String>{
	@Test
	public void test1() {
		MethodTest methodTest=new MethodTest();
		methodTest.sss("dsfdsfaa","",3);  //接受任意参数
	} 
	@Test
	public void test2() {
		try {
			Method[] ms=MethodTest.class.getDeclaredMethods();
			for (Method m : ms) {
				TypeVariable[] typeVariables=m.getTypeParameters();
				for (TypeVariable typeVariable : typeVariables) {
					System.err.println(typeVariable);
					System.err.println(typeVariable.getGenericDeclaration());
				}
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	@Test
	public void test3() {
		try {
			Method[] ms=MethodTest.class.getDeclaredMethods();
			for (Method m : ms) {
				TypeVariable[] typeVariables=m.getTypeParameters();
				for (TypeVariable typeVariable : typeVariables) {
					System.err.println(typeVariable);
					System.err.println(typeVariable.getGenericDeclaration());
				}
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	@Test
	public static void test4() {
		try {
			Method[] ms=MethodTest.class.getDeclaredMethods();
			for (Method m : ms) {
				Type[] typeVariables=m.getGenericParameterTypes();
				System.err.println(m);
				for (Type typeVariable : typeVariables) {
					System.err.print(typeVariable.getClass()+" ");
//					System.err.println(typeVariable.getGenericDeclaration());
				}
				System.err.println();
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public <DFa extends List> MethodTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public < DF> void sss(DF df,String d,int a){
		System.err.println(df);
	}
	public static void main(String[] args) {
		test4();
	}
}
