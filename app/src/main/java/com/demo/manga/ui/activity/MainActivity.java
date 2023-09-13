package com.demo.manga.ui.activity;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.demo.manga.R;
import com.demo.manga.databinding.ActivityMainBinding;
import com.demo.manga.ui.BaseActivity;
import com.demo.manga.ui.fragment.LibraryFragment;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

import timber.log.Timber;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;

    private Drawer mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupToolbar();
        initDrawer(savedInstanceState);
    }

    private void initDrawer(Bundle savedInstanceState) {
        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withRootView(binding.drawerContainer)
                .withToolbar(binding.toolbar)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        new PrimaryDrawerItem()
                                .withName(R.string.title_library)
                                .withIdentifier(R.id.nav_drawer_library),
                        new PrimaryDrawerItem()
                                .withName(R.string.title_recent_updates)
                                .withIdentifier(R.id.nav_drawer_recent_updates),
                        new PrimaryDrawerItem()
                                .withName(R.string.title_catalogues)
                                .withIdentifier(R.id.nav_drawer_catalogues),
                        new PrimaryDrawerItem()
                                .withName(R.string.title_settings)
                                .withIdentifier(R.id.nav_drawer_settings)
                )
                .withSavedInstance(savedInstanceState)
                .withOnDrawerItemClickListener(
                        (view, position, drawerItem) -> {
                            long identifier = drawerItem.getIdentifier();
                            if (identifier == R.id.nav_drawer_library) {
                                setFragment(LibraryFragment.newInstance());
                            } else if (identifier == R.id.nav_drawer_recent_updates) {
                            } else if (identifier == R.id.nav_drawer_catalogues) {
                            } else if (identifier == R.id.nav_drawer_settings) {
                            }
                            return false;
                        }
                )
                .build();

        mDrawer.setSelection(R.id.nav_drawer_library);
    }

    private void setFragment(Fragment fragment) {
        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            if (fragment != null) {
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.frame_container, fragment);
                ft.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Timber.e(e);
        }
    }

    private void setupToolbar() {
        setSupportActionBar(binding.toolbar);
    }
}
