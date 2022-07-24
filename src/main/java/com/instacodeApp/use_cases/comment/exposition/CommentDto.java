package com.instacodeApp.use_cases.comment.exposition;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CommentDto {

    private long id;

    @NotEmpty(message = "Name should not be null or empty")
    private String username;

    @NotEmpty
    private String body;
}
