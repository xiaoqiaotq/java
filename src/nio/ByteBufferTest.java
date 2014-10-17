package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.util.Date;

public class ByteBufferTest {
     public static void main(String[] args) throws Exception {
    	 ByteBuffer byteBuffer=ByteBuffer.allocate(32);
    	 byteBuffer.put("abcde".getBytes());
    	 System.err.println(byteBuffer.position());
    	 System.err.println(byteBuffer.limit());
    	 System.err.println(byteBuffer.capacity());
    	 System.err.println(ServerSocketChannel.open());
    	 System.err.println(System.currentTimeMillis());
    	 System.err.println(new Date(System.currentTimeMillis()));
     }
}
