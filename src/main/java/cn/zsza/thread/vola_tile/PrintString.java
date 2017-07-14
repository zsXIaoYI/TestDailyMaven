package cn.zsza.thread.vola_tile;

/**
 * Created by zs on 2017/7/14.
 * 11:29
 */
public class PrintString {
    private boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean isContinuePrint) {
        this.isContinuePrint = isContinuePrint;
    }

    public void printStringMethod(){
        try {
            while (isContinuePrint == true){
                System.out.println("run printStringMethod threadName = "
                        + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * 单线程
     * 程序一直停不下来,主要原因是main线程一直在处理while()循环
     * @param args
     */

    public static void main(String[] args) {
        PrintString printStringService = new PrintString();
        printStringService.printStringMethod();

        System.out.println("我要停止它! stopThread=" + Thread.currentThread().getName());
        printStringService.setContinuePrint(false);
    }
}
