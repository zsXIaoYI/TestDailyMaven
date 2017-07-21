package cn.zsza.designPattern.prototype;

import lombok.Data;

/**
 * Created by zs on 2017/7/20.
 * 17:52
 */
@Data
public abstract class Shape implements Cloneable {
    private String id;
    protected String type;

    abstract void draw();

    @Override
    public Object clone()  {
        Object clone = null;

        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
