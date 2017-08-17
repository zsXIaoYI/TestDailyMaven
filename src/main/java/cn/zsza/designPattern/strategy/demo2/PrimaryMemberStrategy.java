package cn.zsza.designPattern.strategy.demo2;

/**
 * Created by zs on 2017/8/17.
 * 14:25
 */
public class PrimaryMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("初级会员没有折扣...");
        return booksPrice;
    }
}
