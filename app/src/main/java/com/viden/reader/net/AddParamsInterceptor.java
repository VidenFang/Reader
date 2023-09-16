package com.viden.reader.net;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AddParamsInterceptor implements Interceptor {
    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";
    //创建map集合，将添加的公共参数保存到map中
    private final Map<String, String> mUrlParamsMap = new HashMap<>();
    /*//创建map集合，保存添加到请求头的公共参数,添加公共请求头也一样
    private Map<String,String> mHeaderParamsMap=new HashMap<>();*/

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        if (mUrlParamsMap.size() <= 0) {
            return chain.proceed(chain.request());
        }

        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();
        HttpUrl.Builder urlBuilder = request.url().newBuilder();
        if (METHOD_GET.equals(request.method())) { // GET方法
            // 这里可以添加一些公共get参数
            for (Map.Entry<String, String> entry : mUrlParamsMap.entrySet()) {
                urlBuilder.addEncodedQueryParameter(entry.getKey(), entry.getValue());
            }
            HttpUrl httpUrl = urlBuilder.build();

            // 打印所有get参数
            Set<String> paramKeys = httpUrl.queryParameterNames();
            for (String key : paramKeys) {
                String value = httpUrl.queryParameter(key);
//                mLogger.d(key + "-" + value);
            }
            // 将最终的url填充到request中
            requestBuilder.url(httpUrl);
        } else if (METHOD_POST.equals(request.method())) { // POST方法
            // FormBody和url不太一样，若需添加公共参数，需要新建一个构造器
            FormBody.Builder bodyBuilder = new FormBody.Builder();
            // 把已有的post参数添加到新的构造器
            if (request.body() instanceof FormBody) {
                FormBody formBody = (FormBody) request.body();
                for (int i = 0; i < formBody.size(); i++) {
                    bodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i));
                }
            }
            // 这里可以添加一些公共post参数
            for (Map.Entry<String, String> entry : mUrlParamsMap.entrySet()) {
                bodyBuilder.addEncoded(entry.getKey(), entry.getValue());
            }
            FormBody newBody = bodyBuilder.build();

            // 打印所有post参数
//            for (int i = 0; i < newBody.size(); i++) {
//                mLogger.d(newBody.name(i) + "-" + newBody.value(i));
//            }
            // 将最终的表单body填充到request中
            requestBuilder.post(newBody);
        }

        Request newRequest = requestBuilder.build();
        return chain.proceed(newRequest);
    }

    /**
     * 创建一个静态类，用于添加公共参数到map集合缓存
     */
    public static class Builder {
        //创建拦截器对象，得到Map存储添加进来的公共参数
        AddParamsInterceptor addParamsInterceptor;

        public Builder() {//构造方法中初始话拦截器
            addParamsInterceptor = new AddParamsInterceptor();
        }

        /**
         * 将公共参数添加到map集合
         *
         * @param key
         * @param value
         * @return
         */
        public Builder addUrlParams(String key, String value) {
            addParamsInterceptor.mUrlParamsMap.put(key, value);
            return this;
        }

        public Builder addUrlParams(String key, double value) {
            return addUrlParams(key, String.valueOf(value));
        }

        public Builder addUrlParams(String key, int value) {
            return addUrlParams(key, String.valueOf(value));
        }

        public Builder addUrlParams(String key, long value) {
            return addUrlParams(key, String.valueOf(value));
        }

        public Builder addUrlParams(String key, float value) {
            return addUrlParams(key, String.valueOf(value));
        }

        /**
         * 返回建立拦截器
         *
         * @return
         */
        public AddParamsInterceptor build() {
            return addParamsInterceptor;
        }

    }
}