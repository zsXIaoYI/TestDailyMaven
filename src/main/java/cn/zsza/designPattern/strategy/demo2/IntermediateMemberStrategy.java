package cn.zsza.designPattern.strategy.demo2;

/**
 * Created by zs on 2017/8/17.
 * 14:25
 */
public class IntermediateMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("中级会员打9折...");
        return booksPrice * 0.9;
    }
}
