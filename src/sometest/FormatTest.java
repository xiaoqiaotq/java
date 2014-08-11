package sometest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class FormatTest {
  @Test
  public void test1(){
//	  DateFormat df=DateFormat.getDateInstance(DateFormat.FULL);
//	  DateFormat df=DateFormat.getDateTimeInstance();
	  DateFormat df=DateFormat.getTimeInstance();
	  
	  String formatString=df.format(new Date());
	  System.err.println(formatString);
  }
  @Test
  public void test2(){
//	  DateFormat df=DateFormat.getDateInstance(DateFormat.FULL);
//	  DateFormat df=DateFormat.getDateTimeInstance();
	  DateFormat df=new SimpleDateFormat("yyyy");
	  
	  String formatString=df.format(new Date());
	  System.err.println(formatString);
  }
}
