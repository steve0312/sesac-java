package com.example.demo.prac_1230.myjpasite;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceJpa {
    private final PostRepositoryJpa postRepositoryJpa;

    // 생성자 의존성 주입
    public PostServiceJpa(PostRepositoryJpa postRepositoryJpa) {
        this.postRepositoryJpa = postRepositoryJpa;
    }

    // Create
    public PostJpa createPost(PostJpa post) {
        return postRepositoryJpa.save(post);
    }

    // Read- 전체
    public List<PostJpa> readPosts() {
        return postRepositoryJpa.findAll();
    }

    // Read- 단일
    public PostJpa readPostById(Long id) {
        // id가 있으면 PostJpa 객체가 반환되고 id가 없으면 예외를 던짐
        return postRepositoryJpa.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 Post입니다."));
    }

    // Update
    public PostJpa updatePost(Long id, PostJpa updatePost) {
        // 수정할 post를 찾아야 함
        PostJpa post = postRepositoryJpa.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 Post입니다."));

        String title = updatePost.getTitle();
        String content = updatePost.getContent();

        // title, content를 가지고 post 수정
        // post.update(title, content);

        // 수정된 post 저장
        // return postRepositoryJpa.save(post);

        // 수정, 저장 후 반환 (위의 두 코드를 하나로 합침)
        return postRepositoryJpa.save(post.update(title, content));
    }

    // Delete
    public void deletePost(Long id) {
        PostJpa post = postRepositoryJpa.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 Post입니다."));

        // 찾는 게시글이 있으면 삭제
        postRepositoryJpa.delete(post);
    }
}
