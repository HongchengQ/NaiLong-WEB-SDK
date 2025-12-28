package com.nailong.websdk.controller;

import com.nailong.websdk.dao.TestRepository;
import com.nailong.websdk.pojo.entity.dto.BookInput;
import com.nailong.websdk.proto.Pb;
import com.nailong.websdk.utils.AeadHelper;
import com.nailong.websdk.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.babyfish.jimmer.sql.JSqlClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

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
        BookInput bookInput = new BookInput();
        bookInput.setId(666L);
        bookInput.setName("test");
        bookInput.setEdition(1);
        bookInput.setPrice(BigDecimal.valueOf(1.9));
        bookInput.setStoreId(2L);

        System.out.println(saveBook(bookInput));

        return "test";
    }

    public long saveBook(BookInput input) {
        return sqlClient
                .getEntities()
                .save(input)
                .getModifiedEntity()
                // 如果`input.id`为null，返回自动分配的id
                .id();
    }
}
