package com.example.demo.prac_0102.myjpasitev4;

import com.example.demo.prac_0102.myjpasitev4.dto.PostCreateRequestDto;
import com.example.demo.prac_0102.myjpasitev4.dto.PostListResponseDto;
import com.example.demo.prac_0102.myjpasitev4.dto.PostResponseDto;
import com.example.demo.prac_0102.myjpasitev4.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostServiceV4 {
    // PostRepository 필요
    private final PostRepositoryV4 postRepositoryV4;

    // Create
    @Transactional
    public PostResponseDto createPost(PostCreateRequestDto requestDto) {
        // save의 인자로는 엔티티를 넘길 수 있으므로 RequestDTO를 엔티티로 변환해줘야 함
        // save 전까지는 비영속 상태이고 save를 해야지 영속 상태가 됨
        // PostV4 transientPost = requestDto.toEntity();
        // PostV4 persistencePost = postRepositoryV4.save(transientPost);
        PostV4 post = postRepositoryV4.save(requestDto.toEntity());

        // 응답은 ResponseDTO를 보내줘야 함
        // 엔티티 객체(post)를 PostResponseDto 타입으로 변환
        return PostResponseDto.from(post);
        // return new PostResponseDto(post.getId(), post.getTitle(), post.getContent(), post.getAuthor()); 와 위의 코드는 동일
    }

    // Read- 전체
    public List<PostListResponseDto> readPosts() {
        // List<PostV4> 를 List<PostListResponseDto> 형태로 바꿈
        // PostV4를 PostListResponseDto로 감싸주기 위해 map 사용
        return postRepositoryV4.findAll().stream()
//                .map((post) -> PostListResponseDto.from(post)); 와 아래 코드는 동일
                .map(PostListResponseDto::from)
                .toList();
    }

    // Read- 단일
    public PostResponseDto readPostById(Long id) {
        PostV4 post = postRepositoryV4.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());

        return PostResponseDto.from(post);
    }

    // Update
    @Transactional
    public PostResponseDto updatePost(Long id, PostUpdateRequestDto postUpdateRequestDto) {
        // 수정에 대한 로직
        // id에 맞는 것을 찾음 -> 수정 -> save
        PostV4 post = postRepositoryV4.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());

        post.update(postUpdateRequestDto);
        // - save를 생략할 수 있는 이유
        // 메서드에 적용된 @Transactional 덕분에 트랜잭션이 종료되고 커밋될 때, 영속성 컨텍스트에 관리 중인 엔티티의 변경 사항이 자동으로 데이터베이스에 반영되므로 save 호출은 불필요하다.
//        postRepositoryV4.save(post);
        return PostResponseDto.from(post);
    }

    // Delete
    @Transactional()
    public void deletePost(Long id) {
        PostV4 post = postRepositoryV4.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());

        postRepositoryV4.delete(post);
    }
}
