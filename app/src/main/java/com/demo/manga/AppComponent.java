package com.demo.manga;

import com.demo.manga.data.DataModule;
import com.demo.manga.presenter.LibraryPresenter;
import com.demo.manga.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @ProjectName: Manga
 * @Package: com.demo.manga
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
