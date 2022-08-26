package com.lnd.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

/**
 * @Author lnd
 * @Description
 * @Date 2022/8/26 14:08
 */
public class Test01 {

    @Test
    public void test(){
        /*
            >> 无格式的 json 字符串
            >> 转换成一个 JSONObject
            >> JSONObject 可以转换成
                >> 1、普通格式的json字符串
                >> 2、漂亮格式的json字符串
        */
        String jsonString = "{\"_index\":\"book_shop\",\"_type\":\"it_book\",\"_source\":{\"date\":\"2007-06-01\",\"author\":\"[美] Bruce Eckel\",\"price\":109.0,\"name\":\"Java编程思想（第4版）\",\"publisher\":\"机械工业出版社\",\"category\":\"编程语言\",\"tags\":[\"Java\",\"编程语言\"]},\"_id\":\"1\",\"_score\":1.0}";
        JSONObject object = JSON.parseObject(jsonString);

        /* 直接解析得到的是普通的 json 字符串*/
        String json = JSON.toJSONString(object);
        System.out.println(json);   // 普通json字符串（未格式化）

        System.out.println("===========================");

        String format = JSON.toJSONString(object, SerializerFeature.PrettyFormat); //漂亮的格式
        System.out.println(format); // 格式化后的json字符串
    }

    /* 执行以上代码，输出结果为：
    --------------------------------------
    {"_index":"book_shop","_type":"it_book","_source":{"date":"2007-06-01","author":"[美] Bruce Eckel","price":109.0,"name":"Java编程思想（第4版）","publisher":"机械工业出版社","category":"编程语言","tags":["Java","编程语言"]},"_id":"1","_score":1.0}

    ===========================

    {
        "_index":"book_shop",
        "_type":"it_book",
        "_source":{
            "date":"2007-06-01",
            "author":"[美] Bruce Eckel",
            "price":109.0,
            "name":"Java编程思想（第4版）",
            "publisher":"机械工业出版社",
            "category":"编程语言",
            "tags":[
                "Java",
                "编程语言"
            ]
        },
        "_id":"1",
        "_score":1.0
    }
    -----------------------------------
    分析：
    */
}
