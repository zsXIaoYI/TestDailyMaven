package cn.zsza.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/**
 * Created by user on 2016/6/12.
 */
/**
 * Callable接口指定了泛型
 * @author user
 *
 */
class OneTask implements Callable<String>{
    private int id;
    public OneTask(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        int i = 3;
        while (i > 0){
            System.out.println("Thread  "+id + " is working, i:" +i);
            Thread.sleep(1000);
            i--;
        }
        return "result of Test2 " + id;
    }
}
public class CallableTask {
    public static void main(String[] args) {
        Callable<String> oneCallable = new OneTask(1);
        FutureTask<String> ft = new FutureTask<>(oneCallable);

        new Thread(ft).start();

        while(!ft.isDone()){
            try {
                System.out.println("检查线程执行完了吗...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        }
        System.out.println("final boolean:" + ft.isDone());
        String result = "";
        try {
            result = ft.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("线程执行完后的结果:"+result);
    }
}

