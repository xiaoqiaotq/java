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

 public class DoubleTest implements Serializable {
	private static final long serialVersionUID = 5516075349620653480L;

	@Test
	public void test1() {
		String fileName = UUID.randomUUID().toString().replace("-", "")
				+ ".xls";
		System.err.println(fileName);
		System.err.println(UUID.randomUUID().toString().replace("-", ""));
		double d = 33.003300;
		System.err.println(d);
	}
}






