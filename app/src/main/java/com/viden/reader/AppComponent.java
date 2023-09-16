package com.viden.reader;

import com.viden.reader.data.DataModule;
import com.viden.reader.presenter.LibraryPresenter;
import com.viden.reader.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @ProjectName: Manga
 * @Package: com.viden.reader
 * @ClassName: AppComponent
 * @Description: java类作用描述
 * @Author: Viden
 * @CreateDate: 2021/9/6 13:55
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/9/6 13:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

@Singleton
@Component(
        modules = {
                AppModule.class,
                DataModule.class
        }
)
public interface AppComponent {

    void inject(MainActivity mainActivity);

    void inject(LibraryPresenter libraryPresenter);
}
