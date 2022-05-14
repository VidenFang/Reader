package com.demo.manga;

import android.app.Application;
import android.content.Context;

import timber.log.Timber;

/**
 * @ProjectName: Manga
 * @Package: com.demo.manga
 * @ClassName: App
 * @Description: java类作用描述
 * @Author: Viden
 * @CreateDate: 2021/8/28 14:01
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/8/28 14:01
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class App extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
