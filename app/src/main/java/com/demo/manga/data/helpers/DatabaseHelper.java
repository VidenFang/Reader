package com.demo.manga.data.helpers;

import android.content.Context;

import com.demo.manga.data.managers.MangaManager;
import com.demo.manga.data.models.Manga;
import com.demo.manga.data.models.MangaStorIOSQLiteDeleteResolver;
import com.demo.manga.data.models.MangaStorIOSQLiteGetResolver;
import com.demo.manga.data.models.MangaStorIOSQLitePutResolver;
import com.pushtorefresh.storio.sqlite.SQLiteTypeMapping;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.impl.DefaultStorIOSQLite;

/**
 * @ProjectName: Manga
 * @Package: com.demo.manga.data.helpers
 * @ClassName: DatabaseHelper
 * @Description: java类作用描述
 * @Author: Viden
 * @CreateDate: 2022/5/14 14:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2022/5/14 14:23
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DatabaseHelper {

    private final StorIOSQLite db;
    public final MangaManager mangaManager;

    public DatabaseHelper(Context context) {
        db = DefaultStorIOSQLite.builder()
                .sqliteOpenHelper(new DBOpenHelper(context))
                .addTypeMapping(Manga.class, SQLiteTypeMapping.<Manga>builder()
                        .putResolver(new MangaStorIOSQLitePutResolver())
                        .getResolver(new MangaStorIOSQLiteGetResolver())
                        .deleteResolver(new MangaStorIOSQLiteDeleteResolver())
                        .build())
                .build();

        mangaManager = new MangaManager(db);
    }
}
