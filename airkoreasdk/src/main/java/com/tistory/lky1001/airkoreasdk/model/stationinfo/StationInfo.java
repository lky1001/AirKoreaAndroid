package com.tistory.lky1001.airkoreasdk.model.stationinfo;

import com.tistory.lky1001.airkoreasdk.model.Header;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by lee on 2016. 8. 24..
 */
@Root(name = "response")
public class StationInfo {

    @Element(name = "header", required = false)
    private Header header;

    @Element(name = "body", required = false)
    private Body body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
