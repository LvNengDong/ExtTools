package com.lnd.stringutils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @Author lnd
 * @Description
 *  org.apache.commons.lang3.StringUtils
 *
 * @Date 2022/8/25 22:51
 */
public class StringUtilsTest {


    /**
     * IsEmpty/IsBlank
     * 作用：判断一个字符串是否包含文本
     */
    @Test
    public void Demo() {
        //StringUtils
    }

    /**
     * Trim/Strip
     * 删除前导和尾随空白
     */
    @Test
    public void Demo1() {

    }

    /**
     * Equals/Compare
     * 以null安全的方式比较两个字符串
     */
    @Test
    public void Demo3() {

    }

    /**
     * startsWith 检查 CharSequence 是否以指定的前缀开始
     * endsWith 检查 CharSequence 是否以指定的后缀结束
     * 这两个方法都是 null安全的方法
     */
    @Test
    public void startsWith_or_endsWith() {
        String str = "Hello World";
        String subStartStr = "Hello";
        String subEndStr = "Hello";
        String nullStr = null;

        boolean b = StringUtils.startsWith(str, subStartStr);
        System.out.println(b); // true

        boolean b2 = StringUtils.endsWith(str, subEndStr);
        System.out.println(b2); // false

        boolean b3 = StringUtils.startsWith(str, nullStr);
        System.out.println(b3); // false
        boolean b4 = StringUtils.startsWith(nullStr, nullStr);
        System.out.println(b4); // true
        /*
            所谓的null安全就是指：待比较的两个字符串可以为null，并且不会
            抛出空指针异常
        */
    }

    /**
     *  indexOf >> 找到子字符串在父字符串中的第一个位置（可以处理null值）
     *  lastIndexOf >> 找到子字符串在父字符串中的最后一个位置（可以处理null值）
     *  contains >> 顾名思义，是否包含，也可以处理null值
     */
    @Test
    public void indexOf_or_lastIndexOf_or_contains() {
        String str = "====哈哈哈*****";
        String searchStr = "哈";
        String searchStr2 = "哈哈";
        String searchStr3 = "嘿嘿";
        int index = StringUtils.indexOf(str, searchStr);
        System.out.println(index); //4
        int index2 = StringUtils.indexOf(str, searchStr2);
        System.out.println(index2); //4
        int index3 = StringUtils.indexOf(str, searchStr3);
        System.out.println(index3); //-1
        int index4 = StringUtils.indexOf(str, null);
        System.out.println(index4); //-1

        int lastIndex = StringUtils.lastIndexOf(str, searchStr2);
        System.out.println(lastIndex); //5

        boolean b = StringUtils.contains(str, null);
        System.out.println(b); //false
    }
}
