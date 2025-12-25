package com.nailong.websdk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    /*
        getApp().post("/user/detail", new UserLoginHandler());
        getApp().post("/user/set", new UserSetDataHandler());
        getApp().post("/user/set-info", new UserSetDataHandler()); // CN
        getApp().post("/user/login", new UserLoginHandler());
        getApp().post("/user/quick-login", new UserLoginHandler());
        getApp().post("/user/send-sms", new HttpJsonResponse("{\"Code\":200,\"Data\":{},\"Msg\":\"OK\"}"));
     */

    @GetMapping
    public String get(String key, String value) {
        if (value == null) {
            IO.println();
            return "test";
        }
        return "666" + key;
    }

}
