public class SingletonClass { 

  public static final SingletonClass instance = new SingletonClass(); 
    
  public static SingletonClass getInstance() { 
    return instance; 
  } 
    
  private SingletonClass() { 
     System.err.println("SingletonClass ");
  } 
    
}
 class Singleton {  
    /**  
     * �༶���ڲ��࣬Ҳ���Ǿ�̬�ĳ�Աʽ�ڲ��࣬���ڲ����ʵ�����ⲿ���ʵ��  
     * û�а󶨹�ϵ������ֻ�б����õ�ʱ�Ż�װ�أ��Ӷ�ʵ�����ӳټ���  
     */  
    private static class SingletonHolder{  
        /**  
         * ��̬��ʼ��������JVM����֤�̰߳�ȫ  
         */  
        private static Singleton instance = new Singleton();  
    }  
    /**  
     * ˽�л����췽��  
     */  
    private Singleton(){  
    	System.err.println("Singleton");
    }  
    public static  Singleton getInstance(){  
        return SingletonHolder.instance;  
    }  
} 