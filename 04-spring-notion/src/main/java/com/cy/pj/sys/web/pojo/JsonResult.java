package com.cy.pj.sys.web.pojo;

public class JsonResult {
    /**
     * 状态码
     **/
    private Integer state = 1;
    /**
     * 状态码信息
     */
    private String message = "ok";
    /**
     * 封装正确的结果
     */
    private Object data;

    public JsonResult() {
    }

    public JsonResult(String message) {
        this.message = message;
    }

    public JsonResult(Integer state, String message) {
//        this.message = message;
        this(message);
        this.state = state;
    }

    public JsonResult(Object data) {
        this.data = data;
    }
    //发生异常
    public JsonResult(Throwable exception) {
//        this.state = 0;
//        this.message = exception.getMessage();
        this(0,exception.getMessage());
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
