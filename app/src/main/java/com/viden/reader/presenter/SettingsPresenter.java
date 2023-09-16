package com.viden.reader.presenter;

import com.viden.reader.BuildConfig;
import com.viden.reader.net.GithubRelease;
import com.viden.reader.net.GithubService;
import com.viden.reader.net.RetrofitServiceManager;
import com.viden.reader.utils.VersionUtil;
import com.viden.reader.view.ISettingsView;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.HttpException;
import timber.log.Timber;

public class SettingsPresenter {
    final private ISettingsView view;
    private GithubService githubService;


    public SettingsPresenter(ISettingsView view) {
        this.view = view;
    }

    public void checkForUpdate() {
        //toast
        view.showShortToast("正在检查更新…");
        //check
        RetrofitServiceManager retrofitServiceManager = new RetrofitServiceManager("https://api.github.com/");
        githubService = retrofitServiceManager.create(GithubService.class);
        githubService.getLatestRepo("tachiyomiorg", "tachiyomi")
//        githubService.getLatestRepo("VidenFang", "Reader")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GithubRelease>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Timber.i("onSubscribe");
                    }

                    @Override
                    public void onNext(@NonNull GithubRelease githubRelease) {
                        Timber.w("onNext:%s", githubRelease);
                        Timber.i("githubTag = %s", githubRelease.getTagName());
                        if (VersionUtil.isNewVersion(githubRelease.getTagName())) {
                            //dialog
                            if (githubRelease.getAssets().size() > 0) {
                                view.showDialog("有新版本");
                            }
                        } else {
                            view.showShortToast("没有新版本");
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if (e instanceof HttpException) {
                            HttpException httpException = (HttpException) e;
                            Timber.w("HttpException onError:%s:%s:%s", httpException.toString(), e.getLocalizedMessage(), ((HttpException) e).response());
                            view.showShortToast(httpException.getLocalizedMessage());
                        } else {
                            Timber.w("onError:%s:%s", e.toString(), e.getMessage());
                            view.showShortToast(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
                        Timber.i("onComplete");
                    }
                });

        //  success
        //      new
        //          dialog
        //              download
        //          latest
        //              toast
        //  failure
        //      toast
    }
}
