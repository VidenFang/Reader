package com.demo.manga.presenter;

import com.demo.manga.App;
import com.demo.manga.AppComponent;
import com.demo.manga.data.models.Manga;
import com.demo.manga.view.ILibraryView;

import java.util.ArrayList;

/**
 * @ProjectName: Manga
 * @Package: com.demo.manga.presenter
 * @ClassName: LibraryPresenter
 * @Description: java类作用描述
 * @Author: Viden
 * @CreateDate: 2021/8/29 15:42
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/8/29 15:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LibraryPresenter {

    private final ILibraryView mLibraryView;

//    @Inject
//    public DatabaseHelper db;

    public LibraryPresenter(ILibraryView libraryView) {
        this.mLibraryView = libraryView;
        AppComponent appComponent = App.get(mLibraryView.getContext()).getAppComponent();
        appComponent.inject(this);
    }

    public void initLibMangaDatas() {
        ArrayList<Manga> mangaList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mangaList.add(new Manga("One Piece"));
            mangaList.add(new Manga("Berserk"));
            mangaList.add(new Manga("Fate/stay night: Unlimited Blade Works"));
            mangaList.add(new Manga("God Only Knows"));
        }
        mLibraryView.showLibMangas(mangaList);
//        db.mangaManager.get()
//                .observeOn(mainThread())
//                .subscribe(mangas -> {
//                    ArrayList<Manga> mangaList = new ArrayList<>(mangas);
//                    mLibraryView.showLibMangas(mangaList);
//                    mangaList.add(new Manga("One Piece"));
//                    mangaList.add(new Manga("Berserk"));
//                    mangaList.add(new Manga("Fate/stay night: Unlimited Blade Works"));
//                    mangaList.add(new Manga("God Only Knows"));
//                });
    }
}
