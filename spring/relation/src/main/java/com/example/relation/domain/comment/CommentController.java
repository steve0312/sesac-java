package com.example.relation.domain.comment;

import com.example.relation.domain.comment.dto.CommentRequestDto;
import com.example.relation.domain.comment.dto.CommentResponseDto;
import com.example.relation.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts/{postId}/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // Create
    @PostMapping
    public ResponseEntity<ApiResponse<CommentResponseDto>> createComment(@PathVariable Long postId, @Valid @RequestBody CommentRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                        .body(
                                ApiResponse.ok(
                                        "댓글이 정상적으로 작성되었습니다.",
                                        "CREATED",
                                        commentService.createComment(postId, requestDto)
                                )
                        );
    }


    // Update
    @PutMapping("/{commentId}")
    public ResponseEntity<ApiResponse<CommentResponseDto>> updateComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody CommentRequestDto requestDto) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        commentService.updateComment(postId, commentId, requestDto)
                )
        );
    }
}
