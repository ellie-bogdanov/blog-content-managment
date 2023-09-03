package dev.ellie.blogcontentmanagmentsystem.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dev.ellie.blogcontentmanagmentsystem.models.Post;

public interface AccessingPostDataMySql extends CrudRepository<Post, Integer> {

    @Modifying
    @Query("UPDATE post p SET likes = likes + 1 WHERE p.id = :id")
    void addLike(@Param("id") Integer id);

    @Modifying
    @Query("UPDATE post p SET dislikes = dislikes + 1 WHERE p.id = :id")
    void addDislike(@Param("id") Integer id);
    
}
