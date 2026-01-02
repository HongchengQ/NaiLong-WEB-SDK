package com.nailong.chicken.web.controller.official;

import com.nailong.chicken.web.model.HttpRsp;
import com.nailong.chicken.web.model.dto.AuthorizationDto;
import com.nailong.chicken.web.service.ICommonService;
import com.nailong.chicken.web.utils.AeadHelper;
import com.nailong.chicken.web.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping(value = "/common", method = {RequestMethod.GET, RequestMethod.POST})
@RequiredArgsConstructor
public class CommonController {

    private final ICommonService commonService;

    @RequestMapping(path = "/config")
    public HttpRsp config(@RequestHeader("Authorization") String authHeader) throws IOException {
        return commonService.queryClientConfig(AuthorizationDto.parseStrToObject(authHeader));
    }

    @RequestMapping(path = "/client-code")
    public HttpRsp clientCode() throws IOException {
        return commonService.queryClientCode();
    }

    @RequestMapping(path = "/version")
    public HttpRsp version() throws IOException {
        return commonService.queryVersion();
    }

    @RequestMapping(path = "/test")
    public byte[] test(@RequestHeader("Authorization") String authHeader) throws Exception {
        String sign = AuthorizationDto.parseStrToObject(authHeader).getSign();
        byte[] signBytes = Base64.getDecoder().decode(sign);

        IO.println(Utils.bytesToHex(signBytes));

        return AeadHelper.decryptCBC(signBytes, "cn");
    }

}