package com.viden.reader.net;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {
    @GET("repos/{owner}/{repo}/releases/latest")
    Observable<GithubRelease> getLatestRepo(@Path("owner") String owner, @Path("repo") String repo);

    @GET("api/v5/repos/{owner}/{repo}/releases/latest")
    Observable<GithubRelease> getGitEELatestRepo(@Path("owner") String owner, @Path("repo") String repo);

}
