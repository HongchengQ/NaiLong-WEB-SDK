package com.nailong.chicken.web.service.impl;

import com.nailong.chicken.web.dao.UserRepository;
import com.nailong.chicken.web.model.dto.AuthDto;
import com.nailong.chicken.web.model.po.User;
import com.nailong.chicken.web.model.vo.GameMotherAuthVo;
import com.nailong.chicken.web.service.IGameMotherService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.security.NoSuchAlgorithmException;

@Service
public class GameMotherUserService extends UserService implements IGameMotherService {

    public GameMotherUserService(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public GameMotherAuthVo getAuth(AuthDto body) throws NoSuchAlgorithmException {
        User user = getOrCreateUserFromBody(body);

        if (user == null) return null;

        String token = user.loginToken();

        if (ObjectUtils.isEmpty(token)) {
            token = generateLoginToken(user);
        }

        return GameMotherAuthVo.builder()
                .uid(user.openId())
                .token(token)
                .account(user.openId())
                .build();
    }

    private User getOrCreateUserFromBody(AuthDto body) {
        String openId = body.getAccount();

        User user = userRepository.queryUserByOpenId(openId);

        if (user == null) {
            // 创建账号
            user = userRepository.createUser(openId, null, null);
        }

        return user;
    }
}
