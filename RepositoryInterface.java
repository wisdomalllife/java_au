package com.example.githubclient;

import com.example.githubclient.model.CommentBody;
import com.example.githubclient.model.RepoInfo;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.event.DeletePayload;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface RepositoryInterface {
    @GET("user/repos")
    Call<List<Repository>> listRepos(@Header("Authorization") String accessToken,
                                     @Header("Accept") String apiVersionSpec);

    @DELETE("repos/{owner}/{repo}")
    Call<DeletePayload> deleteRepo(@Header("Authorization") String accessToken, @Header("Accept") String apiVersionSpec,
                                   @Path("repo") String repo, @Path("owner") String owner);

    @POST("user/repos")
    Call<Repository> createRepo(@Body Repository repo, @Header("Authorization") String accessToken,
                                @Header("Accept") String apiVersionSpec,
                                @Header("Content-Type") String contentType);

    @GET("repos/{owner}/{repo}")
    Call<Repository> getUserRepoPulls(@Header("Authorization") String accessToken,
                                      @Header("Accept") String apiVersionSpec,
                                      @Path("owner") String owner,
                                      @Path("repo") String repo);

    @GET("repos/{owner}/{repo}")
    Call<Repository> getUserRepoCommits(@Header("Authorization") String accessToken,
                                        @Header("Accept") String apiVersionSpec,
                                        @Path("owner") String owner,
                                        @Path("repo") String repo);

    //https://api.github.com/repos/wisdomalllife/java_au_previous/pulls/2/comments
    @POST("repos/{owner}/{repo}/pulls/{number}/comments")
    Call<Void> createComment(@Body CommentBody comment,
                             @Path("repo") String repo,
                             @Path("owner") String owner,
                             @Path("number") int number,
                             @Header("Authorization") String accessToken,
                             @Header("Accept") String apiVersionSpec,
                             @Header("Content-Type") String contentType);
    //https://api.github.com/repos/wisdomalllife/java_au_previous/issues/2/comments
    @POST("repos/{owner}/{repo}/issues/{number}/comments")
    Call<Void> createIssues(@Body CommentBody comment,
                           @Path("repo") String repo,
                           @Path("owner") String owner,
                           @Path("number") int number,
                           @Header("Authorization") String accessToken,
                           @Header("Accept") String apiVersionSpec,
                           @Header("Content-Type") String contentType);
}