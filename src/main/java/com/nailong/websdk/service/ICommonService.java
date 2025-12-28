package com.nailong.websdk.service;

import com.nailong.websdk.domain.Authorization;
import com.nailong.websdk.domain.HttpRsp;

import java.io.IOException;

public interface ICommonService {
    HttpRsp queryClientCode() throws IOException;

    HttpRsp queryClientConfig(Authorization authorization) throws IOException;

    HttpRsp queryVersion() throws IOException;
}
