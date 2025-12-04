package com.bootboot.backend.dto.post;

import lombok.Getter;

@Getter
public class Pagination {

    private int size;

    private Long nextCursor;

    public Pagination(int size, Long nextCursor) {

        this.size = size;


        this.nextCursor = nextCursor;

    }

}
