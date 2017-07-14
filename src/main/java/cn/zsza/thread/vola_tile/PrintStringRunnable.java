package cn.zsza.thread.vola_tile;

/**
 * Created by zs on 2017/7/14.
 * 11:48
 */
public class PrintStringRunnable implements Runnable {
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
                System.out.println("run threadName = "
                        + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        printStringMethod();
    }

    public static void main(String[] args) {
        PrintStringRunnable printStringRunnable = new PrintStringRunnable();
        new Thread(printStringRunnable).start();

        System.out.println("我要停止它! stopThread="
                + Thread.currentThread().getName());

        printStringRunnable.setContinuePrint(false);


    }
}
