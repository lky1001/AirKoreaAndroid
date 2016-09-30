package com.tistory.lky1001.airkoreasdk.model.stationinfo;

import org.simpleframework.xml.Element;

/**
 * Created by lee on 2016. 8. 24..
 */
public class Item {

    @Element(required = false)
    private String stationName;
    @Element(required = false)
    private String addr;
    @Element(required = false)
    private int year;
    @Element(required = false)
    private String oper;
    @Element(required = false)
    private String photo;
    @Element(required = false)
    private String vrml;
    @Element(required = false)
    private String map;
    @Element(required = false)
    private String mangName;
    @Element(required = false)
    private String item;
    @Element(required = false)
    private double dmX;
    @Element(required = false)
    private double dmY;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getVrml() {
        return vrml;
    }

    public void setVrml(String vrml) {
        this.vrml = vrml;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getMangName() {
        return mangName;
    }

    public void setMangName(String mangName) {
        this.mangName = mangName;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getDmX() {
        return dmX;
    }

    public void setDmX(double dmX) {
        this.dmX = dmX;
    }

    public double getDmY() {
        return dmY;
    }

    public void setDmY(double dmY) {
        this.dmY = dmY;
    }
}
