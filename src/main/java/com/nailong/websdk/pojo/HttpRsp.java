package com.nailong.websdk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpRsp {
    private int Code;
    private Object Data;
    private String Msg;

    @Override
    public String toString() {
        return "HttpRsp{" +
                "Code=" + Code +
                ", Data=" + Data +
                ", Msg='" + Msg + '\'' +
                '}';
    }
}
