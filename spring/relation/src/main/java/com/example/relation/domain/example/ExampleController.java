package com.example.relation.domain.example;

import com.example.relation.domain.post.Post;
import com.example.relation.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
