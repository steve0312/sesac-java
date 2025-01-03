package com.example.demo.prac_0102.myjpasitev4;

import com.example.demo.prac_0102.myjpasitev4.dto.PostCreateRequestDto;
import com.example.demo.prac_0102.myjpasitev4.dto.PostListResponseDto;
import com.example.demo.prac_0102.myjpasitev4.dto.PostResponseDto;
import com.example.demo.prac_0102.myjpasitev4.dto.PostUpdateRequestDto;
import com.example.demo.prac_0102.myjpasitev4.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/v4/posts")
@RequiredArgsConstructor
public class PostControllerV4 {
    // PostService 필요
    private final PostServiceV4 postServiceV4;

    // Exception Handling
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error("resoure not found", "NOT_FOUND"));
    }


    // Post method / url / data
    // 클라이언트가 요청한 데이터를 RequestDTO를 통해 서버로 전달
    @PostMapping
    public ResponseEntity<ApiResponse<PostResponseDto>> createPost(@RequestBody PostCreateRequestDto reqeustDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.ok(
                                "게시글이 정상적으로 작성되었습니다",
                                "CREATED",
                                postServiceV4.createPost(reqeustDto)
                        )
                );

    }

    // Get method / url / 전체 data
    @GetMapping
    public ResponseEntity<ApiResponse<List<PostListResponseDto>>> readPosts(){
        List<PostListResponseDto> data = postServiceV4.readPosts();
        ApiResponse<List<PostListResponseDto>> response = ApiResponse.ok(data);

        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> readPostById(@PathVariable Long id){

        return ResponseEntity.ok(ApiResponse.ok(postServiceV4.readPostById(id)));
    }

    // Put method / id / dto data
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return ResponseEntity.ok(ApiResponse.ok(postServiceV4.updatePost(id, requestDto)));
    }

//    @DeleteMapping("/{id}")
////    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public ResponseEntity<Void> deletePost(@PathVariable Long id){
//        postServiceV4.deletePost(id);
//        return  ResponseEntity.noContent().build();
//    }

    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<ApiResponse<Void>> deletePost(@PathVariable Long id){
        postServiceV4.deletePost(id);
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "게시글이 정상적으로 삭제되었습니다",
                        "DELETED",
                        null
                )
        );
    }
}
