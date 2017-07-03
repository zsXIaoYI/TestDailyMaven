package cn.zsza.ioc;

import cn.zsza.ioc.demo1.Geli;
import cn.zsza.ioc.demo1.LiuDeHua;
import cn.zsza.ioc.demo1.MoAttack;
import org.junit.Test;

/**
 * Created by ZhangSong on 2017/7/1.
 * 10:45
 */
public class Director {
    @Test
    public void director(){
        Geli geli = new LiuDeHua();

        MoAttack moAttack  = new MoAttack(geli);

        moAttack.cityGateAsk();
    }
}
