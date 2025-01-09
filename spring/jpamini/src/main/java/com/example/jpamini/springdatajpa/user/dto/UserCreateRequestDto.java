package com.example.jpamini.springdatajpa.dto;

import com.example.jpamini.springdatajpa.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Getter
@NoArgsConstructor
public class UserCreateRequestDto {
    // Validation Check
    @NotBlank(message = "유저 이름이 null일 수 없습니다.")
    @Length(min = 3, max = 20, message = "이름은 3자 이상 20자 이하여야 합니다.")
    private String userName;

    @NotBlank(message = "이메일은 null일 수 없습니다.")
    @Email
    private String email;

    @NotBlank(message = "닉네임은 null일 수 없습니다.")
    @Length(min = 2, max = 10, message= "닉네임은 2자 이상 10자 이하여야 합니다.")
    private String nickName;

    @Range(min = 0, max = 150, message = "나이는 0에서 150 사이여야 합니다.")
    private Integer age;

    @NotNull(message = "활동 여부는 null일 수 없습니다.")
    private Boolean isActive;

    // 유저를 생성할 때 save 메서드를 사용하려면 RequestDTO가 아닌 엔티티 데이터를 전달해야돼서 변환하기 위한 메서드
    // UserCreateRequestDto -> 엔티티
    public User toEntity() {
        return User.builder()
                .userName(this.userName)
                .email(this.email)
                .nickName(this.nickName)
                .age(this.age)
                .isActive(this.isActive)
                .build();
    }
}
