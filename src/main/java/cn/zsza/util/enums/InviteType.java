package cn.zsza.util.enums;

/**
 * @author shanchong
 * @create 2017/7/13
 */
public enum InviteType {


    INVITE("1", "邀请"),
    INVITED("2","被邀请");
    private String val;
    private String name;

    InviteType(String val, String name) {
        this.val = val;
        this.name = name;
    }

    public String value() {
        return this.val;
    }


    @Override
    public String toString() {
        return this.name;
    }
}