package sometest;

import com.google.gson.Gson;

public class TestJson {
	public static void main(String[] args) {
		Gson gson=new Gson();
		String res = gson.toJson(new A());
		System.out.println(res);
	}
}
class A{
	private String a=null;
	private String b=null;
}
