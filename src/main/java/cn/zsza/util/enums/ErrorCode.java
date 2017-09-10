package cn.zsza.util.enums;

import org.springframework.http.HttpStatus;

/**
 * 错误码定义
 * @author liushaojun
 * @create 2017/4/11
 */
public enum ErrorCode  {
    INTERNAL_SERVER_ERROR("0","服务器请求繁忙，请稍后重试",HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final String message;
    private final HttpStatus status;

    ErrorCode(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
    public String code(){
        return this.code;
    }

    public String message(){
        return this.message;
    }

    public HttpStatus status(){
        return this.status;
    }

    public String toString() {
        return this.message();
    }
}
