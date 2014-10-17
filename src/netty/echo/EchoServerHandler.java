package netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * Handles a server-side channel.
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter { // (1)

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        // Discard the received data silently.
    	ByteBuf in=(ByteBuf) msg;
    	System.out.println(in.toString(CharsetUtil.US_ASCII));
        final ByteBuf time = ctx.alloc().buffer(4); // (2)
        time.writeInt(97);

    	ChannelFuture channelFuture=ctx.writeAndFlush(time);
//    	channelFuture.addListener(ChannelFutureListener.CLOSE);
    	ctx.close();
    	
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}