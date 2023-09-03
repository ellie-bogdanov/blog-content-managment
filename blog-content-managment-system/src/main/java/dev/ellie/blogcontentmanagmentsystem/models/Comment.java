package dev.ellie.blogcontentmanagmentsystem.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Table(name="comment", schema = "blog-content-manager")
public record Comment(
    @Id
    @Column("id")
    int id,
    @Column("postId")
    int postId,
    @NotBlank(message = "username must not be blank")
    @Column("commentUsername")
    String commentUsername,
    @Column("content")
    @NotBlank(message = "content must not be blank")
    @Size(min = 10, max = 200, message = "content must contain between 10 and 200 characters")
    String content,
    @Column("likes")
    int likes,
    @Column("dislikes")
    int dislikes
) {


}
