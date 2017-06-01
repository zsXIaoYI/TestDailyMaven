package cn.zsza;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

/**
 * Created by zs on 2017/6/1.
 * 10:54
 */
public class DESUtils {
    private static Key key;
    private static String KEY_STR = "myKey";

    static {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            generator.init(new SecureRandom(KEY_STR.getBytes()));
            key = generator.generateKey();
            generator = null;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 对字符串进行DES加密,返回BASE64编码的加密字符串
     * @param str
     * @return
     */
    public static String getEncryptString(String str){
        BASE64Encoder base64en = new BASE64Encoder();
        try {
            byte strBytes[] = str.getBytes("UTF8");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte encryptStrBytes[] = cipher.doFinal(strBytes);
            return base64en.encode(encryptStrBytes);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 对BASE64编码的加密字符串进行解密,返回解密后的字符串
     * @param str
     * @return
     */
    public static String getDecryptString(String str){
        BASE64Decoder base64De = new BASE64Decoder();
        try{
            byte strBytes[] = base64De.decodeBuffer(str);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE,key);
            byte decryptStrBytes[] = cipher.doFinal(strBytes);
            return new String(decryptStrBytes,"UTF8");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("root:" + getEncryptString("root"));

        System.out.println("....." + getDecryptString("WnplV/ietfQ="));
    }


}
