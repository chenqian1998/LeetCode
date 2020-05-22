package netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {
    public static void main(String[] args) throws IOException {
        /**
         * 思考下BIO的工作过程
         */
        ExecutorService threadPool = Executors.newCachedThreadPool();

        // 创建Server
        ServerSocket serverSocket = new ServerSocket(6666);

        System.out.println("服务器启动");

        while (true){
            // 监听,等待执行
            Socket socket = serverSocket.accept();
            System.out.println("有一个客户端链接！");

            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    handler(socket);
                }
            });


        }
    }

    public static void handler(Socket socket){
        try {
            System.out.println("线程Name："+Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            // 通过socket获取输入流
            InputStream inputStream = socket.getInputStream();

            // 循环读取客户端发送的数据
            while (true){
                int read = inputStream.read(bytes);
                if (read!=-1){
                    System.out.println(new String(bytes,0,read));
                }else {
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            System.out.println("关闭socket");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
