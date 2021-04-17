package com.example.githubclient;

import com.example.githubclient.model.CommentBody;
import com.example.githubclient.model.RepoInfo;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.event.DeletePayload;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

@Service
public class GitHubService implements APIConfiguration {

    private String accessToken;

    private RepositoryInterface service;

    public GitHubService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RepositoryInterface.class);
        this.accessToken = "token cc1463dedc32f1f8539f23c389ee8d3d968d8cfe";//+ System.getenv("ACCESS_TOKEN");
    }

    public List<Repository> getRepositories() throws IOException {
        Call<List<Repository>> retrofitCall = service.listRepos(accessToken, API_VERSION_SPEC);

        Response<List<Repository>> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    }


    public Repository createRepository(Repository repo) throws IOException {
        Call<Repository> retrofitCall = service.createRepo(repo, accessToken, API_VERSION_SPEC, JSON_CONTENT_TYPE);

        Response<Repository> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    }

    public DeletePayload deleteRepository(String owner, String repoName) throws IOException {
        Call<DeletePayload> retrofitCall = service.deleteRepo(accessToken, API_VERSION_SPEC, repoName, owner);

        Response<DeletePayload> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    }

    public void createComment() throws IOException{
        CommentBody message = new CommentBody();
        message.setBody("maMM");
        message.setPath("leetcode/linked-list.md");
        message.setCommitId("3745f7332ee63c85894bb6042e63915c13487447");
        message.setPosition(1);
        Call<Void> retrofitCall = service.createComment(message,"java_au_previous","wisdomalllife",2, accessToken, API_VERSION_SPEC, JSON_CONTENT_TYPE);

    }
/*
!curl -X POST \
-i -H "Accept: application/vnd.github.v3+json" \
-i -H "Authorization: token cc1463dedc32f1f8539f23c389ee8d3d968d8cfe" \
-i -H "Content-Type: application/json" \
https://api.github.com/repos/wisdomalllife/java_au_previous/pulls/2/comments \
-d '{"body":"mama","position":1,"path":"leetcode/linked-list.md","commit_id": "3745f7332ee63c85894bb6042e63915c13487447"}'
 */
    public void createIssues() throws IOException{
        CommentBody message = new CommentBody();
        message.setBody("Good!");
        Call<Void> retrofitCall = service.createIssues(message,"java_au_previous","wisdomalllife",2, accessToken, API_VERSION_SPEC, JSON_CONTENT_TYPE);

    }
    /*
    !curl -X POST \
    -i -H "Accept: application/vnd.github.v3+json" \
    -i -H "Authorization: token cc1463dedc32f1f8539f23c389ee8d3d968d8cfe" \
    -i -H "Content-Type: application/json" \
    https://api.github.com/repos/wisdomalllife/java_au_previous/issues/2/comments \
    -d '{"body":"Good morning"}'
     */
}