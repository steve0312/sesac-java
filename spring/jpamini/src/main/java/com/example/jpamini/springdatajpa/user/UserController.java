package com.example.jpamini.springdatajpa;

import com.example.jpamini.springdatajpa.dto.UserCreateRequestDto;
import com.example.jpamini.springdatajpa.dto.UserListResponseDto;
import com.example.jpamini.springdatajpa.dto.UserResponseDto;
import com.example.jpamini.springdatajpa.dto.UserUpdateRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // Create
    // POST method / url / data
    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDto>> createUser(@Valid @RequestBody UserCreateRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok(
                        "게시글이 정상적으로 작성되었습니다.",
                        "CREATED",
                        userService.createUser(requestDto)
                ));
    }


    // Read- 전체
    // GET mehtod / url / 전체
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserListResponseDto>>> readUsers() {
        return ResponseEntity.ok(
                ApiResponse.ok(userService.readUsers())
        );
    }

    // Read- 단일
    // GET method / url / id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> readUserById(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.ok(userService.readUserById(id))
        );
    }

    // 특정 닉네임을 가진 사용자 조회
    @GetMapping("/search-by-nickname")
    public ResponseEntity<ApiResponse<List<UserResponseDto> >> readUserByNickName(@RequestParam String nickName) {
        return ResponseEntity.ok(
                ApiResponse.ok(userService.readUserByNickName(nickName))
        );
    }

    // 특정 나이의 사용자 조회
    @GetMapping("/search-by-age")
    public ResponseEntity<ApiResponse<List<UserResponseDto> >> readUserByAge(@RequestParam Integer age) {
        return ResponseEntity.ok(
                ApiResponse.ok(userService.readUserByAge(age))
        );
    }

    // 활성화된 사용자 조회
    @GetMapping("/search-active-users")
    public ResponseEntity<ApiResponse<List<UserResponseDto>>> readUserByActive() {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        userService.readUserByActive()
                )
        );
    }

    // 이메일이 특정 도메인으로 끝나는 사용자 조회
    @GetMapping("/search-by-email-domain")
    public ResponseEntity<ApiResponse<List<UserResponseDto>>> readUserByEmailDomain(@RequestParam String domain) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        userService.readUserByEmailDomain(domain)
                )
        );
    }

    // 특정 나이 이후의 비활성 사용자 조회
    @GetMapping("/search-after-age-inactive")
    public ResponseEntity<ApiResponse<List<UserResponseDto>>> readUserByAfterAgeInActive(@RequestParam Integer age) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        userService.readUserByAfterAgeInActive(age)
                )
        );
    }


    // Update
    // PUT method / url / id + updateData
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequestDto requestDto) {
        return ResponseEntity.ok(
                ApiResponse.ok(userService.updateUser(id, requestDto))
        );
    }


    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);

        return ResponseEntity.ok(
                ApiResponse.ok(
                        "게시글이 정상적으로 삭제되었습니다.",
                        "DELETED",
                        null
                )
        );
    }
}
