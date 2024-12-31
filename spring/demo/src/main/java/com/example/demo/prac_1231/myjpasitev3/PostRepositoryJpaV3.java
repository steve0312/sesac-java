package com.example.demo.prac_1231.myjpasitev3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepositoryJpaV3 {
    private final EntityManager em;

    // Create
    public PostJpaV3 save(PostJpaV3 post) {
        em.persist(post);

        return post;
    }

    // Read- 전체
    public List<PostJpaV3> findAll() {
        return em.createQuery("SELECT p FROM PostJpaV3 p", PostJpaV3.class)
                .getResultList();
    }

    // Read- 단일
    public PostJpaV3 findById(Long id) {
        return em.find(PostJpaV3.class, id);
    }

    // Update
    public PostJpaV3 update(Long id, PostJpaV3 updatedPost) {
        PostJpaV3 post = em.find(PostJpaV3.class, id);

        String newTitle = updatedPost.getTitle();
        String newContent = updatedPost.getContent();

        post.update(newTitle, newContent);

        return post;
    }

    // Delete
    public void delete(Long id) {
        PostJpaV3 post = em.find(PostJpaV3.class, id);

        em.remove(post);
    }
}