package cn.zsza.xml;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zs on 2017/5/15.
 * 17:00
 */
public class XMLTest {
    public static void main(String[] args) throws JDOMException, IOException {
        SAXBuilder build = new SAXBuilder();
        InputStream in = XMLTest.class.getClassLoader().getResourceAsStream("xml/config.xml");
        Document doc = build.build(in);
        Element root = doc.getRootElement();
        String chartType = root.getChildText("chartType");

        System.out.println("chartType="+chartType);
    }
}
