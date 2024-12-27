package com.example.demo.prac_1227;

import com.example.demo.prac_1226.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// 요청을 받고 처리
@RestController
// 공통 URL 경로 설정
@RequestMapping("v6/posts")
public class PostApi6 {
    // Post 클래스의 인스턴스, 즉 게시글을 넣음
    List<Post> posts = new ArrayList<>();   // DB를 사용하지 않고 게시글을 하는 방식이라서 List 사용
    private Long id = 0L;   // 게시글 생성에서 id 생성을 위한 장치

    {
        // 초기화 블록
        // 인스턴스가 생성되었을 때 한 번 실행된다.
        // 초기값을 넣을 때 사용된다.
        posts.add(new Post(++id, "초기 제목", "초기 내용"));
    }

    // create에 대한 동작들
    // post / 내용 / url
//    @GetMapping("/v2/posts/create")
//    @PostMapping("/v2/posts")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post newPost) {
//        title = 입력받은 title
//        content = 입력받은 content
        System.out.println(newPost.getTitle());
        System.out.println(newPost.getContent());

        String title = newPost.getTitle();
        String content = newPost.getContent();

//        Post post = new Post(++id, "제목", "내용");
        Post post = new Post(++id, title, content);

        posts.add(post);

        return post;
    }

    // read- 전체 조회
    // posts / get
//    @GetMapping("/v2/posts")
//    @GetMapping("/v2/posts")
    @GetMapping
    public List<Post> readPosts() {
        return posts;
    }

    // read- 단일(특정 게시글) 조회
    // posts/{id}
    // {id} 는 리액트에서 :id (동적 라우터)와 같은 의미
//    @GetMapping("/v2/posts/{id}")
    @GetMapping("/{id}")
    public Post readPostById(@PathVariable Long id) {
        // posts에서 post를 가져오자
        for (Post post : posts) {
            if(post.getId().equals(id)) {
                return post;
            }
        }

        // id가 일치하는 게시글이 없는 경우
        return null;
    }

    // update
    // 변경 내용 / id / url
//    @GetMapping("/v2/posts/{id}/update")
//    @PutMapping("/v2/post/{id}")
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post updatePost) {
        String newTitle = updatePost.getTitle();
        String newContent = updatePost.getContent();

        for (Post post : posts) {
            if(post.getId().equals(id)) {
//                post.setTitle("수정된 제목");
//                post.setContent("수정된 내용");
                post.setTitle(newTitle);
                post.setContent(newContent);

                return post;
            }
        }

        return null;
    }

    // delete
    // id / url
//    @DeleteMapping("/v2/posts/{id}")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Post deletePost(@PathVariable Long id) {
        Post removedPost = null;

        for (Post post : posts) {
            if(post.getId().equals(id)) {
                removedPost = post;
                break;
            }
        }

        posts.remove(removedPost);

        return null;
    }

//    @GetMapping("/paged")   // "/paged?key=value&key=value" 형태로 데이터를 받고 싶어서 사용
//    public List<Post> getPagedPosts(@RequestParam String key) {
//        System.out.println(key);
//
//        return posts;
//    }

//    @GetMapping("/paged")
//    public List<Post> getPagedPosts(@RequestParam int page, @RequestParam int size){
//
//        // 1. 페이지네이션을 위한 더미데이터 추가
//        for (int i = 1; i <= 20; i++) {
//            String title = "제목 " + i;
//            String content = "내용 " + i;
//            Post post = new Post(++id, title, content);
//            posts.add(post);
//        }
//
//        // 2. 시작 인덱스와 끝 인덱스 계산
//        int startIndex = (page - 1) * size;
//        int endIndex = Math.min(startIndex + size, posts.size());
//
//        // 3. 페이지에 해당하는 데이터만 추출
//        return posts.subList(startIndex, endIndex);
//    }

    @GetMapping("/paged")
    public List<Post> getPagedPosts(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size){

        // 1. 페이지네이션을 위한 더미데이터 추가
        for (int i = 1; i <= 20; i++) {
            String title = "제목 " + i;
            String content = "내용 " + i;
            Post post = new Post(++id, title, content);
            posts.add(post);
        }

        // 2. 시작 인덱스와 끝 인덱스 계산
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, posts.size());

        // 3. 페이지에 해당하는 데이터만 추출
        return posts.subList(startIndex, endIndex);
    }
}
