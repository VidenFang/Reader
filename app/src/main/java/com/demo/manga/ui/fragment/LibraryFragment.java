package com.demo.manga.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;

import com.demo.manga.R;
import com.demo.manga.data.models.Manga;
import com.demo.manga.databinding.FragmentLibraryBinding;
import com.demo.manga.presenter.LibraryPresenter;
import com.demo.manga.ui.BaseActivity;
import com.demo.manga.ui.adapter.LibraryAdapter;
import com.demo.manga.view.ILibraryView;

import java.util.List;


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

    FragmentLibraryBinding fragmentLibraryBinding;
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
        fragmentLibraryBinding = FragmentLibraryBinding.inflate(inflater,container,false);
        ActionBar actionBar = ((BaseActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.title_library);
        }
        mLibraryPresenter.initLibMangaDatas();
        return fragmentLibraryBinding.getRoot();
    }

    @Override
    public void showLibMangas(List<Manga> mangaList) {
        if (mAdapter == null) {
            mAdapter = new LibraryAdapter(getActivity(), R.layout.item_library, mangaList);
            fragmentLibraryBinding.gvLibrary.setAdapter(mAdapter);
        } else {
            mAdapter.setData(mangaList);
        }
    }
}
