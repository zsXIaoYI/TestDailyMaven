package cn.zsza.designPattern.strategy.demo2;

/**
 * Created by zs on 2017/8/17.
 * 14:29
 */
public class Price {
    // 持有一个具体的策略对象
    private MemberStrategy strategy;


    /**
     * 构造方法,传入一个具体的策略对象
     * @param strategy
     */
    public Price(MemberStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 计算图书的价格
     * @param booksPrice 图书的原价
     * @return  打折后的价格
     */
    public double quote(double booksPrice){
        return this.strategy.calcPrice(booksPrice);
    }
}
