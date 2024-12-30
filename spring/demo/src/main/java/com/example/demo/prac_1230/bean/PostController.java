package com.example.demo.prac_1230.bean;

import com.example.demo.prac_1226.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/mvc/posts")
public class PostController {
//    PostService postService = new PostService();

    // DI 활용
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    // Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post newPost) {
        return postService.createPost(newPost);
    }

    // Read- 전체
    @GetMapping
    public List<Post> readPost() {
        return postService.readPosts();
    }

    // Read- 단일
    @GetMapping("/{id}")
    public Post readPostById(@PathVariable Long id) {
        return postService.readPostById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        return postService.updatePost(id, updatedPost);
    }

    // Delete
    @DeleteMapping("/{id}")
    // 아무것도 반환하지 않기 때문에 정상 삭제된 것을 확인하고자 상태 코드 사용
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
