package callback;

public class MainClass {
	public static void main(String[] args) {
		MainClass mainClass=new MainClass();
		mainClass.hehe(2, "dd", new Handler() {
			@Override
			public void handle(String b) {
				// TODO Auto-generated method stub
				System.err.println(b);
				
			}
		});
	}
	public void hehe(int a,String b,Handler handler){
		handler.handle(b);
	}
}
