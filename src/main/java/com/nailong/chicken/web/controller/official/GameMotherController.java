package com.nailong.chicken.web.controller.official;

import com.nailong.chicken.web.config.AppProperties;
import com.nailong.chicken.web.model.HttpRsp;
import com.nailong.chicken.web.model.dto.AuthDto;
import com.nailong.chicken.web.model.dto.GenTokenDto;
import com.nailong.chicken.web.model.vo.GameMotherAuthVo;
import com.nailong.chicken.web.model.vo.LoginUrlVo;
import com.nailong.chicken.web.service.IGameMotherService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(value = "/yostar", method = {RequestMethod.GET, RequestMethod.POST})
@RequiredArgsConstructor
public class GameMotherController {

    private final AppProperties appProperties;
    private final IGameMotherService gameMotherService;

    @RequestMapping(path = "/get-auth")
    public HttpRsp getAuth(@Validated @RequestBody AuthDto body) throws NoSuchAlgorithmException {
        GameMotherAuthVo AuthVo = gameMotherService.getAuth(body);
        if (AuthVo == null) {
            return HttpRsp.error(100403, "Error");
        }

        return HttpRsp.ok(AuthVo);
    }

    @RequestMapping(path = "/gen-token")
    public HttpRsp genToken(GenTokenDto genTokenDto) {
        LoginUrlVo toolBoxUrl = new LoginUrlVo(appProperties.getToolBoxUrl());

        return HttpRsp.ok(toolBoxUrl);
    }


    @RequestMapping(path = "/send-code")
    public HttpRsp sendCode() {
        return HttpRsp.ok();
    }
}
