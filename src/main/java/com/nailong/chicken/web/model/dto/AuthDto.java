package com.nailong.chicken.web.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@NotNull(message = "请求体不能为空")
public class AuthDto {
    @JsonProperty("Account")
    @NotNull(message = "参数: Account 不能为空")
    public String account;

    @JsonProperty("Code")
    @NotNull(message = "参数: Code 不能为空")
    public String code;
}
