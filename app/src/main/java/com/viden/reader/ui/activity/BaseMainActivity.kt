package com.viden.reader.ui.activity

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.viden.reader.ui.BaseActivity
import timber.log.Timber

/**
 *
 * @author VidenFang
 * @since 2023/12/19
 */
abstract class BaseMainActivity : BaseActivity() {
    protected open fun setFragment(@IdRes containerId: Int, fragment: Fragment?) {
        try {
            if (fragment != null) {
                val ft = supportFragmentManager.beginTransaction()
                ft.replace(containerId, fragment)
                ft.commit()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Timber.e(e)
        }
    }
}