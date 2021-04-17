package com.example.githubclient.model;

public class PullInfo {

}
//https://api.github.com/repos/wisdomalllife/java_au_previous/pulls/2/commits
//https://api.github.com/repos/:owner/:repo/pulls?state=all
//https://api.github.com/repos/wisdomalllife/java_au_previous/issues/2/comments
//https://api.github.com/repos/wisdomalllife/java_au_previous/pulls/2/comments
/*
!curl -X POST \
-i -H "Accept: application/vnd.github.v3+json" \
-i -H "Authorization: token cc1463dedc32f1f8539f23c389ee8d3d968d8cfe" \
-i -H "Content-Type: application/json" \
https://api.github.com/repos/wisdomalllife/java_au_previous/issues/2/comments \
-d '{"body":"Good morning"}'
 */
//!curl  -H "Authorization: token cc1463dedc32f1f8539f23c389ee8d3d968d8cfe" https://api.github.com/repos/wisdomalllife/java_au_previous/pulls/2/files
/*
!curl -X POST \
-i -H "Accept: application/vnd.github.v3+json" \
-i -H "Authorization: token cc1463dedc32f1f8539f23c389ee8d3d968d8cfe" \
-i -H "Content-Type: application/json" \
https://api.github.com/repos/wisdomalllife/java_au_previous/pulls/2/comments \
-d '{"body":"mama","position":1,"path":"leetcode/linked-list.md","commit_id": "3745f7332ee63c85894bb6042e63915c13487447"}'
 */