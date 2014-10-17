import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;


public class Main implements Cloneable,Serializable {
	private String name;
	private int age;
	private Main main;
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Main [age=" + age + ", name=" + name + "]";
	}
	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Main(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public static void main(String[] args)throws Exception {
//		Main main1=new Main();
//		Main param=new Main("21",21);
//		System.err.println(param.hashCode());
//		main1.setMain(param);
//		Main main2=(Main)main1.clone(); 
//		System.err.println(main2.getMain().hashCode());
		test();
	}
	public static void test()throws Exception {
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		Main main1=new Main();
		Main param=new Main("www",23);
		System.err.println(param.hashCode());
		main1.setMain(param);
		oos.writeObject(main1);
		
		ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
		Main main2=(Main)ois.readObject();
		System.err.println(main2.getMain().hashCode());
	}
}
