package com.huang.algorithmtest.java8test;

/**
 * @author Huangzhanpeng
 * @date 2020/3/19 - 15:51
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一。string的三个操作步骤
 * 1.创建stream
 *
 * 2.中间操作
 *
 * 3.终止操作（终端操作）
 *
 *
 */
public class TestStreamAPI1 {

    //创建Stream
    @Test
    public void test1(){
        //1.可以通过collection系列集合提供的stream()
        // 或
        // paralleStream()

        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2.通过arrays中静态方法stream获取数组流
        Employee[] employee = new Employee[10];
        Stream<Employee> stream2 =  Arrays.stream(employee);

        //3.通过stream中的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        //4.创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
//        stream4.forEach(System.out::println);
//        stream4.limit(10).forEach(System.out::println);

        //生成
//        Stream.generate(()->Math.random()).limit(5).forEach(System.out::println);


    }

}
