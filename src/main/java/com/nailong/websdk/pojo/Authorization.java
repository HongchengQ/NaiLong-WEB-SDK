package com.nailong.websdk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authorization {
    private Head Head;
    private String Sign;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Head {
        private String PID;
        private String Channel;
        private String Platform;
        private String Lang;
        private String DeviceID;
        private String Version;
        private String GVersionNo;
        private String GBuildNo;
        private String RID;
        private String DeviceModel;
        private long Time;
    }
}
