package com.bootboot.backend.dto.comment;

import lombok.Getter;

@Getter
public class CommentRequest {

    private String content;

    public CommentRequest(String content) {

        this.content = content;

    }
}
