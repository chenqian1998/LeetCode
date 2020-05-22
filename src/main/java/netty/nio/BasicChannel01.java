package netty.nio;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BasicChannel01 {
    public static void main(String[] args) throws IOException {
        //channelWriteFIle();

        //channelReadFile();

    }

    private static void channelReadFile() throws IOException {
        File file = new File("./cq.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate((int) file.length());

        // 将数据读入到buffer
        channel.read(buffer);

        System.out.println(new String(buffer.array()));
        fileInputStream.close();
    }

    private static void channelWriteFIle() throws IOException {
        String str = "cq";
        // 创建一个输出流
        FileOutputStream fileOutputStream = new FileOutputStream("./cq.txt");

        //通过fileoutputStream获取对应的channel
        // channel的真实类型是fileChannelImpl
        FileChannel channel = fileOutputStream.getChannel();

        // 创建一个缓冲区来存储数据
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //写入数据到缓冲区
        buffer.put(str.getBytes());

        //
        buffer.flip();

        // 管道来写
        channel.write(buffer);

        fileOutputStream.close();
    }
}
