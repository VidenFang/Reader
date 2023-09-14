package com.viden.reader.data.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import com.viden.reader.data.tables.MangasTable;

/**
 * @ProjectName: Manga
 * @Package: com.demo.manga.data.helpers
 * @ClassName: DBOpenHelper
 * @Description: java类作用描述
 * @Author: Viden
 * @CreateDate: 2021/9/6 14:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2022年5月14日 13点41分
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "mangafeed.db";
    public static final int DATABASE_VERSION = 1;

    public DBOpenHelper(@NonNull Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
        db.execSQL(MangasTable.getCreateTableQuery());
    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
