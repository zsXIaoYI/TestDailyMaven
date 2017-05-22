package cn.zsza;

/**
 *
 */
public class App {
    public static void main( String[] args ) {
        String ext = System.getProperty("java.ext.dirs");
        String classPath = System.getProperty("java.class.path");
        String[] classPaths = classPath.split(";");

        System.out.println("ext:" + ext);

        for (String path : classPaths)
            System.out.println("path:" + path);
    }
}
