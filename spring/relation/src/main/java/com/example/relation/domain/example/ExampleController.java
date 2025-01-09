package com.example.relation.domain.example;

import com.example.relation.domain.post.Post;
import com.example.relation.domain.post.PostRepository;
import com.example.relation.domain.post.dto.PostWithCommentResponseDtoV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {
    private final PostRepository postRepository;

    @GetMapping("/basic/{postId}")
    public void LoadingExample1(@PathVariable Long postId){
        Post post = postRepository.findById(postId).orElseThrow();
        int commentSize = post.getComments().size();
    }

    // fetch join
    // 연관된 엔티티나 컬렉션을 한 번의 SQL로 함께 조회하는 방법
    @GetMapping("/fetch/{postId}")
    public void LoadingExample2(@PathVariable Long postId){
        Post post = postRepository.findByIdWithCommentFetch(postId).orElseThrow();
        int commentSize = post.getComments().size();
    }

    // N+1 문제 발생
    // post(1) + post에 속한 댓글의 수(N)
    @GetMapping("/nplus1/basic")
    public void LoadingExample3(){
        List<Post> posts  =postRepository.findAll();
        posts.stream().map(PostWithCommentResponseDtoV2::from).toList();
    }

    // fetch join을 통한 N+1 문제 해결
    @GetMapping("/nplus1/fetch")
    public void LoadingExample4(){
        List<Post> posts = postRepository.findAllWithCommentFetch();
        posts.stream().map(PostWithCommentResponseDtoV2::from).toList();
    }
}
