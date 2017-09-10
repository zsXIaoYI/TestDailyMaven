package cn.zsza.util.model.builder;

import cn.zsza.util.enums.ErrorCode;
import cn.zsza.zs_base.entity.JMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangSong on 2017/9/10.
 * 9:34
 */
public class ResourceEntityBuilder<T> {

    private Integer flag;

    private String msg;

    private T data;

    public ResourceEntityBuilder() {
    }

    public ResourceEntity<T> build(){
        ResourceEntity<T> result = new ResourceEntity<>();
        result.setFlag(this.flag);
        result.setData(this.data);
        result.setMsg(this.msg);
        return result;
    }

    public ResourceEntityBuilder<T> msg(String msg){
        this.msg = msg;
        return this;
    }

    public ResourceEntityBuilder<T> flag(Integer flag){
        this.flag = flag;
        return this;
    }
    public ResourceEntityBuilder<T> data(T data) {
        this.data = data;
        return this;
    }

    public static <T> ResourceEntity<T> responseSuccess(String message){
        return new ResourceEntityBuilder<T>().flag(1).msg(message).build();
    }

    public static <T> ResourceEntityBuilder builder() {
        return new ResourceEntityBuilder<T>();
    }

    public static <T> ResourceEntity<T> fail(){
        return fail(ErrorCode.INTERNAL_SERVER_ERROR.message());
    }

    public static <T> ResourceEntity<T> fail(String message) {
        return fail(message,Integer.valueOf(ErrorCode.INTERNAL_SERVER_ERROR.code()));
    }

    public static <T> ResourceEntity<T> fail(String message, Integer flag) {
        return builder()
                .flag(flag)
                .msg(message)
                .build();
    }

    public static <T> ResourceEntity<T> reponseFail(String message) {
        return new ResourceEntityBuilder<T>().flag(0)
                .msg(message).build();
    }

    public static void main(String[] args) {
        System.out.println(ErrorCode.INTERNAL_SERVER_ERROR.message());
        System.out.println(ErrorCode.INTERNAL_SERVER_ERROR.code());
        System.out.println(ErrorCode.INTERNAL_SERVER_ERROR.status());

        JMapper jm1 = new JMapper();
        jm1.setId(11);
        jm1.setName("小黑");

        JMapper jm2 = new JMapper();
        jm2.setId(12);
        jm2.setName("小白");

        List<JMapper> list = new ArrayList<>();
        list.add(jm1);
        list.add(jm2);

        ResourceEntity<Object> result = new ResourceEntityBuilder<>().msg("success").flag(1).data(list).build();
        System.out.println(result);
    }


}
