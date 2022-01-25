package com.example.runWith.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateResponse {
    //200 성공 300 에러
    private int responseCode;
}
