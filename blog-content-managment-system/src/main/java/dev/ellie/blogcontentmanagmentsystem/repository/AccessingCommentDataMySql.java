package dev.ellie.blogcontentmanagmentsystem.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dev.ellie.blogcontentmanagmentsystem.models.Comment;

public interface AccessingCommentDataMySql extends CrudRepository<Comment, Integer> {

    @Query("SELECT * FROM comment c WHERE c.postId = :postId")
    Iterable<Comment> findAllByPostId(@Param("postId") int postId);
}
