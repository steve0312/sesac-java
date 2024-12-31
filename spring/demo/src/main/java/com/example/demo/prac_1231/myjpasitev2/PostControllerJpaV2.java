package com.example.demo.prac_1231.myjpasitev2;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/v2/posts")
@RequiredArgsConstructor
public class PostControllerJpaV2 {
    private final PostServiceJpaV2 postServiceJpaV2;

//    // 생성자 의존성 주입
//    public PostControllerJpaV2(PostServiceJpaV2 postServiceJpaV2) {
//        this.postServiceJpaV2 = postServiceJpaV2;
//    }

    // Create
    @PostMapping
    public PostJpaV2 createPost(@RequestBody PostJpaV2 newPost) {
        return postServiceJpaV2.createPost(newPost);
    }

    // Read- 전체
    @GetMapping
    public List<PostJpaV2> readPosts() {
        return postServiceJpaV2.readPosts();
    }

    // Read- 단일
    @GetMapping("/{id}")
    public PostJpaV2 readPostById(@PathVariable Long id) {
        return postServiceJpaV2.readPostById(id);
    }

    // Update
    @PutMapping("/{id}")
    public PostJpaV2 updatePost(@PathVariable Long id, @RequestBody PostJpaV2 updatedPost) {
        return postServiceJpaV2.updatePost(id, updatedPost);
    }

    // Delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id) {
        postServiceJpaV2.deletePost(id);
    }
}
