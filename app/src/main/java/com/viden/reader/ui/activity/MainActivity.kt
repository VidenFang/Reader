package com.viden.reader.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
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
//        binding.bottomNav.setItemIconSize(100)
        val bottomNav = binding.bottomNav
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_library -> {
                    setFragment(LibraryFragment.newInstance())
                    binding.toolbar.title = getString(R.string.label_library)
                    true
                }

                R.id.nav_updates -> {
                    false
                }

                R.id.nav_history -> {
                    false
                }

                R.id.nav_browse -> {
                    false
                }

                R.id.nav_more -> {
                    setFragment(SettingsFragment.newInstance())
                    binding.toolbar.title = getString(R.string.label_more)
                    true
                }

                else -> {
                    false
                }
            }
        }
        bottomNav.selectedItemId = R.id.nav_library
        bottomNav.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_LABELED
    }

    private fun setFragment(fragment: Fragment) {
        setFragment(R.id.frame_container, fragment)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
    }
}