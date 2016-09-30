package com.tistory.lky1001.airkoreasdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.tistory.lky1001.airkoreasdk.listener.OnResponseListener;
import com.tistory.lky1001.airkoreasdk.model.sidoairinfo.SidoAirInfo;
import com.tistory.lky1001.airkoreasdk.model.stationinfo.StationInfo;
import com.tistory.lky1001.airkoreasdk.network.AirKoreaService;
import com.tistory.lky1001.airkoreasdk.network.ServiceBuilder;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lee on 2016. 8. 14..
 */
public class AirKorea {

    private static final String AIRKOREA_API_KEY_META_ID = "airkorea.airinfo.ApiKey";
    private static final String BASE_URL = "http://openapi.airkorea.or.kr/openapi/";
    private static final String VER = "1.4";
    private static String apiKey;
    private static Context applicationContext;
    private static boolean initialized = false;

    /**
     * 대기오염정보 조회 서비스 초기화.
     * apikey는 AndroidManifest.xml에 메타데이터로 추가하는 경우 사용.
     * 메타데이터 : airkorea.airinfo.ApiKey
     *
     * @param context android context
     */
    public static void init(Context context) {
        if (initialized) {
            return;
        }

        if (context == null) {
            throw new IllegalArgumentException("context is required");
        }

        AirKorea.applicationContext = context.getApplicationContext();

        AirKorea.loadApiKeyFromMetadata(AirKorea.applicationContext);

        initialized = true;
    }

    /**
     * 대기오염정보 조회 서비스 초기화.
     *
     * @param context android context
     * @param apiKey 대기오염정보 조회 서비스 키(data.go.kr 발급)
     */
    public static void init(Context context, String apiKey) {
        if (initialized) {
            return;
        }

        if (TextUtils.isEmpty(apiKey)) {
            throw new IllegalArgumentException("apiKey is required");
        }

        if (context == null) {
            throw new IllegalArgumentException("context is required");
        }

        AirKorea.apiKey = apiKey;
        AirKorea.applicationContext = context.getApplicationContext();

        initialized = true;
    }

    static void loadApiKeyFromMetadata(Context context) {
        if (context == null) {
            return;
        }

        ApplicationInfo ai = null;
        try {
            ai = context.getPackageManager().getApplicationInfo(
                    context.getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            return;
        }

        if (ai == null || ai.metaData == null) {
            return;
        }

        if (TextUtils.isEmpty(apiKey)) {
            Object apiKey = ai.metaData.get(AIRKOREA_API_KEY_META_ID);
            if (apiKey instanceof String) {
                AirKorea.apiKey = (String) apiKey;
            } else {
                throw new IllegalArgumentException("Airkorea api key is invalid.");
            }
        }
    }

    /**
     * 시도별 대기오염정보 가져오기.
     *
     * @param sidoName 시도 이름
     * @param page 페이지 번호
     * @param limit 페이지당 갯수
     * @param listener 결과 응답 리스너. 응답 객체 {@link SidoAirInfo}
     */
    public static void getSidoInfo(String sidoName, int page, int limit,
            final OnResponseListener listener) {
        if (!initialized) {
            throw new IllegalStateException("Must call AirKorea.init()");
        }

        AirKoreaService service = ServiceBuilder.createService(AirKoreaService.class,
                BASE_URL, applicationContext);

        service.getSidoAirInfo(sidoName, String.valueOf(page), String.valueOf(limit), AirKorea.apiKey, VER)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SidoAirInfo>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if (listener != null) {
                            listener.onError(e);
                        }
                    }

                    @Override
                    public void onNext(SidoAirInfo sidoAirInfo) {
                        if (listener != null) {
                            listener.onResult(sidoAirInfo);
                        }
                    }
                });
    }

    public static void getStationInfo(int page, int limit, final OnResponseListener listener) {
        if (!initialized) {
            throw new IllegalStateException("Must call AirKorea.init()");
        }

        AirKoreaService service = ServiceBuilder.createService(AirKoreaService.class,
                BASE_URL, applicationContext);

        service.getStationInfo(AirKorea.apiKey, String.valueOf(limit), String.valueOf(page))
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<StationInfo>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                if (listener != null) {
                    listener.onError(e);
                }
            }

            @Override
            public void onNext(StationInfo stationInfo) {
                if (listener != null) {
                    listener.onResult(stationInfo);
                }
            }
        });
    }
}
