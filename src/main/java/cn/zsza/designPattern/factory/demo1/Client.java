package cn.zsza.designPattern.factory.demo1;

import org.jdom.input.SAXBuilder;

/**
 * Created by zs on 2017/5/15.
 * 16:39
 */
public class Client {

    public static void main(String[] args) {
        Product product = ProductFactory.getProInstance("A");
        product.methodSame();
        product.methodDiff();

        SAXBuilder builder = new SAXBuilder();

    }
}
