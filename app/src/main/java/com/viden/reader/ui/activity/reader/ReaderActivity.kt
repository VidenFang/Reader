package com.viden.reader.ui.activity.reader

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.viden.reader.R
import com.viden.reader.databinding.ActivityReaderBinding
import com.viden.reader.ui.BaseActivity
import com.viden.reader.ui.activity.reader.viewer.MangaPagerAdapter

/**
 *
 * @author VidenFang
 * @since 2023/12/22
 */
class ReaderActivity : BaseActivity() {
    private lateinit var binding: ActivityReaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReaderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewPager: ViewPager = binding.viewerContainer
        val drawableViewData = ArrayList<ImageView>()
        favoriteCollectionsData.forEach {
            val view: ImageView =
                layoutInflater.inflate(R.layout.item_manga, null) as ImageView
            view.setImageResource(it)
            drawableViewData.add(view)
        }
        viewPager.adapter = MangaPagerAdapter(drawableViewData)
    }

    private val favoriteCollectionsData = listOf(
        R.drawable.fc1_short_mantras,
        R.drawable.fc2_nature_meditations,
        R.drawable.fc3_stress_and_anxiety,
        R.drawable.fc4_self_massage,
        R.drawable.fc5_overwhelmed,
        R.drawable.fc6_nightly_wind_down
    )
}