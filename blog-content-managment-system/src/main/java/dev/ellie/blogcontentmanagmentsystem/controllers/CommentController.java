package dev.ellie.blogcontentmanagmentsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ellie.blogcontentmanagmentsystem.models.Comment;
import dev.ellie.blogcontentmanagmentsystem.repository.AccessingCommentDataMySql;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final AccessingCommentDataMySql repository;

    @Autowired
    public CommentController(AccessingCommentDataMySql repository) {
        this.repository = repository;
    }

    @GetMapping("{postId}")
    public List<Comment> findAllByPostId(@PathVariable int postId) {
        return (List<Comment>) repository.findAllByPostId(postId);
    }

    @GetMapping()
    public List<Comment> findAll() {
        return (List<Comment>) repository.findAll();
    }

    @PutMapping("{postId}/{id}/likes")
    public int addLike(@PathVariable Integer postId,@PathVariable Integer id) {
        repository.addLike(id);
        return 1;
    } 

    @PutMapping("{postId}/{id}/dislikes")
    public int addDislike(@PathVariable Integer postId,@PathVariable Integer id) {
        repository.addDislike(id);
        return 1;
    } 
}
