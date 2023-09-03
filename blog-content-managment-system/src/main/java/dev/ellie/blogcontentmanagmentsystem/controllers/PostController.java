package dev.ellie.blogcontentmanagmentsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ellie.blogcontentmanagmentsystem.models.Post;
import dev.ellie.blogcontentmanagmentsystem.repository.AccessingPostDataMySql;


@RestController
@RequestMapping("/api/posts")
public class PostController {
    //private final PostRepository repository;
    private final AccessingPostDataMySql repository;

    @Autowired
    public PostController(AccessingPostDataMySql repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Post> findAll() {
        return (List<Post>) repository.findAll();
    }

    @GetMapping("/{id}")
    public Iterable<Post> findById(@PathVariable Iterable<Integer> id) {
        return repository.findAllById(id);
    }

    @PostMapping
    public void insertPost(@RequestBody Post post) {
        System.out.println(post.postName());
        repository.save(post);

    }

    @PutMapping("{id}/likes")
    public int addLike(@PathVariable Integer id) throws Exception {
        repository.addLike(id);
        return 1;
    }

    @PutMapping("{id}/dislikes")
    public int addDislike(@PathVariable Integer id) throws Exception {
        repository.addDislike(id);
        return 1;
    }
}
