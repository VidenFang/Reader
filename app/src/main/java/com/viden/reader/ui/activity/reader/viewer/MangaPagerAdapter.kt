package com.viden.reader.ui.activity.reader.viewer

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

/**
 *
 * @author VidenFang
 * @since 2023/12/22
 */
class MangaPagerAdapter(val data: List<View>) : PagerAdapter() {

    override fun getCount(): Int {
        return data.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(data[position])
        return data[position]
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(data[position])
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }
}