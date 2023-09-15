package com.viden.reader.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.viden.reader.BuildConfig;
import com.viden.reader.databinding.FragmentSettingBinding;

public class SettingsFragment extends Fragment {

    private FragmentSettingBinding fragmentSettingBinding;

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
        fragmentSettingBinding.checkUpdateBtn.setOnClickListener(view -> {
            checkForUpdate(BuildConfig.VERSION_NAME);
        });
        return fragmentSettingBinding.getRoot();
    }

    private void checkForUpdate(String versionName) {
        //toast
        //check
            //success
                //new
                    //dialog
                        //download
                //latest
                    //toast
            //failure
                //toast
    }
}
