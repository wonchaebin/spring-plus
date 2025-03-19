package org.example.expert.domain.todo.dto.response;

import lombok.Getter;

@Getter
public class TodoSearchResponse {

    private final long id;
    private final String title;
    private final int managerCount;
    private final int commentCount;

    public TodoSearchResponse(long id, String title, int managerCount, int commentCount) {
        this.id = id;
        this.title = title;
        this.managerCount = managerCount;
        this.commentCount = commentCount;
    }
}
