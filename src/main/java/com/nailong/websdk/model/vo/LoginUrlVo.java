package com.nailong.websdk.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginUrlVo {
    @JsonProperty("LoginURL")
    String loginUrl;
}
