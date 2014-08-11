package sometest;

import java.util.concurrent.TimeUnit;

public class Array2D {
 public static void main(String[] args) {
	 int[][] a=new int[3][3];
	 a[0][0]=1;
	 a[0][1]=1;
	 a[1][0]=1;
	 a[2][0]=1;
	 System.err.println(a.length);
	 for (int i = 0; i < a.length; i++) {
		for (int j = 0; j < a[i].length; j++) {
			System.err.print(a[i][j]);
		}
		System.err.println();
	}
	 System.err.println(TimeUnit.DAYS.convert(1, TimeUnit.DAYS));
 }
}
