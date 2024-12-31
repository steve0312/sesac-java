package com.example.demo.prac_1231.myjpasitev3;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/v3/posts")
@RequiredArgsConstructor
public class PostControllerJpaV3 {
    private final PostServiceJpaV3 postServiceJpaV3;

//    // 생성자 의존성 주입
//    public PostControllerJpaV2(PostServiceJpaV2 postServiceJpaV2) {
//        this.postServiceJpaV2 = postServiceJpaV2;
//    }

    // Create
    @PostMapping
    public PostJpaV3 createPost(@RequestBody PostJpaV3 newPost) {
        return postServiceJpaV3.createPost(newPost);
    }

    // Read- 전체
    @GetMapping
    public List<PostJpaV3> readPosts() {
        return postServiceJpaV3.readPosts();
    }

    // Read- 단일
    @GetMapping("/{id}")
    public PostJpaV3 readPostById(@PathVariable Long id) {
        return postServiceJpaV3.readPostById(id);
    }

    // Update
    @PutMapping("/{id}")
    public PostJpaV3 updatePost(@PathVariable Long id, @RequestBody PostJpaV3 updatedPost) {
        return postServiceJpaV3.updatePost(id, updatedPost);
    }

    // Delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id) {
        postServiceJpaV3.deletePost(id);
    }
}
