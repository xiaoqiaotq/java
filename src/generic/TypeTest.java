package generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;

import org.junit.Test;

public class TypeTest {
	public static void main(String[] args) {
		A b=new A();
		TypeVariable[] ts=b.getClass().getTypeParameters();
		for (TypeVariable typeVariable : ts) {
			System.err.println(typeVariable.getGenericDeclaration());
		}
	}
	@Test
	public void test1(){
		ParameterizedType type=(ParameterizedType) B.class.getGenericSuperclass();
		System.err.println(type.getClass());
		System.err.println(type.getOwnerType());
		System.err.println(type.getRawType());
		Type[] classes=type.getActualTypeArguments();
		for (Type type2 : classes) {
			System.err.println(type2);
		}
	}
}
class A<K,V>{
	public void say(K k){
		System.err.println(k);
	}
	
}
class B extends A<String,Math>{}