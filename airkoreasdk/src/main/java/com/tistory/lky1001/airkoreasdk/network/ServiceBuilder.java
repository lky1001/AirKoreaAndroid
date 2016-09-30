package com.tistory.lky1001.airkoreasdk.network;

import android.content.Context;

import java.io.File;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by lee on 2016. 8. 19..
 */
public class ServiceBuilder {

    /** 캐시 50메가 **/
    private static final int DISK_CACHE_SIZE = 50 * 1024 * 1024;

    private static Retrofit.Builder RETROFIT_BUILDER = new Retrofit.Builder();

    // No need to instantiate this class.
    private ServiceBuilder() {}

    public static <T> T createService(Class<T> serviceClass, String baseUrl, Context context) {
        OkHttpClient okHttpClient = getClient(context);

        RETROFIT_BUILDER.client(okHttpClient);
        RETROFIT_BUILDER.baseUrl(baseUrl);
        RETROFIT_BUILDER.addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        RETROFIT_BUILDER.addConverterFactory(SimpleXmlConverterFactory.create());

        Retrofit retrofit = RETROFIT_BUILDER.build();
        return retrofit.create(serviceClass);
    }

    private static OkHttpClient getClient(Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.writeTimeout(10, TimeUnit.SECONDS);

        // Install an HTTP cache in the application cache directory.
        try {
            File cacheDir = new File(context.getCacheDir(), "http");
            Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
            builder.cache(cache);
        } catch (Exception e) {
            e.printStackTrace();
        }
        builder.sslSocketFactory(createBadSslSocketFactory());
        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });

        OkHttpClient client = builder.build();

        return client;
    }

    private static SSLSocketFactory createBadSslSocketFactory() {
        try {
            // Construct SSLSocketFactory that accepts any cert.
            SSLContext context = SSLContext.getInstance("TLS");
            TrustManager permissive = new X509TrustManager() {

                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType)
                        throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType)
                        throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            };
            context.init(null, new TrustManager[]{permissive}, null);
            return context.getSocketFactory();
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}
