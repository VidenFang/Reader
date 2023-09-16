package com.viden.reader.data.helpers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @ProjectName: Manga
 * @Package: com.viden.reader.data.helpers
 * @ClassName: SharedPreferencesHelper
 * @Description: java类作用描述
 * @Author: Viden
 * @CreateDate: 2021/9/6 14:16
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/9/6 14:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SharedPreferencesHelper {

    public static final String PREF_FILE_NAME = "Manga_Shared_PF";
    private SharedPreferences mSharedPreferences;

    public SharedPreferencesHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void clear(){
        mSharedPreferences.edit().clear().apply();
    }
}
