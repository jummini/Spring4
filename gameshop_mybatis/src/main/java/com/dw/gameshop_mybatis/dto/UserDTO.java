package com.dw.gameshop_mybatis.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    @Size(min = 4, max = 20, message = "아이디는 4자 이상 20자 이하로 입력해주세요.")
    private String userName;
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}",
         message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;
    @NotBlank(message = "이름은 필수 입력값입니다.")
    private String realName;
    private String role;
}
/*
< 주요 Validation 어노테이션 >
1. 문자열 검증
@NotNull : null 안됨. "" 또는 "    " 가능
@NotEmpty : null과 "" 안됨. "    " 가능
@NotBlank : null, "", "    " 모두 안됨
@Size : 문자열 길이 또는 컬렉션(배열) 크기 제한
@Size(min = 2, max = 50, message = "2자 이상 50자 이하")
@Length : 문자열 길이 제한(문자열에만 사용)
@Length(min = 2, max = 50, message = "2자 이상 50자 이하")

2. 숫자 검증
@Min / @Max : 최소 최대값 검증
@Min(value = 0, message = "나이는 0 이상이어야 합니다")
@Max(value = 100, message = "점수는 100 이하여야 합니다")
@Positive / @PositivOrZero
@Positive(message = "수량은 양수여야 합니다")
@PositiveOrZero(message = "재고는 0 이상이어야 합니다")
@Negative / @NegativeOrZero
@Digits : 숫자의 자릿수 제한
@Digits(integer = 6, fraction = 2,
             message = "가격은 정수 6자리, 소수점 2자리까지 가능합니다")

3. 패턴검증
@Pattern : 정규표현식 패턴 검증
@Pattern(regexp = "^[0-9]{3}-[0-9]{4}-[0-9]{4}$",
            message = "전화번호 형식이 올바르지 않습니다)")
@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
           message = "올바른 이메일 형식이 아닙니다")
@Email : 이메일 형식 검증

4. 날짜 / 시간 검증
@Past / @PastOrPresent : 과거날짜 / 과거 또는 현재 날짜
@Past(message = "생년월일은 과거 날짜여야 합니다")
@PastOrPresent(message = "생성일은 현재 또는 과거 날짜여야 합니다")
@Future / @FutureOrPresent
@Future(message = "예약일은 미래 날짜여야 합니다")
@FutureOrPresent(message = "종료일은 현재 또는 미래 날짜여야 합니다")
* */
