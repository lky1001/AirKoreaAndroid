package com.tistory.lky1001.airkoreasdk.model;

import org.simpleframework.xml.Element;

/**
 * Created by lee on 2016. 8. 19..
 */
public class Header {

    @Element(required = false)
    private String resultCode;
    @Element(required = false)
    private String resultMsg;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
