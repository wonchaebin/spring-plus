package org.example.expert.domain.todo.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.todo.dto.response.TodoSearchResponse;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.todo.entity.QTodo;
import org.example.expert.domain.user.entity.QUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TodoQueryRepositoryImpl implements TodoQueryRepository{

    private final JPAQueryFactory jpaQueryFactory;
    private final QTodo qTodo = QTodo.todo;

    @Override
    public Optional<Todo> findByIdWithUser(Long todoId) {
        QUser user = QUser.user;

        return Optional.ofNullable(
                jpaQueryFactory
                        .select(qTodo)
                        .from(qTodo)
                        .leftJoin(qTodo.user, user).fetchJoin()
                        .where(qTodo.id.eq(todoId))
                        .fetchOne());
    }

    @Override
    public Page<TodoSearchResponse> search(String title, String nickname, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {

        List<TodoSearchResponse> todos = jpaQueryFactory.select(Projections.constructor(TodoSearchResponse.class,
                qTodo.id,
                qTodo.title,
                qTodo.managers.size().as("managerCount"),
                qTodo.comments.size().as("commentCount")))
                .from(qTodo)
                .where(
                        titleLike(title),
                        nicknameLike(nickname),
                        startDateAfter(startDate),
                        endDateBefore(endDate))
                .orderBy(qTodo.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long totalSize = Optional.ofNullable(jpaQueryFactory.select(Wildcard.count)
                .from(qTodo)
                .where(
                        titleLike(title),
                        nicknameLike(nickname),
                        startDateAfter(startDate),
                        endDateBefore(endDate))
                .fetchOne()).orElse(0L);

        return PageableExecutionUtils.getPage(todos, pageable, () -> totalSize);
    }

    private BooleanExpression titleLike(String title) {
        return title != null ? qTodo.title.contains(title) : null;
    }

    private BooleanExpression nicknameLike(String nickname) {
        return nickname != null ? qTodo.user.nickname.contains(nickname) : null;
    }

    private BooleanExpression startDateAfter(LocalDateTime startDate) {
        return startDate != null ? qTodo.createdAt.after(startDate) : null;
    }

    private BooleanExpression endDateBefore(LocalDateTime endDate) {
        return endDate != null ? qTodo.createdAt.before(endDate) : null;
    }
}
