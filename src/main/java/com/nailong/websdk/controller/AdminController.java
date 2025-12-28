package com.nailong.websdk.controller;

import com.nailong.websdk.domain.dto.UserInput;
import com.nailong.websdk.domain.po.User;
import com.nailong.websdk.domain.po.UserDraft;
import com.nailong.websdk.proto.Pb;
import com.nailong.websdk.utils.AeadHelper;
import com.nailong.websdk.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.babyfish.jimmer.sql.JSqlClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin", method = {RequestMethod.GET, RequestMethod.POST})
@RequiredArgsConstructor
public class AdminController {

    private final JSqlClient sqlClient;

    @RequestMapping(path = "/decode_server_list")
    public Object decodeServerList(@RequestParam String region, @RequestBody byte[] body) throws Exception {
        IO.println(Utils.bytesToHex(body));
        byte[] serverListBytes = AeadHelper.decryptCBC(body, region);

        return Pb.ServerListMeta.parseFrom(serverListBytes).toString();
    }

    @RequestMapping(path = "/test")
    public String test() {
        UserInput userInput = new UserInput.Builder()
                .openId("111")
                .password("111")
                .nickName("111")
                .loginToken("111")
//                .createdAt(0L)
                .build();
        User book = UserDraft.$.produce(draft -> draft
                .setOpenId("222")
                .setPassword("222")
                .setNickName("222")
                .setLoginToken("222")
//                .setCreatedAt(0L)
        );

        System.out.println(saveUserInput(userInput));
        System.out.println(saveUser(book));

        return "test";
    }

    public long saveUser(User user) {
        return sqlClient
                .getEntities()
                .save(user)
                .getModifiedEntity()
                // 如果`user.id`为null，返回自动分配的id
                .id();
    }

    public long saveUserInput(UserInput user) {
        return sqlClient
                .getEntities()
                .save(user)
                .getModifiedEntity()
                // 如果`user.id`为null，返回自动分配的id
                .id();
    }
}
