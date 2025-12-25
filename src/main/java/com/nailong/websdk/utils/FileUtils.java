package com.nailong.websdk.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.nailong.websdk.utils.JsonUtils.jsonToObject;

public class FileUtils {
    /**
     * 使用 Spring 提供的 ClassPathResource 获取文件内容
     * <p>
     * 备注：jar包可用
     *
     * @param fileName 路径 + 文件名
     * @return BufferedReader 字符流
     * @throws IOException IO 异常
     */
    public static BufferedReader getFileBuffer(String fileName) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(fileName);
        InputStream inputStream = classPathResource.getInputStream();
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    /**
     * 获取文件字符内容
     *
     * @param fileName 路径 + 文件名
     * @return 文件内容
     * @throws IOException IO 异常
     */
    public static String getFileStr(String fileName) throws IOException {
        BufferedReader file = getFileBuffer(fileName);
        return file.readAllAsString();
    }

    /**
     * 将 JSON 文件转换为对象
     *
     * @param fileName 路径 + 文件名
     * @param clazz    目标类类型
     * @return 对象实例
     * @throws IOException IO 异常
     */
    public static <T> T fileToObject(String fileName, Class<T> clazz) throws IOException {
        String jsonStr = getFileStr(fileName);

        return jsonToObject(jsonStr, clazz);
    }
}
