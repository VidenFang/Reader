package com.demo.manga.data;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;


/**
 * @ProjectName: Manga
 * @Package: com.demo.manga.data
 * @ClassName: DataModule
 * @Description: java类作用描述
 * @Author: Viden
 * @CreateDate: 2022/5/14 15:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2022/5/14 15:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Module
public class DataModule {

    @Provides
    @Singleton
    Scheduler provideSubscribeScheduler() {
        return Schedulers.io();
    }
}
