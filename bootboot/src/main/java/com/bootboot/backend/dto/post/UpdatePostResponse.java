package com.bootboot.backend.dto.post;

import lombok.Getter;

@Getter
public class UpdatePostResponse {

    private Long postId;

    public UpdatePostResponse(Long postId) {
        this.postId = postId;
    }

}
