package someNeed;

import org.junit.Test;

public class Array1 {
	/**
	 * [1,4,4,2]----->1,4*2,2
	 */ 
	@Test
	public void test1(){
		int[] arr={2,2,3,3,4,3,3,3,33,3};
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i]!=arr[i+1]){
				System.err.print(arr[i]+" ");
				if(i==arr.length-2){
					System.err.println(arr[i+1]);
				}
				continue;
			}
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]==arr[j]){
					if(j==arr.length-1){
						System.err.print(arr[i]+"*"+(j-i+1)+" ");
						return;
					}
					continue;
				}
				System.err.print(arr[i]+"*"+(j-i)+" ");
				if(j==arr.length-1){
					System.err.print(arr[j]);
					return;
				}
				i=j-1;
				break;
			}
		}
	}
}
