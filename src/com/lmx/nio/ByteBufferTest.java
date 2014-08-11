package com.lmx.nio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

import org.junit.Test;

public class ByteBufferTest {
	@Test
	public void test1() throws IOException{
		RandomAccessFile rf=new RandomAccessFile("d:/abc.txt", "rw");
		FileChannel fc=rf.getChannel();
		ByteBuffer  buf=ByteBuffer.allocate(20);
		int size=0;
		while((size=fc.read(buf))>0){
			System.err.println("offset: "+buf.arrayOffset());
			System.err.println("limit: "+buf.limit());
			System.err.println("pos: "+buf.position());
			System.err.println("remaining: "+buf.remaining());
			buf.flip();
			System.err.println("limit: "+buf.limit());
			System.err.println("pos: "+buf.position());
			System.err.println("remaining: "+buf.remaining());
			System.err.println("readonly: "+buf.isReadOnly());
			System.err.println("direct: "+buf.isDirect());
			System.err.println("hasArray: "+buf.hasArray());
			byte[] bytes=buf.array();
			System.err.println(Arrays.toString(bytes));
			buf.clear();
			System.err.println("size: "+bytes.length);
			while(buf.hasRemaining()){
				
				System.err.print((char)buf.get());
			}
			buf.clear();
		}
		rf.close();
	}
	@Test
	public void test2() throws IOException{
		BufferedReader bfd=new BufferedReader(new InputStreamReader(new FileInputStream("D:/abc.doc"),"utf-8"));
		String line=null;
		while((line=bfd.readLine())!=null){
			System.err.println(line);
		}
		bfd.close();
	}
	@Test
	public void test3() throws IOException{
		RandomAccessFile rf=new RandomAccessFile("d:/random.txt", "rw");
		rf.seek(8);
		System.err.println("length: "+rf.length());
		FileChannel fc=rf.getChannel();
		System.err.println("position: "+fc.position());
		ByteBuffer buf=ByteBuffer.allocate(21);
		System.err.println("size: "+fc.size());
		rf.close();
	}
	@Test
	public void test4() throws IOException{
		RandomAccessFile rf=new RandomAccessFile("d:/random.txt", "rw");
		rf.seek(rf.length());
		FileChannel fc=rf.getChannel();
		ByteBuffer buf=ByteBuffer.allocate(1024);
		buf.clear();
		buf.put("hello this is test!!!Äãaaa".getBytes("utf-8"));
		buf.flip();
		fc.write(buf);
		fc.close();
		rf.close();
	}
}
