package util;

import java.text.DecimalFormat;

public class EnumTest {
public static void main(String[] args) {
	Week e=Week.MON;
	Week e1=Week.MON;
	Week[] w=Week.values();
	for ( Week w1: w) {
		System.err.println(w1);
	}
	double d=332236.22;
	System.err.println(new DecimalFormat("00.00##").format(d));
	System.err.println(Double.valueOf("5.0000"));
	System.err.println((int)(3*4.6));
	System.err.println((1 & 3)!=0);
	System.err.println('\u0061');
	char a='倒';
	System.err.println(Integer.toHexString((a>>8)&0xff));
	System.err.println(a&0xff);
	System.err.println(a=='\u8018');
	System.err.println('\u5012');
}
}
enum Week{
	MON,TUES,WEND;
	static{
		for (Week w : Week.values()) {
			System.err.println(w);
		}
		System.err.println("hello enum");

	}

}