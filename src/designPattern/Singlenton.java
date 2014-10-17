package designPattern;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.junit.Test;

public class Singlenton {
	@Test
	public void test1() throws Exception {
		Apple apple1=Apple.getInstance();
		System.err.println(apple1);
		Apple apple2=Apple.getInstance();
		System.err.println(apple2);
	}
	@Test
	public void test2() throws Exception {
		Apple apple1=Apple.getInstance();
		System.err.println(apple1);
		Constructor<Apple> c=Apple.class.getDeclaredConstructor();
		c.setAccessible(true);
		Apple apple2= c.newInstance();
		System.err.println(apple2);
	}
	@Test
	public void test3() throws Exception {
		System.err.println(Fruit.Orange.hashCode());
		Field field=Fruit.class.getDeclaredField("Orange");
		System.err.println(field.get(null).hashCode());
		Constructor<Fruit> constructor=Fruit.class.getDeclaredConstructor();
		Fruit fruit=constructor.newInstance();
		System.err.println(fruit);
	}
	@Test
	public void test4() throws Exception {
		Constructor<Abs> constructor=Abs.class.getDeclaredConstructor();
		Abs abs=constructor.newInstance();
//		System.err.println(fruit);
	}
	@Test
	public void test5() throws Exception {
		Constructor<Abss> constructor=Abss.class.getDeclaredConstructor();
		Abss abs=constructor.newInstance();
//		System.err.println(fruit);
	}
}
class Apple{
	private Apple(){
		System.err.println("apple is constructing");
	} 
	private static Apple apple=new Apple();
	public static Apple getInstance(){
		return apple;
	}
}
enum Fruit{
	Orange,
	Oradnge;
	int a=2; 
	private Fruit(){
		System.err.println("hehhe");
	}
}
abstract class Abs{
	public Abs(){
		System.err.println("Abs");
	}
}
 class Abss{
	public Abss(){
		System.err.println("Abss");
	}
}