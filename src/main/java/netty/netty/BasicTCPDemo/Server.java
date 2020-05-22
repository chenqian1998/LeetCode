package netty.netty.BasicTCPDemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author Itsuka
 * @version 1.0
 * @date 2020/4/26
 * @description
 */
public class Server {
    public static void main(String[] args) throws InterruptedException {
        //创建BossGroup 和 WorkerGroup
        //说明
        //1. 创建两个线程组 bossGroup 和 workerGroup
        //2. bossGroup 只是处理连接请求 , 真正的和客户端业务处理，会交给 workerGroup完成
        //3. 两个都是无限循环
        //4. bossGroup 和 workerGroup 含有的子线程(NioEventLoop)的个数
        //   默认实际 cpu核数 * 2
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        // Server 启动对象
        //创建服务器端的启动对象，配置参数
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        //设置两个线程组
        serverBootstrap.group(bossGroup, workerGroup)
                //使用NioSocketChannel 作为服务器的通道实现
                .channel(NioServerSocketChannel.class)
                // 设置线程队列得到连接个数
                .option(ChannelOption.SO_BACKLOG, 128)
                //设置保持活动连接状态
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                //
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ServerHandler());
                    }
                });
        System.out.println("服务器已就绪。。。。。。");

        //绑定一个端口并且同步, 生成了一个 ChannelFuture 对象
        //启动服务器(并绑定端口)
        ChannelFuture cf = serverBootstrap.bind(6666).sync();

        cf.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (cf.isSuccess()){
                    System.out.println("监听端口成功");
                }else{
                    System.out.println("监听端口失败");
                }
            }
        });
        if (cf.isSuccess()){
            System.out.println("监听端口成功");
        }

        cf.channel().closeFuture().sync();
    }
}
