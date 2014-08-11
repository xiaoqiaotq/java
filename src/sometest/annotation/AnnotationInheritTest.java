package sometest.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.annotation.Resource;

public class AnnotationInheritTest {
    public static void main(String[] args) throws SecurityException, NoSuchMethodException {
		Person p=new Boy();
		Method addMethod=p.getClass().getMethod("add");
		Method getMethod=p.getClass().getMethod("get");
		MyAnnotation myAnnotation=addMethod.getAnnotation(MyAnnotation.class);
		Boolean b=addMethod.isAnnotationPresent(MyAnnotation.class);
		System.err.println(b+":"+myAnnotation);
		Annotation[] annotations=addMethod.getAnnotations();
		System.err.println("addMethod:"+Arrays.toString(annotations));
		annotations=getMethod.getAnnotations();
		System.err.println("getMethod:"+Arrays.toString(annotations));
	}
}

class Person{
	@MyAnnotation
	public void add(){
		System.err.println("person-------add");
	}
}
class Boy extends Person implements IPerson{
	public void add() {
		// TODO Auto-generated method stub
		System.err.println("boy-------addd");
	}

	@Override
	public void get() {
		System.err.println("get");
	}
}
interface IPerson{
	@MyAnnotation
	public void get();
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@interface MyAnnotation {
	
}
