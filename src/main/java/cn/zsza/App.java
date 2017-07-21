package cn.zsza;

/**
 *
 */
public class App {
    public static void main( String[] args ) {
        /**
         * ExtClassLoader需加载的类库
         * win10 PC测试
         * ext:C:\Program Files\Java\jdk1.8.0_101\jre\lib\ext;C:\Windows\Sun\Java\lib\ext
         */
        String ext = System.getProperty("java.ext.dirs");
        /**
         * AppClassLoader需加载的类库
         */
        String classPath = System.getProperty("java.class.path");
        String[] classPaths = classPath.split(";");

        System.out.println("ext:" + ext);

        for (String path : classPaths)
            System.out.println("path:" + path);

        System.out.println("classPath:" + new App().getClassPath());
    }

    public String getClassPath(){

        return this.getClass().getClassLoader().getResource("xml/config.xml").toString();
    }
}
