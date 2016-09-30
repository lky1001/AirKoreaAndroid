# AirKoreaAndroid

## 공공데이터 대기 정보 가져오기

### 지원 기능
- 시도 정보
- 측정소 정보

### 사용법
```
AirKorea.init(this, 'airkorea api key');

AirKorea.getStationInfo(1, 999, new OnResponseListener<StationInfo>() {

    @Override
    public void onResult(StationInfo response) {}
    
    @Override
    public void onError(Throwable e) {}
});
```
