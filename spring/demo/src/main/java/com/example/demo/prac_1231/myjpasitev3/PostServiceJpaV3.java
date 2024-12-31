package com.example.demo.prac_1231.myjpasitev3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceJpaV3 {
    private final PostRepositoryJpaV3 postRepositoryJpaV3;

    // Create
    @Transactional
    public PostJpaV3 createPost(PostJpaV3 post) {
        return postRepositoryJpaV3.save(post);
    }

    // Read- 전체
    public List<PostJpaV3> readPosts() {
        return postRepositoryJpaV3.findAll();
    }

    // Read- 단일
    public PostJpaV3 readPostById(Long id) {
        return postRepositoryJpaV3.findById(id);
    }

    // Update
    @Transactional
    public PostJpaV3 updatePost(Long id, PostJpaV3 updatedPost) {
        return postRepositoryJpaV3.update(id, updatedPost);
    }

    // Delete
    @Transactional
    public void deletePost(Long id) {
        postRepositoryJpaV3.delete(id);
    }
}