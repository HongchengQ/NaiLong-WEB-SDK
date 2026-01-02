package com.nailong.chicken.web.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GenTokenDto {
    @JsonProperty("AuthPID")
    String authPid;

    @JsonProperty("URL")
    String url;
}
