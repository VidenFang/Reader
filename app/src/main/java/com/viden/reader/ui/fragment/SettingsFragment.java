package com.viden.reader.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.viden.reader.databinding.FragmentSettingBinding;
import com.viden.reader.net.GithubRelease;
import com.viden.reader.presenter.SettingsPresenter;
import com.viden.reader.ui.activity.UpdateActivity;
import com.viden.reader.view.ISettingsView;

public class SettingsFragment extends BaseFragment implements ISettingsView {

    public static final String GITHUB_RELEASE = "GithubRelease";
    private SettingsPresenter presenter;

    public static SettingsFragment newInstance() {
        Bundle args = new Bundle();
        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        com.viden.reader.databinding.FragmentSettingBinding fragmentSettingBinding = FragmentSettingBinding.inflate(inflater, container, false);
        presenter = new SettingsPresenter(this);
        fragmentSettingBinding.checkUpdateBtn.setOnClickListener(view -> {
//            presenter.checkForUpdate("https://api.github.com/", "tachiyomiorg", "tachiyomi", false);
            presenter.checkForUpdate("https://gitee.com/", "VidenFang", "tachiyomi", true);
        });
        return fragmentSettingBinding.getRoot();
    }

    @Override
    public void showUpdateInfo(GithubRelease githubRelease) {
        Intent intent = new Intent(getActivity(), UpdateActivity.class);
        intent.putExtra(GITHUB_RELEASE, githubRelease);
        startActivity(intent);
    }
}
