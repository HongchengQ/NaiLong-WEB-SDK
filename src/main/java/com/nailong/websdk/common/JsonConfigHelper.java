package com.nailong.websdk.common;

import com.nailong.websdk.pojo.HttpRsp;

import java.io.IOException;

import static com.nailong.websdk.utils.FileUtils.fileToObject;

public class JsonConfigHelper {
    /**
     * 读取客户端代码 JSON 文件并转换为 HttpRsp 对象
     *
     * @return HttpRsp 对象，包含 CodeList 数据
     * @throws IOException IO 异常
     */
    public static HttpRsp readClientCodeFile() throws IOException {
        return fileToObject("common/codes/client_code.json", HttpRsp.class);
    }

    public static HttpRsp readClientConfigFile(String region) throws IOException {
        String path = String.format("common/client_configs/client_config_%s.json", region);

        return fileToObject(path, HttpRsp.class);
    }

    public static HttpRsp readClientCommonVersion() throws IOException {
        return fileToObject("common/version.json", HttpRsp.class);
    }
}
