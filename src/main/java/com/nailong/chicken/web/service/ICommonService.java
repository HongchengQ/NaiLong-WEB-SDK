package com.nailong.chicken.web.service;

import com.nailong.chicken.web.model.dto.AuthorizationDto;
import com.nailong.chicken.web.model.HttpRsp;

import java.io.IOException;

public interface ICommonService {
    HttpRsp queryClientCode() throws IOException;

    HttpRsp queryClientConfig(AuthorizationDto authorizationDto) throws IOException;

    HttpRsp queryVersion() throws IOException;
}
