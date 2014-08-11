package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.security.MessageDigest;

import org.junit.Test;

public class Digest {
	public static void main(String[] args) throws Exception{
		MessageDigest digest=MessageDigest.getInstance("md5");
		FileInputStream file=new  FileInputStream("D:/My Documents/Downloads/taglibs-standard-1.2.1-source-release.zip");
		byte[] bytes=new byte[file.available()]; //19b6a275024cfea7532fb2f1e79311fb
		file.read(bytes);
		System.err.println(MD5(bytes));
	}
	public  static String MD5(byte[] bytes){
		 char hexDigits[] = {
           '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
           'e', 'f'};
		 try {
			 MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			 mdTemp.update(bytes);
			 byte[] md = mdTemp.digest();
			 int j = md.length;
			 char str[] = new char[j * 2];
			 int k = 0;
			 for (int i = 0; i < j; i++) {
	             byte byte0 = md[i];
	             str[k++] = hexDigits[byte0 >>>4 & 0xf];
	             str[k++] = hexDigits[byte0 & 0xf];
	         }
	         return new String(str);
	     }catch (Exception e){
	         return null;
	     }
	}
	@Test
	public void test(){
		String s=Integer.toHexString(-1);
		System.err.println(s);
	}
}
