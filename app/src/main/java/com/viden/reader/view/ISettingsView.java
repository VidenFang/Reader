package com.viden.reader.view;

import com.viden.reader.net.GithubRelease;

public interface ISettingsView extends IBaseView, IShowToastView, IShowDialogView{
    void showUpdateInfo(GithubRelease githubRelease);
}
