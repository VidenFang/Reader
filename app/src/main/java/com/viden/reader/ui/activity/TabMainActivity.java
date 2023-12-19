package com.viden.reader.ui.activity;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.viden.reader.R;
import com.viden.reader.databinding.ActivityTabMainBinding;
import com.viden.reader.ui.fragment.LibraryFragment;
import com.viden.reader.ui.fragment.SettingsFragment;

public class TabMainActivity extends BaseMainActivity {

    private ActivityTabMainBinding binding;

    private Drawer mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTabMainBinding.inflate(getLayoutInflater());
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
                                .withName(R.string.title_updates)
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
                                setFragment(SettingsFragment.newInstance());
                            }
                            return false;
                        }
                )
                .build();

        mDrawer.setSelection(R.id.nav_drawer_library);
    }

    private void setFragment(Fragment fragment) {
        setFragment(R.id.frame_container, fragment);
    }

    private void setupToolbar() {
        setSupportActionBar(binding.toolbar);
    }
}
