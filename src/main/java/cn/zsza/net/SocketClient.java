package cn.zsza.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by zs on 2017/8/17.
 * 16:32
 */
public class SocketClient {
    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket("localhost",8888);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            dos.writeUTF("我是客户端,请求连接!");
            System.out.println(dis.readUTF());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
