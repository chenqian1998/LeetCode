package netty.netty.BasicHttp;

import com.sun.jndi.toolkit.url.Uri;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/4/27
 * @description 自己定义的处理器
 */
public class HttpRequestHandler extends SimpleChannelInboundHandler<HttpObject> {

    /**
     * 有read事件发生的时候，会触发这个方法
     * @param ctx
     * @param httpObject
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject httpObject) throws Exception {
//        System.out.println("对应的channel=" + ctx.channel() + " pipeline=" + ctx
//                .pipeline() + " 通过pipeline获取channel" + ctx.pipeline().channel());
//
//        System.out.println("当前ctx的handler=" + ctx.handler());


        if (httpObject instanceof HttpRequest){
            System.out.println("msg 类型 ： " + httpObject.getClass());
            System.out.println("客户端地址: " + ctx.channel().remoteAddress());

            // 回复信息给浏览器 HttpRequest
            // 1、 server返回的数据先存放在content
            ByteBuf content = Unpooled.copiedBuffer("Hello World", CharsetUtil.UTF_8);

            URI uri = new URI(((HttpRequest) httpObject).uri());
            if ("/favicon.ico".equals(uri.getPath())){
                return;
            }

            // 2、 构造一个默认的response
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LANGUAGE, content.readableBytes());

            // 3 将数据返回给客户端
            ctx.writeAndFlush(response);
            System.out.println(response);
            System.out.println("==============");

            ChannelFuture close = ctx.channel().close();

        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel active");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel inactive");
        super.channelInactive(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel register");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel unregister");
        super.channelUnregistered(ctx);
    }





}
