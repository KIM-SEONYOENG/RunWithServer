package com.example.runWith.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
<<<<<<< HEAD
    //login 200(로그인 완료) 300(로그인 실패) 400(회원 없음)
    //join 200(성공) 300(중복된 회원) 400(실패)
=======
    //result code 200(로그인 완료) 300(로그인 실패) 400(회원 없음)
>>>>>>> 4d1b047 (Login)
    private int resultCode;
    private String message;
}
