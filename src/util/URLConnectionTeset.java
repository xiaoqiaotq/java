package util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.junit.*;
public class URLConnectionTeset {
	@Test
	public void test1(){
		User d=new User();
		System.err.println(System.getProperty("java.library.path"));
		System.err.println(d.hashCode());
		System.err.println(Thread.currentThread().hashCode()); 
	}
	@Test
	public void test2()throws Exception{
//		String urlString="http://localhost:8090/TestServlet";
		String urlString="http://liuzhigong.blog.163.com/blog/static/178272375201141194147515?suggestedreading";
//		String urlString="http://localhost:8090/QCSYS";
		URL url=new URL(urlString);
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		conn.connect();
		int code=conn.getResponseCode();
		System.err.println("content£º"+conn.getContent());
		System.err.println("conn£º"+conn);
		System.err.println("contentEncoding£º"+conn.getContentEncoding());
		System.err.println("contentLength:¡¡"+conn.getContentLength());
		System.err.println("contentType:¡¡"+conn.getContentType());
		System.err.println("-----------------header--------");
		Map<String,List<String>> map =conn.getHeaderFields();
		Iterator<String> iter=map.keySet().iterator();
		while(iter.hasNext()){
			String key=iter.next();
			System.err.println(key+" : "+map.get(key));
		}
		System.err.println("----------------body-----------------");
		if (code==200) {
			InputStream in=conn.getInputStream();
//			GZIPInputStream gin=new GZIPInputStream(in);
			System.err.println("³¤¶ÈÎª£º "+in.available());
			byte[] bytes=new byte[1024];
			int len=0;
			while((len=in.read(bytes))>0){
				System.err.println(new String(bytes,0,len,"GBK"));
			}
		}
		conn.disconnect();
	}
}
class User{
	
}
class MyOutputStream extends OutputStream{

	public native void write(int b) throws IOException ;
	
	
}
