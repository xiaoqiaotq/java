package sometest;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class ResourceBoundleTest {
   public static void main(String[] args) {
	   Locale locale=Locale.getDefault();
	   System.err.println(locale);
	  ResourceBundle bundle=ResourceBundle.getBundle("hello", Locale.getDefault());
	  System.err.println(bundle);
	  String v1=bundle.getString("k1");
	  System.err.println(v1);
	  System.err.println(bundle.keySet());
   }
   @Test
   public void testMessageFormat(){
	   String result=MessageFormat.format("dfdf{0}", new ResourceBoundleTest());
	   System.err.println(result);
   }
}
