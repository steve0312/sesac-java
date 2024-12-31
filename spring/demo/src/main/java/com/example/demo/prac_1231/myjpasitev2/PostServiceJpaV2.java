package com.example.demo.prac_1231.myjpasitev2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceJpaV2 {
    private final PostRepositoryJpaV2 postRepositoryJpaV2;

//    // 생성자 의존성 주입
//    public PostServiceJpaV2(PostRepositoryJpaV2 postRepositoryJpaV2) {
//        this.postRepositoryJpaV2 = postRepositoryJpaV2;
//    }

    // Create
    public PostJpaV2 createPost(PostJpaV2 post) {
        return postRepositoryJpaV2.save(post);
    }

    // Read- 전체
    public List<PostJpaV2> readPosts() {
        return postRepositoryJpaV2.findAll();
    }

    // Read- 단일
    public PostJpaV2 readPostById(Long id) {
        // id가 있으면 PostJpa 객체가 반환되고 id가 없으면 예외를 던짐
        return postRepositoryJpaV2.findById(id);
//                .orElseThrow(() -> new IllegalArgumentException("없는 Post입니다."));
    }

    // Update
    public PostJpaV2 updatePost(Long id, PostJpaV2 updatePost) {
        // 수정할 post를 찾아야 함
//        PostJpaV2 post = postRepositoryJpaV2.findById(id);
//                .orElseThrow(() -> new IllegalArgumentException("없는 Post입니다."));

//        String title = updatePost.getTitle();
//        String content = updatePost.getContent();

        // title, content를 가지고 post 수정
        // post.update(title, content);

        // 수정된 post 저장
        // return postRepositoryJpa.save(post);

        // 수정, 저장 후 반환 (위의 두 코드를 하나로 합침)
//        return postRepositoryJpaV2.save(post.update(title, content));

        return postRepositoryJpaV2.update(id, updatePost);
    }

    // Delete
    public void deletePost(Long id) {
//        PostJpaV2 post = postRepositoryJpaV2.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("없는 Post입니다."));

        // 찾는 게시글이 있으면 삭제
//        postRepositoryJpaV2.delete(post);
        postRepositoryJpaV2.delete(id);
    }
}
