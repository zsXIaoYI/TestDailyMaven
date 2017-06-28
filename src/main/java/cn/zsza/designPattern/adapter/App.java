package cn.zsza.designPattern.adapter;

/**
 * Created by zs on 2017/6/28.
 * 18:55
 */
public class App {
    public static void main(String[] args) {
        Captain captain = new Captain(new BattleFishingBoat());
        captain.move();
        captain.fire();
    }
}
