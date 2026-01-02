package com.nailong.chicken.web.service;

import com.nailong.chicken.web.model.dto.AuthorizationDto;
import com.nailong.chicken.web.model.dto.LoginBodyDto;
import com.nailong.chicken.web.model.dto.UserSetDataBodyDto;
import com.nailong.chicken.web.model.po.User;
import com.nailong.chicken.web.model.vo.UserVo;

import java.security.NoSuchAlgorithmException;

public interface IUserService {

    User getAccountFromHeader(AuthorizationDto authorizationDto);

    UserVo<Object> getOrCreateUserResult(LoginBodyDto body) throws NoSuchAlgorithmException;

    int getSetInfoRetCode(AuthorizationDto authorizationDto, UserSetDataBodyDto body);
}
