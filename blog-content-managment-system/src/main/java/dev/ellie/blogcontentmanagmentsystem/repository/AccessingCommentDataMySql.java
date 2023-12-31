package dev.ellie.blogcontentmanagmentsystem.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dev.ellie.blogcontentmanagmentsystem.models.Comment;

public interface AccessingCommentDataMySql extends CrudRepository<Comment, Integer> {

    @Query("SELECT * FROM comment c WHERE c.postId = :postId")
    Iterable<Comment> findAllByPostId(@Param("postId") int postId);

   
    @Modifying
    @Query("UPDATE comment c SET likes = likes + 1 WHERE c.id = :id")
    void addLike(@Param("id") Integer id);

    @Modifying
    @Query("UPDATE comment c SET dislikes = dislikes + 1 WHERE c.id = :id")
    void addDislike(@Param("id") Integer id);
    
}
