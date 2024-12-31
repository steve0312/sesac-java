package com.example.demo.prac_1231.myjpasitev2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepositoryJpaV2 {
    @PersistenceUnit
    private final EntityManagerFactory emf;

    public PostJpaV2 save(PostJpaV2 post) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            // 트랜잭션 시작 (데이터베이스와 소통하기 위해 시작)
            tx.begin();
            // 영속성 컨테스트에 저장
            em.persist(post);
            // 성공한 경우 커밋
            tx.commit();
            return post;
        } catch(Exception e) {
            // 실패한 경우 롤백
            tx.rollback();
            throw e;
        } finally {
            // 모든 작업이 끝난 후 영속성 컨텍스트를 종료
            em.close();
        }
    }

    public PostJpaV2 findById(Long id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(PostJpaV2.class, id);
        } finally {
            em.close();
        }
    }

    public List<PostJpaV2> findAll() {
        EntityManager em = emf.createEntityManager();
        // post에서 모든 데이터를 가져오고 싶다.
        // SELECT * FROM posts p
        // JPQL 문법 (테이블을 엔티티로 대체)
        try {
            return em.createQuery("SELECT p from PostJpaV3 p", PostJpaV2.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public PostJpaV2 update(Long id, PostJpaV2 updatedPost) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            // 업데이트할 entity를 가져온다.
            PostJpaV2 post = em.find(PostJpaV2.class, id);

            String title = updatedPost.getTitle();
            String content = updatedPost.getContent();

            // 수정한다.
            post.update(title, content);

            tx. commit();

            return post;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            PostJpaV2 post = em.find(PostJpaV2.class, id);
            em.remove(post);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
