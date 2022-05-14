package com.demo.manga.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.demo.manga.R;
import com.demo.manga.data.models.Manga;
import com.demo.manga.presenter.LibraryPresenter;
import com.demo.manga.ui.BaseActivity;
import com.demo.manga.ui.adapter.LibraryAdapter;
import com.demo.manga.view.ILibraryView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @ProjectName: Manga
 * @Package: com.demo.manga.ui.fragment
 * @ClassName: LibraryFragment
 * @Description: java类作用描述
 * @Author: Viden
 * @CreateDate: 2021/8/28 16:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/8/28 16:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LibraryFragment extends Fragment implements ILibraryView {

    @Bind(R.id.gv_library)
    GridView mGvLib;
    private LibraryAdapter mAdapter;
    private LibraryPresenter mLibraryPresenter;

    public static LibraryFragment newInstance() {
        Bundle args = new Bundle();
        LibraryFragment fragment = new LibraryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public LibraryFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLibraryPresenter = new LibraryPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        ActionBar actionBar = ((BaseActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.title_library);
        }
        ButterKnife.bind(this, view);
        mLibraryPresenter.initLibMangaDatas();
        return view;
    }

    @Override
    public void showLibMangas(List<Manga> mangaList) {
        if (mAdapter == null) {
            mAdapter = new LibraryAdapter(getActivity(), R.layout.item_library, mangaList);
            mGvLib.setAdapter(mAdapter);
        } else {
            mAdapter.setData(mangaList);
        }
    }
}
