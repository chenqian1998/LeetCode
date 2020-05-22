package netty.netty.BasicTCPDemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/4/27
 * @description
 */


/**
说明
1. 我们自定义一个Handler 需要继续netty 规定好的某个HandlerAdapter(规范)
2. 这时我们自定义一个Handler , 才能称为一个handler
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        /**
         * 如果是下面这个很耗时的工作 ==》其实还是阻塞在这个
        Thread.sleep(10*1000);
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, cost 10s",CharsetUtil.UTF_8));
        */
        // 提交到taskQueue中
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello, cost 10s",CharsetUtil.UTF_8));
            }
        });

        // 把任务交给延迟处理的 taskQueue
        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ctx.writeAndFlush(Unpooled.copiedBuffer("hello, cost 10s",CharsetUtil.UTF_8));
            }
        },5, TimeUnit.SECONDS);



        System.out.println("server ctx:" + ctx);
        ByteBuf buf = (ByteBuf)msg;
        System.out.println("server receive : " + buf.toString(CharsetUtil.UTF_8));
        Channel channel = ctx.channel();
        ChannelPipeline pipeline = ctx.pipeline();
        System.out.println("client address : "+ channel.remoteAddress());
        System.out.println("channel"+channel);
        System.out.println("pipeline"+pipeline);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //writeAndFlush 是 write + flush
        //将数据写入到缓存，并刷新
        //一般讲，我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("server receive end ...",CharsetUtil.UTF_8));
    }

    //处理异常, 一般是需要关闭通道

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
