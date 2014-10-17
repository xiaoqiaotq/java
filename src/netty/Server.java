package netty;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Server {
   public static void main(String[] args) throws IOException {
	   Selector selector=Selector.open();
	   ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
	   serverSocketChannel.socket().bind(new InetSocketAddress(2222));
	   serverSocketChannel.configureBlocking(false);
	   serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
//	   serverSocketChannel.accept();
	   while(selector.select()>0){
		   Set<SelectionKey> keys=selector.selectedKeys();
		   Iterator<SelectionKey> iter=keys.iterator();
		   while(iter.hasNext()){
			   SelectionKey key=iter.next();
			   iter.remove();
			   if(key.isAcceptable()){
				   ServerSocketChannel server=(ServerSocketChannel) key.channel();
				   SocketChannel channel=server.accept();
				   channel.configureBlocking(false);
				   channel.register(selector, SelectionKey.OP_READ);
				   System.err.println("Server: connecting success");
			   }else if(key.isReadable()){
				   SocketChannel socketChannel=(SocketChannel) key.channel();
				   ByteBuffer buffer=ByteBuffer.allocate(100);
				   while(socketChannel.read(buffer)>0){
					   System.err.println(new String(buffer.array()));
				   }
				   ByteBuffer out=ByteBuffer.wrap("ok you are beautiful".getBytes());
				   socketChannel.write(out);
				   socketChannel.close();
				   System.err.println("Server : reading ....");
			   }
		   }
	   }
	   System.err.println("dfds");
   }

}
