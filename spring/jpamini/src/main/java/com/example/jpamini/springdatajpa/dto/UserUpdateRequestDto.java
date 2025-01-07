package com.example.jpamini.springdatajpa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {
    // Validation Check
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
}
