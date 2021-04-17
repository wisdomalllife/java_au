package com.example.githubclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CommentBody implements Serializable {
    @JsonProperty("position")
    int position;
    @JsonProperty("commit_id")
    String commitId;
    @JsonProperty("path")
    String path;
    @JsonProperty("body")
    String body;

    public int getPosition() {
        return position;
    }

    public String getCommitId() {
        return commitId;
    }

    public String getPath() {
        return path;
    }

    public String getBody() {
        return body;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
