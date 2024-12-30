package com.example.demo.prac_1230.bean;

import com.example.demo.prac_1226.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    // Post 클래스의 인스턴스, 즉 게시글을 넣음
    List<Post> posts = new ArrayList<>();   // DB를 사용하지 않고 게시글을 하는 방식이라서 List 사용
    private Long id = 0L;   // 게시글 생성에서 id 생성을 위한 장치


    // Create
    // 저장. create 그 자체
    public Post save(Post newPost) {
//        String title = newPost.getTitle();
//        String content = newPost.getContent();
//
//        Post post = new Post(++id, title, content);

        Post post = new Post(++id, newPost.getTitle(), newPost.getContent());
        posts.add(post);

        return post;
    }

    // Read- 전체
    public List<Post> findAll() {
        return posts;
    }

    // Read- 단일
    public Post findById(Long id) {
        for (Post post : posts) {
            if(post.getId().equals(id)) {
                return post;
            }
        }

        return null;
    }

    // Update
    public Post modify(Long id, Post updatedPost) {
        String newTitle = updatedPost.getTitle();
        String newContent = updatedPost.getContent();

        for (Post post : posts) {
            if(post.getId().equals(id)) {
                post.setTitle(newTitle);
                post.setContent(newContent);

                return post;
            }
        }

        return null;
    }

    // Delete
    public void delete(Post post) {
        posts.remove(post);
    }
}
