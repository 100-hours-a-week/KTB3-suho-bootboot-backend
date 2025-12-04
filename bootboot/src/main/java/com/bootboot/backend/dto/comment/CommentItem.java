package com.bootboot.backend.dto.comment;

import com.bootboot.backend.dto.user.WriterInfo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentItem {

    private Long commentId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private WriterInfo writerInfo;

    public CommentItem(Long commentId, String content, LocalDateTime createdAt, LocalDateTime updatedAt, WriterInfo writerInfo) {
        this.commentId = commentId;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.writerInfo = writerInfo;
    }

}
