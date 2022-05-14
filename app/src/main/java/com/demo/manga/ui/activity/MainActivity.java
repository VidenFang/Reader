package com.demo.manga.ui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.demo.manga.R;
import com.demo.manga.ui.BaseActivity;
import com.demo.manga.ui.fragment.LibraryFragment;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MainActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.drawer_container)
    FrameLayout mDrawerContainer;

    private Drawer mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupToolbar();
        initDrawer(savedInstanceState);
    }

    private void initDrawer(Bundle savedInstanceState) {
        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withRootView(mDrawerContainer)
                .withToolbar(mToolbar)
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
                            if (drawerItem != null) {
                                int identifier = drawerItem.getIdentifier();
                                switch (identifier) {
                                    case R.id.nav_drawer_library:
                                        setFragment(LibraryFragment.newInstance());
                                        break;
                                    case R.id.nav_drawer_recent_updates:
                                        break;
                                    case R.id.nav_drawer_catalogues:
                                        break;
                                    case R.id.nav_drawer_settings:
                                        break;
                                }
                            }
                            return false;
                        }
                )
                .build();

//        mDrawer.setSelection(R.id.nav_drawer_library);
    }

    private void setFragment(Fragment fragment) {
        try {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragment != null && fragmentManager != null) {
                FragmentTransaction ft = fragmentManager.beginTransaction();
                if (ft != null) {
                    ft.replace(R.id.content_layout, fragment);
                    ft.commit();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Timber.e(e.getMessage(), e);
        }
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
    }
}
