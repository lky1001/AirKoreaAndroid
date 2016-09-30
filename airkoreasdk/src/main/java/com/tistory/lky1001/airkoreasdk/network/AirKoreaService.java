package com.tistory.lky1001.airkoreasdk.network;

import com.tistory.lky1001.airkoreasdk.model.sidoairinfo.SidoAirInfo;
import com.tistory.lky1001.airkoreasdk.model.stationinfo.StationInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lee on 2016. 8. 19..
 */
public interface AirKoreaService {

    @GET("services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty")
    Observable<SidoAirInfo> getSidoAirInfo(@Query("sidoName") String sidoName,
        @Query("pageNo") String pageNo, @Query("numOfRows") String numOfRows,
        @Query("ServiceKey") String serviceKey, @Query("ver") String ver);

    @GET("services/rest/MsrstnInfoInqireSvc/getMsrstnList")
    Observable<StationInfo> getStationInfo(@Query("ServiceKey") String serviceKey,
        @Query("pageNo") String pageNo, @Query("pageSize") String pageSize);
}