package sometest.reflect;

import java.io.Serializable;

import org.junit.Test;

public class Main {
  private static class StaticInnerClass {

  }

  private class MemberInnerClass implements Serializable {

  }

  private static class ChildClass extends Main {

  }

  public MemberInnerClass getMemberInnerClassInstance() {
    return new MemberInnerClass();
  }

  public static void main(String[] args) {
	   abstract  class A{};
	  System.out.println( A.class.getDeclaringClass() );
	  System.out.println( A.class.getEnclosingClass());
	  System.out.println( A.class.isLocalClass());
	  System.out.println( A.class.isMemberClass());
	  System.out.println( A.class.isAnonymousClass());
	  System.out.println("----------------");
    System.out.println( StaticInnerClass.class.getDeclaringClass() );
    System.out.println( StaticInnerClass.class.getEnclosingClass() );
    System.out.println( MemberInnerClass.class.getDeclaringClass() );
    System.out.println( MemberInnerClass.class.getEnclosingClass() );
    System.out.println( new ChildClass().getMemberInnerClassInstance().getClass().getEnclosingClass() );
    System.out.println( new ChildClass().getMemberInnerClassInstance().getClass().getDeclaringClass() );
  }
  @Test
  public  void test1() {
      new Object() {
          public void test() {
              System.out.println(this.getClass().getDeclaringClass()); //null
              System.out.println(this.getClass().getEnclosingClass()); //not null
          }
      }.test();
  }
  @Test
  public  void test2() {
	  boolean bool=Serializable.class.isAssignableFrom(MemberInnerClass.class);
	  System.err.println(bool);
  }

}