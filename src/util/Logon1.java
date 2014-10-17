package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.EventObject;
import java.util.UUID;

import org.junit.Test;

 class Logon implements Serializable {
	private static final long serialVersionUID = 5516075349620653480L;

	@Test
	public void test1() {
		String fileName = UUID.randomUUID().toString().replace("-", "")
				+ ".xls";
		System.err.println(fileName);
		System.err.println(UUID.randomUUID().toString().replace("-", ""));
		Double d = 33d;
		System.err.println(d.toString());
	}
}

class MyEvent extends EventObject {

	public MyEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	public String getAA() {
		return (String) source;
	}

}



public class Logon1 implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5374454055792840569L;
	private Date date = new Date();
	private String username;
	private  String password;

	Logon1(String name, String pwd) {
		username = name;
		password = pwd;
	}

	public String toString() {
		String pwd = (password == null) ? "(n/a)" : password;
		return "logon info: \n " + "username: " + username + "\n date: "
				+ date.toString() + "\n password: " + pwd;
	}

	public static void main(String[] args) {
		Logon1 a = new Logon1("Hulk", "myLittlePony");
		System.out.println("logon a = " + a);
		try {
			ByteArrayOutputStream arrayOutputStream=new ByteArrayOutputStream();
			ObjectOutputStream o = new ObjectOutputStream(arrayOutputStream);
			o.writeObject(a);
			o.close();
			// Delay:
			int seconds = 5;
			long t = System.currentTimeMillis() + seconds * 1000;
			while (System.currentTimeMillis() < t)
				;
			// Now get them back:
			ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(arrayOutputStream.toByteArray()));
			System.out.println("----------------Recovering object at " + new Date());
			Logon1 b = (Logon1) in.readObject();
			Field[] fs=b.getClass().getDeclaredFields();
			for (Field field : fs) {
				System.err.println(field.getName()+": "+field.get(b));
			}
			System.err.println(a==b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} // /:~