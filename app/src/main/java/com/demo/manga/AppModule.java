package com.demo.manga;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @ProjectName: Manga
 * @Package: com.demo.manga
 * @ClassName: AppModule
 * @Description: 提供single Application
 * @Author: Viden
 * @CreateDate: 2021/9/6 13:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/9/6 13:51
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Module
public class AppModule {
    protected final Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return mApplication;
    }
}
