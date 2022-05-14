package com.demo.manga.data;

import android.app.Application;

import com.demo.manga.data.helpers.DatabaseHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.schedulers.Schedulers;

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
    DatabaseHelper provideDatabaseHelper(Application app) {
        return new DatabaseHelper(app);
    }

    @Provides
    @Singleton
    Scheduler provideSubscribeScheduler() {
        return Schedulers.io();
    }
}
