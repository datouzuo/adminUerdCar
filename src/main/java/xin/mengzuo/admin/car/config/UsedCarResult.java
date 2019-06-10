package xin.mengzuo.admin.car.config;

import java.io.Serializable;

public class UsedCarResult implements Serializable{

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static UsedCarResult build(Integer status, String msg, Object data) {
        return new UsedCarResult(status, msg, data);
    }

    public static UsedCarResult ok(Object data) {
        return new UsedCarResult(data);
    }

    public static UsedCarResult ok() {
       
    	return new UsedCarResult(null);
    }

    public UsedCarResult() {

    }

    public static UsedCarResult build(Integer status, String msg) {
        return new UsedCarResult(status, msg, null);
    }

    public UsedCarResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public UsedCarResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

//    public Boolean isOK() {
//        return this.status == 200;
//    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
