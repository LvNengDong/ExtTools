package com.lnd.stringutils;


import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.apache.commons.text.StringEscapeUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Author lnd
 * @Description
 *      org.apache.commons.text.StringEscapeUtils
 *      作用：“转义”或“取消转义” Java、Js、Html和 Xml 类型的字符串。
 * @Date 2022/8/25 23:25
 */
public class StringEscapeUtilsTest {
    /**
     *  增加转义字符，如果需要转义的话
     */
    @Test
    public void escapeJava() throws IOException {
        CharSource source = Files.asCharSource(new File("src/main/resources/a.txt"), StandardCharsets.UTF_8);
        String inputString = source.read(); // He didn't say, "Stop!"
        System.out.println(inputString);
        //String inputString = "He didn't say, Stop!";
        String outputString = StringEscapeUtils.escapeJava(inputString);
        System.out.println(outputString);
    }

    /**
     *  消除转义字符
     */
    @Test
    public void unescapeJavaDemo() {
        String inputString = "He didn't say, \"Stop!\"";
        System.out.println(inputString); // He didn't say, "Stop!"
        String outputString = StringEscapeUtils.unescapeJava(inputString);
        System.out.println(outputString); // He didn't say, "Stop!"
    }

    /**
     * 消除转义字符
     */
    @Test
    public void Demo() {
        String inputString = "{\n" +
                "  \"name\": \"Jack\",\n" +
                "  \"age\": 18,\n" +
                "  \"gender\": \"男\"\n" +
                "}";
        System.out.println(inputString);
        String outputString = StringEscapeUtils.unescapeJson(inputString);
        System.out.println(outputString);
    }
}
