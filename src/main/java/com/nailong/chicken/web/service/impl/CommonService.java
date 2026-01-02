package com.nailong.chicken.web.service.impl;

import com.nailong.chicken.web.model.dto.AuthorizationDto;
import com.nailong.chicken.web.model.HttpRsp;
import com.nailong.chicken.web.service.ICommonService;
import com.nailong.chicken.web.utils.FileUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CommonService implements ICommonService {
    @Override
    public HttpRsp queryClientCode() throws IOException {
        return FileUtils.readClientCodeFile();
    }

    @Override
    public HttpRsp queryClientConfig(AuthorizationDto authorizationDto) throws IOException {
        AuthorizationDto.Head head = authorizationDto.getHead();
        String region;

        if (head.getPid().equals("CN-NOVA")) {
            if (head.getChannel().equals("bilibili")) {
                region = "bili";
                return FileUtils.readClientConfigFile(region);
            }
            region = "cn";
        } else {
            region = "os";
        }

        return FileUtils.readClientConfigFile(region);
    }

    @Override
    public HttpRsp queryVersion() throws IOException {
        return FileUtils.readClientCommonVersion();
    }
}
