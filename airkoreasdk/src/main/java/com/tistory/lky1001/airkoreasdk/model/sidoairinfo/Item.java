package com.tistory.lky1001.airkoreasdk.model.sidoairinfo;

import org.simpleframework.xml.Element;

/**
 * Created by lee on 2016. 8. 19..
 */
public class Item {

    @Element(required = false)
    private String stationName;
    @Element(required = false)
    private String dataTime;
    @Element(required = false)
    private String so2Value;
    @Element(required = false)
    private String coValue;
    @Element(required = false)
    private String o3Value;
    @Element(required = false)
    private String no2Value;
    @Element(required = false)
    private String pm10Value;
    @Element(required = false)
    private String khaiValue;
    @Element(required = false)
    private String khaiGrade;
    @Element(required = false)
    private String so2Grade;
    @Element(required = false)
    private String coGrade;
    @Element(required = false)
    private String o3Grade;
    @Element(required = false)
    private String no2Grade;
    @Element(required = false)
    private String pm10Grade;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getSo2Value() {
        return so2Value;
    }

    public void setSo2Value(String so2Value) {
        this.so2Value = so2Value;
    }

    public String getCoValue() {
        return coValue;
    }

    public void setCoValue(String coValue) {
        this.coValue = coValue;
    }

    public String getO3Value() {
        return o3Value;
    }

    public void setO3Value(String o3Value) {
        this.o3Value = o3Value;
    }

    public String getNo2Value() {
        return no2Value;
    }

    public void setNo2Value(String no2Value) {
        this.no2Value = no2Value;
    }

    public String getPm10Value() {
        return pm10Value;
    }

    public void setPm10Value(String pm10Value) {
        this.pm10Value = pm10Value;
    }

    public String getKhaiValue() {
        return khaiValue;
    }

    public void setKhaiValue(String khaiValue) {
        this.khaiValue = khaiValue;
    }

    public String getKhaiGrade() {
        return khaiGrade;
    }

    public void setKhaiGrade(String khaiGrade) {
        this.khaiGrade = khaiGrade;
    }

    public String getSo2Grade() {
        return so2Grade;
    }

    public void setSo2Grade(String so2Grade) {
        this.so2Grade = so2Grade;
    }

    public String getCoGrade() {
        return coGrade;
    }

    public void setCoGrade(String coGrade) {
        this.coGrade = coGrade;
    }

    public String getO3Grade() {
        return o3Grade;
    }

    public void setO3Grade(String o3Grade) {
        this.o3Grade = o3Grade;
    }

    public String getNo2Grade() {
        return no2Grade;
    }

    public void setNo2Grade(String no2Grade) {
        this.no2Grade = no2Grade;
    }

    public String getPm10Grade() {
        return pm10Grade;
    }

    public void setPm10Grade(String pm10Grade) {
        this.pm10Grade = pm10Grade;
    }
}
