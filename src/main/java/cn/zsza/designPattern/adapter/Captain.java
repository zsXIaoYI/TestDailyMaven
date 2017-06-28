package cn.zsza.designPattern.adapter;

/**
 * Created by zs on 2017/6/28.
 * 18:50
 */
public class Captain implements BattleShip {

    private BattleShip battleShip;

    public Captain() {
    }

    public Captain(BattleShip battleShip) {
        this.battleShip = battleShip;
    }

    public void setBattleShip(BattleShip battleShip) {
        this.battleShip = battleShip;
    }


    @Override
    public void fire() {
        battleShip.fire();
    }

    @Override
    public void move() {
        battleShip.move();
    }
}
