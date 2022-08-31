package com.lnd.jacksonjson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.lnd.domain.Car;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author lnd
 * @Description 暂无
 * @Date 2022/8/31 23:55
 */
public class Demo01 {

    /*
        ObjectMapper 可以从 `字符串`， `流` 或 `文件` 中解析JSON
        Object映射器可以将JSON解析为自定义的类的对象，也可以解析置JSON树模型的对象。

        之所以称为ObjectMapper是因为它将JSON映射到Java对象（反序列化），或者将Java对象映射到JSON（序列化）
     */
    private final ObjectMapper objectMapper = new ObjectMapper();

    String carJson ="{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
    String jsonArray = "[\n" +
            "  {\n" +
            "    \"brand\" : \"Mercedes\",\n" +
            "    \"doors\" : 5\n" +
            "  },\n" +
            "  {\n" +
            "    \"brand\" : \"Fiat\",\n" +
            "    \"doors\" : 3\n" +
            "  }\n" +
            "]";

    /**
     * 将Json转换为Car对象
     */
    @Test
    public void test01() throws IOException {

        Car car = objectMapper.readValue(carJson, Car.class);
        System.out.println(car);
    }

    /*
        默认情况下，Jackson通过将JSON字段的名称与Java对象中的getter和setter方法进行匹配，将JSON对象的字段映射到Java对象中的属性。 Jackson删除了getter和setter方法名称的“ get”和“ set”部分，并将其余名称的第一个字符转换为小写。
        如果需要以其他方式将JSON对象字段与Java对象字段匹配，则需要使用自定义序列化器和反序列化器，或者使用一些Jackson注解。
    */

    /**
     *
     */
    @Test
    public void test02() throws IOException {
        StringReader reader = new StringReader(carJson);
        Car car = objectMapper.readValue(reader, Car.class);
        System.out.println(car);
    }

    /**
     *
     */
    @Test
    public void test03() throws IOException {
        File file = new File("src/test/resources/car.json");
        System.out.println(objectMapper.readValue(file, Car.class));
    }



    /**
     * Jackson ObjectMapper也可以从JSON数组字符串读取对象数组。 这是从JSON数组字符串读取对象数组的示例：
     */
    @Test
    public void test04() throws IOException {
        Car[] cars = objectMapper.readValue(jsonArray, Car[].class);
        Arrays.stream(cars).forEach(System.out::println);
    }

    @Test
    public void test05() throws IOException {
        TypeReference<List<Car>> typeReference = new TypeReference<List<Car>>() {};
        Car[] cars = objectMapper.readValue(jsonArray, typeReference);
        Arrays.stream(cars).forEach(System.out::println);
    }

    /*
    Jackson ObjectMapper还可以从JSON字符串读取Java Map。 如果事先不知道将要解析的确切JSON结构，这种方法是很有用的。

    */
    @Test
    public void test06() throws IOException {
        Map<String,Object> jsonMap = objectMapper.readValue(carJson, new TypeReference<Map<String,Object>>(){});
        for (String key : jsonMap.keySet()) {
            System.out.print("key: " + key + "     ");
            System.out.println("value: " + jsonMap.get(key));
        }

        int i = Integer.parseInt(null);
        //Java中的基本数据类型不能为null值，但其包装类型可以为null
    }

    /**
     *
     */
    @Test
    public void test07() throws IOException {


        SimpleModule module = new SimpleModule("CarDeserializer", new Version(3, 1, 8, null, null, null));
        module.addDeserializer(Car.class, new CarDeserializer(Car.class));

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);

        Car car = mapper.readValue(carJson, Car.class);
        System.out.println(car);
    }
}
