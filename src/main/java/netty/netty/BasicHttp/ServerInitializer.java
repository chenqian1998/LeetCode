package netty.netty.BasicHttp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/4/27
 * @description
 */
public class ServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    /**
     * 连接创建之后，就会对连接里的数据进行初始化
      */

    protected void initChannel(SocketChannel channel) throws Exception {
        // 通过channel得到管道，一个管道上面可以
        ChannelPipeline pipeline = channel.pipeline();

        // HttpServerCodec 是Netty提供的针对Http的编码、解码器
        // 对http的数据进行解析
        pipeline.addLast("basicHttpServerCodec",new HttpServerCodec());

        // 自己定义的处理器
        pipeline.addLast("httpServerHandler",new HttpRequestHandler());


    }
}
