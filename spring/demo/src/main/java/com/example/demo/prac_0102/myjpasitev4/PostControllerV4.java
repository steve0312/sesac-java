package com.example.demo.prac_0102.myjpasitev4;

import com.example.demo.prac_0102.myjpasitev4.dto.PostCreateRequestDto;
import com.example.demo.prac_0102.myjpasitev4.dto.PostListResponseDto;
import com.example.demo.prac_0102.myjpasitev4.dto.PostResponseDto;
import com.example.demo.prac_0102.myjpasitev4.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/v4/posts")
@RequiredArgsConstructor
public class PostControllerV4 {
    // PostService 필요
    private final PostServiceV4 postServiceV4;

    // Post method / url / data
    // 클라이언트가 요청한 데이터를 RequestDTO를 통해 서버로 전달
    @PostMapping
    public PostResponseDto createPost(@RequestBody PostCreateRequestDto requestDto) {
        return postServiceV4.createPost(requestDto);
    }

    // Get method / url / 전체 data
    @GetMapping
    public List<PostListResponseDto> readPosts() {
        return postServiceV4.readPosts();
    }

    @GetMapping("/{id}")
    public PostResponseDto readPostById(@PathVariable Long id) {
        return postServiceV4.readPostById(id);
    }

    // Put method / id / dto data
    @PutMapping("/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto postUpdateRequestDto) {
        return postServiceV4.updatePost(id, postUpdateRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id) {
        postServiceV4.deletePost(id);
    }
}
