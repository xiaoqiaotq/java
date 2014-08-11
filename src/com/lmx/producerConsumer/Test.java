package com.lmx.producerConsumer;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

	//���ܸĶ���Test��	
	public class Test extends Thread{
		
		private TestDo testDo;
		private String key;
		private String value;
		
		public Test(String key,String key2,String value){
			this.testDo = TestDo.getInstance();
			/*����"1"��"1"��ͬһ�������������д������Ҫ��"1"+""�ķ�ʽ�����µĶ���
			��ʵ������û�иı䣬��Ȼ��ȣ�����Ϊ"1"����������ȴ������ͬһ����Ч��*/
			this.key = key+key2; 
			this.value = value;
		}


		public static void main(String[] args) throws InterruptedException{
			Test a = new Test("1","","1");
			Test b = new Test("1","","2");
			Test c = new Test("3","","3");
			Test d = new Test("4","","4");
			System.out.println("begin:"+(System.currentTimeMillis()/1000));
			a.start();
			b.start();
			c.start();
			d.start();
		}
		
		public void run(){
			testDo.doSome(key, value);
		}
	}

	class TestDo {

		private TestDo() {}
		private static TestDo _instance = new TestDo();	
		public static TestDo getInstance() {
			return _instance;
		}
		private ConcurrentMap<Object, String> map=new ConcurrentHashMap<Object,String>();

		public void doSome(Object key, String value) {
			
			// �Դ������ڵ�����Ҫ�ֲ�ͬ���Ĵ��룬���ܸĶ�!
			String val=map.putIfAbsent(key, value);
			if(val!=null){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			{
				try {
					Thread.sleep(1000);
					System.out.println(key+":"+value + ":"
							+ (System.currentTimeMillis() / 1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
