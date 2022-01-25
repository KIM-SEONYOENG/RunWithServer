package com.example.runWith.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    //result code 200(로그인 완료) 300(로그인 실패) 400(회원 없음)
    private int resultCode;
    private String message;
}
