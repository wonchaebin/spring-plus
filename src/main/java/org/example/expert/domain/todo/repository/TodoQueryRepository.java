package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.dto.response.TodoSearchResponse;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface TodoQueryRepository {

    Optional<Todo> findByIdWithUser(Long todoId);

    Page<TodoSearchResponse> search(String title, String nickname, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
}
