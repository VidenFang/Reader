package com.viden.reader.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.viden.reader.R
import com.viden.reader.databinding.ActivityMainBinding
import com.viden.reader.ui.fragment.LibraryFragment
import com.viden.reader.ui.fragment.SettingsFragment

/**
 *
 * @author VidenFang
 * @since 2023/12/19
 */
class MainActivity : BaseMainActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolbar()
        binding.navigation.setItemIconSize(100)
        binding.navigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_library -> {
                    setFragment(LibraryFragment.newInstance())
                    true
                }

                R.id.action_updates -> {
                    false
                }

                R.id.action_catalogues -> {
                    false
                }

                R.id.action_settings -> {
                    setFragment(SettingsFragment.newInstance())
                    true
                }

                else -> {
                    false
                }
            }
        }
    }

    private fun setFragment(fragment: Fragment) {
        setFragment(R.id.frame_container, fragment)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
    }
}