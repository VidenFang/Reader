package com.viden.reader.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;

import com.viden.reader.R;
import com.viden.reader.data.models.Manga;
import com.viden.reader.databinding.FragmentLibraryBinding;
import com.viden.reader.presenter.LibraryPresenter;
import com.viden.reader.ui.BaseActivity;
import com.viden.reader.ui.activity.ScreenActivity;
import com.viden.reader.ui.adapter.LibraryAdapter;
import com.viden.reader.view.ILibraryView;

import java.util.List;


/**
 * @ProjectName: Manga
 * @Package: com.viden.reader.ui.fragment
 * @ClassName: LibraryFragment
 * @Description: java类作用描述
 * @Author: Viden
 * @CreateDate: 2021/8/28 16:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/8/28 16:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LibraryFragment extends BaseFragment implements ILibraryView {

    FragmentLibraryBinding fragmentLibraryBinding;
    private LibraryAdapter mAdapter;
    private LibraryPresenter mLibraryPresenter;

    public LibraryFragment() {
    }

    @NonNull
    public static LibraryFragment newInstance() {
        Bundle args = new Bundle();
        LibraryFragment fragment = new LibraryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLibraryPresenter = new LibraryPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        fragmentLibraryBinding = FragmentLibraryBinding.inflate(inflater, container, false);
        ActionBar actionBar = ((BaseActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.title_library);
        }
        mLibraryPresenter.initLibMangaDatas();
        return fragmentLibraryBinding.getRoot();
    }

    @Override
    public void onDestroy() {
        fragmentLibraryBinding = null;
        super.onDestroy();
    }

    @Override
    public void showLibMangas(List<Manga> mangaList) {
        if (mAdapter == null) {
            mAdapter = new LibraryAdapter(getActivity(), R.layout.item_library, mangaList);
            fragmentLibraryBinding.gvLibrary.setAdapter(mAdapter);
            fragmentLibraryBinding.gvLibrary.setOnItemClickListener((adapterView, view, i, l) -> {
                Intent intent = new Intent(getActivity(), ScreenActivity.class);
                startActivity(intent);
            });
        } else {
            mAdapter.setData(mangaList);
        }
    }
}
