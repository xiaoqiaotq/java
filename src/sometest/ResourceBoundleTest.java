package sometest;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBoundleTest {
   public static void main(String[] args) {
	  ResourceBundle bundle=ResourceBundle.getBundle("hello", Locale.CHINA);
	  String v1=bundle.getString("k1");
	  System.err.println(v1);
   }
}
