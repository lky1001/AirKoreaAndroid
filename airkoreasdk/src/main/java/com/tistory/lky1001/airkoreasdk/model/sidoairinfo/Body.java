package com.tistory.lky1001.airkoreasdk.model.sidoairinfo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * Created by lee on 2016. 8. 19..
 */
public class Body {

    @ElementList(required = false)
    private List<Item> items;
    @Element(required = false)
    private int numOfRows;
    @Element(required = false)
    private int pageNo;
    @Element(required = false)
    private int totalCount;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
