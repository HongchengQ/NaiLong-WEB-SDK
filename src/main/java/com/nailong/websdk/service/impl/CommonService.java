package com.nailong.websdk.service.impl;

import com.nailong.websdk.common.JsonConfigHelper;
import com.nailong.websdk.pojo.Authorization;
import com.nailong.websdk.pojo.HttpRsp;
import com.nailong.websdk.service.ICommonService;
import com.nailong.websdk.utils.RspToJsonUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Log4j2
public class CommonService implements ICommonService {
    @Override
    public HttpRsp queryClientCode() {
        HttpRsp rsp;
        try {
            rsp = JsonConfigHelper.readClientCodeFile();
        } catch (IOException e) {
            rsp = RspToJsonUtils.error("发生 IO 异常", e);
        }

        return rsp;
    }

    @Override
    public HttpRsp queryClientConfig(Authorization authorization) {
        HttpRsp rsp;
        String region;

        Authorization.Head head = authorization.getHead();
        String pid = head.getPID();
        String channel = head.getChannel();

        switch (pid) {
            case "CN-NOVA" -> {
                if (channel.equals("bilibili")) {
                    region = "bili";
                    break;
                }
                region = "cn";
            }
            case "" -> {
                // 只是为了不让 idea 警告
                return null;
            }
            default -> region = "os";
        }

        try {
            rsp = JsonConfigHelper.readClientConfigFile(region);
        } catch (IOException e) {
            rsp = RspToJsonUtils.error("发生 IO 异常", e);
        }

        return rsp;
    }

    @Override
    public HttpRsp queryVersion() {
        HttpRsp rsp;

        try {
            rsp = JsonConfigHelper.readClientCommonVersion();
        } catch (IOException e) {
            rsp = RspToJsonUtils.error("发生 IO 异常", e);
        }

        return rsp;
    }
}
