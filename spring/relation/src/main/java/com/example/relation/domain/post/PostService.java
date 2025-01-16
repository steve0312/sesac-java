package com.example.relation.domain.post;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.comment.CommentRepository;
import com.example.relation.domain.post.dto.*;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.entity.PostTag;
import com.example.relation.domain.post.repository.Post2Repository;
import com.example.relation.domain.post.repository.PostTagRepository;
import com.example.relation.domain.tag.Tag;
import com.example.relation.domain.tag.TagRepository;
import com.example.relation.domain.tag.dto.TagRequestDto;
import com.example.relation.domain.user.entity.User;
import com.example.relation.global.common.service.FileService;
import com.example.relation.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final TagRepository tagRepository;
    private final PostTagRepository postTagRepository;
    private final FileService fileServie;
    private final Post2Repository post2Repository;


    @Transactional
    public PostResponseDto createPost(PostCreateRequestDto requestDto) {
        Post post = postRepository.save(requestDto.toEntity());
        return PostResponseDto.from(post);
    }

    public List<PostListResponseDto> readPosts(){
        return postRepository.findAll().stream()
                .map(PostListResponseDto::from)
                .toList();
    }

    // 방식 1
    // 게시글에 정보 따로, 해당 게시글에 대한 댓글 목록을 따로 만들어 Dto로 합쳐 전달
    public PostWithCommentResponseDto readPostById(Long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());

        // 특정 post id를 가지고 있는 commets를 가져오고 싶다.
        List<Comment> comments = commentRepository.findByPostId(id);

        return PostWithCommentResponseDto.from(post, comments);
    }

    // 방식 2
    // JOIN을 통한 Read
    public PostWithCommentResponseDtoV2 readPostByIdV2(Long id) {
        // post, comment를 한 번에 가져오고 싶다.
        Post post = postRepository.findByIdWithComment(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        return PostWithCommentResponseDtoV2.from(post);

        // dto로 변경해서 return한다.
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostUpdateRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        post.update(requestDto);

        return PostResponseDto.from(post);
    }

    @Transactional
    public void deletePost(Long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());

        postRepository.delete(post);
    }


    // record
    public List<PostListWithCommentCountResponseDto> readPostsWithCommentCount() {
        List<Object[]> results = postRepository.findAllWithCommentCount();

        return results.stream()
                .map(
                        result -> {
                            Post post = (Post) result[0];
                            Long commentCount = (Long) result[1];

                            return new PostListWithCommentCountResponseDto(
                                    post.getId(),
                                    post.getTitle(),
                                    post.getCreatedAt(),
                                    commentCount
                            );
                        })
                .toList();
    }

    // DTO 활용
    public List<PostListWithCommentCountResponseDto> readPostWithCommentCountDto() {
        return postRepository.findAllWithCommentCountDTO();
    }


    // Create- PostTag
    // Post와 Tag를 가지고 연결시켜주기
    @Transactional
    public void addTagToPost(Long id, TagRequestDto requestDto) {
        // 게시글 찾음
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        // 태그를 찾음
        Tag tag = tagRepository.findByName(requestDto.getName())
                .orElseThrow(() -> new ResourceNotFoundException());

        PostTag postTag = new PostTag();

        // PostTag에 Post, Tag와의 연관관계 설정
        postTag.addTag(tag);
        postTag.addPost(post);

        // Post에 PostTag와의 연관관계 설정
        // addPost 메서드의 post.getPostTags().add(this); 내용과 동일한 효과
        post.getPostTags().add(postTag);

        postTagRepository.save(postTag);
    }


    // Read- 게시글을 댓글과 태그들과 함께 조회
    public PostWithCommentAndTagResponseDto readPostsByIdWithCommentAndTag(Long id) {
        // 댓글과 태그를 가진 게시글을 가져오자
//        Post post = postRepository.findByIdWithCommentAndTag(id)
//                .orElseThrow(() -> new ResourceNotFoundException());

        // 태그를 가진 게시글 가져옴
        Post postWithTag = postRepository.findByIdWithTag(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        // 게시글에 맞는 댓글 가져옴
        List<Comment> comments = commentRepository.findByPostId(id);

        // 하나의 ResponseDTO로 통합해서 반환
        return PostWithCommentAndTagResponseDto.from(postWithTag, comments);
    }


    // Read- Batch size 조절
    public PostWithCommentAndTagResponseDtoV2 readPostsByIdWithCommentAndTagV2(Long id) {
        // 댓글과 태그를 가진 게시글을 가져오자
        Post postWithTag = postRepository.findByIdWithCommentAndTag(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        return PostWithCommentAndTagResponseDtoV2.from(postWithTag);
    }


    // Tag별 게시글 가져오기
    public List<PostListResponseDto> readPostsByTag(String tag) {
        // 태그 이름에 맞는 게시글들을 가져옴
        return postRepository.findAllByTagName(tag).stream()
                .map(PostListResponseDto::from)
                .toList();
    }

    // Tag별 게시글 가져오기- PostWithCommentAndTagResponseDtoV2 사용
//    public List<PostWithCommentAndTagResponseDtoV2> readPostsByTag(String tag) {
//        // 태그 이름에 맞는 게시글들을 가져옴
//        return postRepository.findAllByTagName(tag).stream()
//                .map(PostWithCommentAndTagResponseDtoV2::from)
//                .toList();
//    }


//    // TagPost Create 개선
//    // 기존 Create- PostTag 코드
//    // Post와 Tag를 가지고 연결시켜주기
//    @Transactional
//    public void addTagToPost2(Long id, TagRequestDto requestDto) {
//        // 게시글 찾음
//        Post post = postRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException());
//
//        // 태그를 찾음
////        Tag tag = tagRepository.findByName(requestDto.getName())
////                .orElseThrow(() -> new ResourceNotFoundException());
//
//
//        // 태그를 가져올건데 해당 태그가 없으면 만들고 있으면 꺼내오자
//        // if(tagRepository.existsByTagName(name)) {
//        // 있으면 꺼내오고
//        // else {
//        // 없으면 만들어라 }
//
//        Tag tag = tagRepository.findByName(requestDto.getName())
//                .orElseGet(() -> {
//                    // 태그가 이미 존재하면 존재하는 태그를 전달
//                    // 없으면 태그를 새로 만들어
//                    Tag newTag = new Tag(requestDto.getName());
//                    // 저장해
//                    return tagRepository.save(newTag);
//                    // 위의 두 줄의 코드와 동일
//                    // return tagRepository.save(requestDto.toEntity());
//                });
//
//
//        PostTag postTag = new PostTag();
//
//        // PostTag에 Post, Tag와의 연관관계 설정
//        postTag.addTag(tag);
//        postTag.addPost(post);
//
//        // Post에 PostTag와의 연관관계 설정
//        // addPost 메서드의 post.getPostTags().add(this); 내용과 동일한 효과
//        post.getPostTags().add(postTag);
//
//        postTagRepository.save(postTag);
//    }


    // Read- Paging
    public List<PostListResponseDto> readPostsWithPage(Pageable pageable) {
        // findAll 메서드 반환이 Pageable<Post>로 오므로 ResponseDTO로 변환해서 반환
        return postRepository.findAll(pageable).getContent().stream()
                .map(PostListResponseDto::from)
                .toList();
    }

    // Read- paging 추가 정보
    public PostListWithPageResponseDto readPostWithPageDetail(Pageable pageable) {
        return PostListWithPageResponseDto.from(postRepository.findAll(pageable));
    }


    public List<PostWithCommentResponseDtoV2> readPostsWithCommentPage(Pageable pageable) {
        return postRepository.findPostsWithCommentPage(pageable).getContent().stream()
                .map(PostWithCommentResponseDtoV2::from)
                .toList();
    }


    // image upload
    @Transactional
    public PostWithImageResponseDto createPostWithImage(PostCreateRequestDto requestDto, MultipartFile image) {
        String imageUrl = null;

        if(image != null && !image.isEmpty()) {
            imageUrl = fileServie.saveFile(image);
        }

        Post post = requestDto.toEntity();
        post.setImageUrl(imageUrl);

        return PostWithImageResponseDto.from(postRepository.save(post));
    }


    // Post에 작성자 추가
    @Transactional
    public Post2ResponseDto createPost2(Post2CreateWithAuthorRequestDto requestDto, User user) {
        return Post2ResponseDto.from(post2Repository.save(requestDto.toEntity(user)));
    }
}
