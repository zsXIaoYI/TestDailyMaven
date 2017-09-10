package cn.zsza.util.model.builder;

import cn.zsza.util.CustomJsonSerialize;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.MoreObjects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import static cn.zsza.util.model.builder.ResourceEntityBuilder.builder;
/**
 * Created by ZhangSong on 2017/9/10.
 * 9:26
 */
public class ResourceEntity<T> {
    @JsonProperty
    @JsonSerialize(using = CustomJsonSerialize.AnySerialize.class)
    @NotNull
    private Integer flag;


    @JsonProperty
    @NotNull
    private String msg;

    @JsonProperty
    @Valid
    private T data;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ResourceEntity<T> other = (ResourceEntity<T>) o;

        return Objects.equals(this.getFlag(), other.getFlag())
                && Objects.equals(this.getMsg(), other.getMsg())
                && Objects.equals(this.getData(), other.getData());
    }
    public int hashCode() {
        return Objects.hash(
                this.getFlag(),
                this.getData(),
                this.getMsg());
    }

    public static <T> ResourceEntity<T> ok(Integer code, String message) {
        return builder()
                .flag(code)
                .msg(message)
                .build();
    }

    public static <T> ResourceEntity<T> ok(String message) {
        return ok(1, message);
    }

    public static <T> ResourceEntity<T> ok(T body) {

        return builder()
                .flag(1)
                .data(body)
                .msg("success")
                .build();
    }

    public String toString() {
        return toStringHelper().toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("code", this.getFlag())
                .add("message", this.getMsg())
                .add("data", this.getData());
    }

    public static <T> ResourceEntity<T> error(Integer code,String message,T data){
        return builder().flag(code).msg(message).data(data).build();
    }
}
