package com.example.githubclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class RepoInfo implements Serializable {

    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("created_at")
    private String crTime;

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getCrTime() {
        return crTime;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public void setCrTime(String crTime) {
        this.crTime = crTime;
    }
}


