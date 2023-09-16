package com.viden.reader.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.viden.reader.BuildConfig;
import com.viden.reader.databinding.FragmentSettingBinding;
import com.viden.reader.presenter.SettingsPresenter;
import com.viden.reader.view.ISettingsView;
import com.viden.reader.view.IShowToastView;

public class SettingsFragment extends BaseFragment implements ISettingsView{

    private FragmentSettingBinding fragmentSettingBinding;
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
        fragmentSettingBinding = FragmentSettingBinding.inflate(inflater,container,false);
        presenter = new SettingsPresenter(this);
        fragmentSettingBinding.checkUpdateBtn.setOnClickListener(view -> {
            presenter.checkForUpdate();
        });
        return fragmentSettingBinding.getRoot();
    }

}
