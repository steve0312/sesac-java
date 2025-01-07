package com.example.jpamini.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 유저 이름 중복 체크
    boolean existsByUserName(String userName);

    // 이메일 중복 체크
    boolean existsByEmail(String email);


    // 특정 닉네임을 가진 사용자 조회
    @Query("SELECT u FROM User u WHERE u.nickName = :nickName")
    List<User> findByNickName(@Param("nickName") String nickName);

    // 특정 나이의 사용자 조회
    @Query("SELECT u FROM User u WHERE u.age = :age")
    List<User> findByAge(@Param("age") Integer age);

    // 활성화된 사용자 조회
    @Query("SELECT u FROM User u WHERE u.isActive = true")
    List<User> findByActive();

    // 이메일이 특정 도메인으로 끝나는 사용자 조회
    @Query("SELECT u FROM User u WHERE u.email LIKE %:email")
    List<User> findByEmailDomain(@Param("email") String domain);

    // 특정 나이 이후의 비활성 사용자 조회
    @Query("SELECT u FROM User u WHERE u.age > :age AND u.isActive = false")
    List<User> findByAfterAgeInActive(@Param("age") Integer age);
}
