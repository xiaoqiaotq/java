package js;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.junit.Test;

public class Snippet {
	/** 
	 * simple,Ĭ��java.*���е�API�Ѿ����뵽engine�С������ʹ����ЩAPI 
	 * @throws Exception 
	 */  
	@Test
	public  void invoke1() throws Exception{  
	    ScriptEngineManager engineManager = new ScriptEngineManager();  
	    ScriptEngine engine = engineManager.getEngineByName("javascript");  
	    //��ݡ��ű�������ơ���ȡִ�����棬java����Ĭ��ֻ֧��javascript����������ű�������  
	    //ʹ�õ����(apache bsf,�����Ǻܺ���)  
	    //getEngineByName����ÿ�ζ��ᴴ��һ���ĵ�Engine����  
	    //java.lang��Ĭ���Ѿ�����  
	    String script = "var message = 'This is javascript.';println(java.lang.System.currentTimeMillis());var total = 2;println(total.toSource())";  
	    engine.put("messagea", this);
	    engine.eval(script);  
	    Object total = engine.get("message");  
	    System.out.println(total);     
	}  
}

