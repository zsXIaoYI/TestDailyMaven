package cn.zsza.ioc.demo1;

/**
 * Created by ZhangSong on 2017/7/1.
 * 10:42
 */
public class MoAttack {             // 墨攻
    private Geli geli;

    /**
     * 1、构造器方法注入
     * MoAttack的构造方法不关心具体是由谁来饰演隔离这个角色
     * @param geli
     */
    public MoAttack(Geli geli) {
        this.geli = geli;
    }

    public void cityGateAsk(){
        geli.responseAsk("墨者隔离");
    }

    /**
     * 2、通过setter方法注入
     * @param geli
     */
    public void setGeli(Geli geli) {
        this.geli = geli;
    }
}
