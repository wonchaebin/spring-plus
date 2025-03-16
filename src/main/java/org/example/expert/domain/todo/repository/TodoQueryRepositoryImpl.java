package org.example.expert.domain.todo.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.todo.entity.QTodo;
import org.example.expert.domain.user.entity.QUser;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TodoQueryRepositoryImpl implements TodoQueryRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Todo> findByIdWithUser(Long todoId) {

        QTodo qTodo = QTodo.todo;
        QUser user = QUser.user;

        return Optional.ofNullable(
                jpaQueryFactory
                        .select(qTodo)
                        .from(qTodo)
                        .leftJoin(qTodo.user, user).fetchJoin()
                        .where(qTodo.id.eq(todoId))
                        .fetchOne());
    }
}
