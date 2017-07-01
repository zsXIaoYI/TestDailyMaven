package cn.zsza.ioc.demo2;

import cn.zsza.ioc.demo1.Geli;

/**
 * 通过实现一个接口进行注入
 * Created by ZhangSong on 2017/7/1.
 * 10:52
 */
public class MoAttack implements ActorArrangeable {

    private Geli geli;

    @Override
    public void injectGeli(Geli geli) {
        this.geli = geli;
    }

    public void cityGateAsk(){
        geli.responseAsk("墨者隔离");
    }

}
