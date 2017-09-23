package cn.zsza.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Created by user on 2016/3/6.
 * 字节流:复制图片
 */
public class CopyPic {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        /**
         * 关于输入输出流，1.JPG要把自己的流对象输入给程序，所以用输入流
         *     而程序要把上述的输入流给copy.JPG，所以要用输出流
         */
        try {
            fis = new FileInputStream("file\\1.JPG");         //访问1.jpg
            fos = new FileOutputStream("file\\copy.JPG");
            byte buf[] = new byte[1024];
            int num;
            while((num=fis.read(buf))!=-1){
                fos.write(buf, 0, num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fis!=null)
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException("关闭失败");
                }
            if(fos!=null)
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException("关闭失败");
                }
        }
    }

}

