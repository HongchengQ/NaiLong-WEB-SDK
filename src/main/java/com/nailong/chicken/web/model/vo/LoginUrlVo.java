package com.nailong.chicken.web.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginUrlVo {
    @JsonProperty("LoginURL")
    String loginUrl;
}
