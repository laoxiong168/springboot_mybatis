package com.system;

import lombok.Data;

@Data
public class RespData {
    private String respCode;
    private String msg;
    private Object respData;

    public static RespData getSuccessResp() {
        RespData resp = new RespData();
        resp.setRespCode("1");
        resp.setMsg("成功");
        resp.setRespData(null);
        return resp;
    }
    public static RespData getFailResp() {
        RespData resp = new RespData();
        resp.setRespCode("-1");
        resp.setMsg("失败");
        resp.setRespData(null);
        return resp;
    }
    public static RespData getSuccessResp(Object respData) {
        RespData resp = new RespData();
        resp.setRespCode("1");
        resp.setMsg("成功");
        resp.setRespData(respData);
        return resp;
    }
}
