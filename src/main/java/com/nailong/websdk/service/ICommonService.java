package com.nailong.websdk.service;

import com.nailong.websdk.pojo.Authorization;
import com.nailong.websdk.pojo.HttpRsp;

public interface ICommonService {
    HttpRsp queryClientCode();
    HttpRsp queryClientConfig(Authorization authorization);

    HttpRsp queryVersion();
}
