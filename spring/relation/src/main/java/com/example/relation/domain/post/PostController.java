package com.example.relation.domain.post;

import com.example.relation.domain.post.dto.*;
import com.example.relation.domain.tag.dto.TagRequestDto;
import com.example.relation.domain.user.entity.User;
import com.example.relation.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<ApiResponse<PostResponseDto>> createPost(@Valid @RequestBody PostCreateRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.ok("게시글이 성공적으로 작성되었습니다","CREATED",
                                postService.createPost(requestDto)
                        )
                );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PostListResponseDto>>> readPosts() {
        ApiResponse<List<PostListResponseDto>> response = ApiResponse.ok(postService.readPosts());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostWithCommentResponseDto>> readPostById(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostById(id)
                )
        );
    }

    // JOIN을 통한 Read
    @GetMapping("/v2/{id}")
    public ResponseEntity<ApiResponse<PostWithCommentResponseDtoV2>> readPostByIdV2(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostByIdV2(id)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        ApiResponse<PostResponseDto> response = ApiResponse.ok("게시글이 성공적으로 수정되었습니다", "UPDATED", postService.updatePost(id, requestDto));

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        ApiResponse<Void> response = ApiResponse.ok("게시글이 성공적으로 삭제되었습니다", "DELETED", null);
        return ResponseEntity.ok(response);

    }


    // record
    @GetMapping("/comment-count")
    public ResponseEntity<ApiResponse<List<PostListWithCommentCountResponseDto>>> readPostsWithCommentCount() {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostsWithCommentCount()
                )
        );
    }

    // DTO 활용
    @GetMapping("/comment-count-dto")
    public ResponseEntity<ApiResponse<List<PostListWithCommentCountResponseDto>>> readPostWithCommentCountDto() {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostWithCommentCountDto()
                )
        );
    }


    // Create- PostTag
    @PostMapping("/{id}/tags")
    public void addTagToPost(@PathVariable Long id, @Valid @RequestBody TagRequestDto requestDto) {
        postService.addTagToPost(id, requestDto);
    }


    // Read- 게시글을 댓글과 태그들과 함께 조회
    @GetMapping("/{id}/detail")
    public ResponseEntity<ApiResponse<PostWithCommentAndTagResponseDto>> readPostsByIdWithCommentAndTag(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostsByIdWithCommentAndTag(id)
                )
        );
    }


    // Read- Batch size 조절
    @GetMapping("/{id}/detail/v2")
    public ResponseEntity<ApiResponse<PostWithCommentAndTagResponseDtoV2>> readPostsByIdWithCommentAndTagV2(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostsByIdWithCommentAndTagV2(id)
                )
        );
    }


    // Tag별 게시글 가져오기
    @GetMapping("/tags")
    public ResponseEntity<ApiResponse<List<PostListResponseDto>>> readPostsByTag(@RequestParam String tag) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostsByTag(tag)
                )
        );
    }

    // Tag별 게시글 가져오기- PostWithCommentAndTagResponseDtoV2 사용
//    @GetMapping("/tags")
//    public ResponseEntity<ApiResponse<List<PostWithCommentAndTagResponseDtoV2>>> readPostsByTag(@RequestParam String tag) {
//        return ResponseEntity.ok(
//                ApiResponse.ok(
//                        postService.readPostsByTag(tag)
//                )
//        );
//    }


    // Read- Paging
    @GetMapping("/pages")
    public ResponseEntity<ApiResponse<List<PostListResponseDto>>> readPostsWithPage(Pageable pageable) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostsWithPage(pageable)
                )
        );
    }


    // Read- paging 추가 정보
    @GetMapping("/pages/detail")
    public ResponseEntity<ApiResponse<PostListWithPageResponseDto>> readPostWithPageDetail(Pageable pageable) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostWithPageDetail(pageable)
                )
        );
    }


    // OneToMany에서의 paging
    @GetMapping("/detail/pages")
    public ResponseEntity<ApiResponse<List<PostWithCommentResponseDtoV2>>> readPostsWithCommentPage(Pageable pageable) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.readPostsWithCommentPage(pageable)
                )
        );
    }


    // image upload
    @PostMapping("/images")
    public ResponseEntity<ApiResponse<PostWithImageResponseDto>> createPostWithImage(@RequestPart(value="data") PostCreateRequestDto requestDto, @RequestPart(value="image", required = false)MultipartFile image) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.createPostWithImage(requestDto, image)
                )
        );
    }


    // Post에 작성자 추가
    @PostMapping("/post2")
    public ResponseEntity<ApiResponse<Post2ResponseDto>> createPost2(@RequestBody Post2CreateWithAuthorRequestDto requestDto, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.createPost2(requestDto, user)
                )
        );
    }
}





