package com.example.demo.prac_1230.bean;

import com.example.demo.prac_1226.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
//    PostRepository postRepository = new PostRepository();

    // DI 활용
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    // Create
    // 컨트롤러에게 data를 입력받아서 - 비즈니스 로직 처리. 내가 할 일을 함
    public Post createPost(Post newPost) {

//        // validation check를 한 후에
//        String title = newPost.getTitle();
//        String content = newPost.getContent();
//
//        // 제목이 아예 없거나 비어있는 경우
//        if(title == null || title.isBlank()) {
//            throw new RuntimeException("title을 입력해주세요.");
//        }
//
//        if(content == null || content.isBlank()) {
//            throw new IllegalArgumentException("content를 입력해주세요.");
//        }
        validatePostData(newPost);


        // post를 생성하겠다.
        return postRepository.save(newPost);
    }

    // Read- 전체
    public List<Post> readPosts() {
        return postRepository.findAll();
    }

    // Read- 단일
    public Post readPostById(Long id) {
        Post post = postRepository.findById(id);

        checkPostIsNull(post);

        return post;
    }

    // Update
    public Post updatePost(Long id, Post updatedPost) {
        // 수정은 특정 게시글을 찾은 후 내용을 바꿔서 저장하는 개념임
        // 특정 게시글을 찾음
        Post post = postRepository.findById(id);

        checkPostIsNull(post);

        validatePostData(updatedPost);

        return postRepository.modify(id, updatedPost);
    }

    // Delete
    public void deletePost(Long id) {
        // 삭제할 특정 게시글을 찾음
        Post post = postRepository.findById(id);
        checkPostIsNull(post);

        postRepository.delete(post);
    }

    // post가 null인지 체크
    public void checkPostIsNull(Post post) {
        if(post == null) {
            throw new IllegalArgumentException("없는 id입니다.");
        }
    }

    // validation 체크
    public void validatePostData(Post post) {
        String title = post.getTitle();
        String content = post.getContent();

        // 제목이 아예 없거나 비어있는 경우
        if(title == null || title.isBlank()) {
            throw new RuntimeException("title을 입력해주세요.");
        }

        if(content == null || content.isBlank()) {
            throw new IllegalArgumentException("content를 입력해주세요.");
        }
    }
}
