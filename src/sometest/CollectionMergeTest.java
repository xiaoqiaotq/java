package sometest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CollectionMergeTest {
	public static void main(String[] args) {
		List<Fruit> list1=new ArrayList<Fruit>();
		List<Fruit> list2=new ArrayList<Fruit>();
		list1.add(Fruit.APPLE);
		list2.add(Fruit.ORANGE);
		list2.add(Fruit.APPLE);
		Collections.addAll(list1, list2.toArray(new Fruit[]{}));
		System.err.println(new HashSet(list1));
		
	}
}
/**
 * @author Administrator 2014年9月24日
 * 
 */
enum Fruit{
	APPLE,ORANGE,TOMATO,GRAPE;

	
}
