package js;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.junit.Test;

public class Snippet {
	/** 
	 * simple,默认java.*包中的API已经倒入到engine中。你可以使用那些API 
	 * @throws Exception 
	 */  
	@Test
	public  void invoke1() throws Exception{  
	    ScriptEngineManager engineManager = new ScriptEngineManager();  
	    ScriptEngine engine = engineManager.getEngineByName("javascript");  
	    //根据“脚本语言名称”获取执行引擎，java本身默认只支持javascript，对于其他脚本，可以  
	    //使用第三方包(apache bsf,不过不是很好用)  
	    //getEngineByName方法每次都会创建一个心的Engine对象  
	    //java.lang包默认已经导入  
	    String script = "var message = 'This is javascript.';println(java.lang.System.currentTimeMillis());var total = 2;println(total.toSource())";  
	    engine.put("messagea", this);
	    engine.eval(script);  
	    Object total = engine.get("message");  
	    System.out.println(total);     
	}  
}

