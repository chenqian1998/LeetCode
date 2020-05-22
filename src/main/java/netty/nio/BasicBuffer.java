package netty.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.Channel;

public class BasicBuffer {
    public static  void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(5);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            // intBUffer写入数据
            intBuffer.put(i * i);
        }

        // intBuffer 切换状态
        intBuffer.flip();

        //从intBuffer中读取数据
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

    }
}
