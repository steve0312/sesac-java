package com.example.demo.prac_1230.myjpasite;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/posts")
public class PostControllerJpa {
    private final PostServiceJpa postServiceJpa;

    // 생성자 의존성 주입
    public PostControllerJpa(PostServiceJpa postServiceJpa) {
        this.postServiceJpa = postServiceJpa;
    }

    // Create
    @PostMapping
    public PostJpa createPost(@RequestBody PostJpa newPost) {
        return postServiceJpa.createPost(newPost);
    }

    // Read- 전체
    @GetMapping
    public List<PostJpa> readPosts() {
        return postServiceJpa.readPosts();
    }

    // Read- 단일
    @GetMapping("/{id}")
    public PostJpa readPostById(@PathVariable Long id) {
        return postServiceJpa.readPostById(id);
    }

    // Update
    @PutMapping("/{id}")
    public PostJpa updatePost(@PathVariable Long id, @RequestBody PostJpa updatedPost) {
        return postServiceJpa.updatePost(id, updatedPost);
    }

    // Delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id) {
        postServiceJpa.deletePost(id);
    }
}
