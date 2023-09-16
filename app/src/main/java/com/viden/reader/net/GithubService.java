package com.viden.reader.net;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {
    @GET("repos/{githubOwner}/{githubRepo}/releases/latest")
    Observable<GithubRelease> getLatestRepo(@Path("githubOwner") String githubOwner, @Path("githubRepo") String githubRepo);
}
