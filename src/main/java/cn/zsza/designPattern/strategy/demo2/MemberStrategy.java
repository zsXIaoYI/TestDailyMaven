package cn.zsza.designPattern.strategy.demo2;

/**
 * Created by zs on 2017/8/17.
 * 14:23
 * 针对购书网站不同的会员，抽象一个对应的价格策略接口
 */
public interface MemberStrategy {

    /**
     *
     * @param booksPrice  图书的原价
     * @return            打折后的价格
     */
    public double calcPrice(double booksPrice);

}
