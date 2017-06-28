package cn.zsza.designPattern.adapter;

/**
 * Created by zs on 2017/6/28.
 * 18:52
 */
public class BattleFishingBoat implements BattleShip {
    private FishingBoat boat;

    public BattleFishingBoat(){
        boat = new FishingBoat();
    }


    @Override
    public void fire() {
        System.out.println(".... fire");
    }

    @Override
    public void move() {
        boat.sail();
    }
}
