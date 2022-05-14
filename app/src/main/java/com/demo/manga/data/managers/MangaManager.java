package com.demo.manga.data.managers;

import com.demo.manga.data.models.Manga;
import com.demo.manga.data.tables.MangasTable;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.queries.Query;

import java.util.List;

import rx.Observable;

/**
 * @ProjectName: Manga
 * @Package: com.demo.manga.data.managers
 * @ClassName: MangaManager
 * @Description: java类作用描述
 * @Author: Viden
 * @CreateDate: 2022/5/14 14:41
 * @UpdateUser: 更新者
 * @UpdateDate: 2022/5/14 14:41
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MangaManager extends BaseManager {
    public MangaManager(StorIOSQLite db) {
        super(db);
    }

    public Observable<List<Manga>> get() {
        return db.get()
                .listOfObjects(Manga.class)
                .withQuery(Query.builder()
                        .table(MangasTable.TABLE)
                        .build())
                .prepare()
                .createObservable();
    }
}
