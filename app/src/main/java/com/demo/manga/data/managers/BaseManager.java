package com.demo.manga.data.managers;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;

/**
 * @ProjectName: Manga
 * @Package: com.demo.manga.data.managers
 * @ClassName: BaseManager
 * @Description: java类作用描述
 * @Author: Viden
 * @CreateDate: 2022/5/14 14:41
 * @UpdateUser: 更新者
 * @UpdateDate: 2022/5/14 14:41
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class BaseManager {
    protected StorIOSQLite db;

    public BaseManager(StorIOSQLite db) {
        this.db = db;
    }
}
