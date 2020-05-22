package netty.netty.BasicHttp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/4/27
 * @description 差不多是Netty的最后一个项目了，是一个关于http相关的
 * （1）浏览器输入localhost:6666
 * （2）服务器，返回消息给客户端，"server 收到消息",并且可以对特定请求资源进行过滤
 */

public class Server {
    public static void main(String[] args) {

        // 这里定义了两个线程组
        // bossGroup接受连接请求，但是不会进行处理，会把连接发送个workerGroup去处理
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        // Server 启动对象
        try {
            // 服务器端启动
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // 由boosGroup接受请求，交给workerGroup处理
            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    // childHandler加入初始化器
                    // netty基本上流程都是固定这么写的，也就是在childHandler里面定义好处理的逻辑
                    .childHandler(new ServerInitializer());


            ChannelFuture channelFuture = serverBootstrap.bind(28081).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
