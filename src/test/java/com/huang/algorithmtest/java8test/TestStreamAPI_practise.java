package com.huang.algorithmtest.java8test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.huang.algorithmtest.java8test.Employee.Status;

/**
 * @author Huangzhanpeng
 * @date 2020/3/22 - 17:19
 */
public class TestStreamAPI_practise {
    /**
     * 1.给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
     */
    @Test
    public void test1(){
        Integer[] nums = {1, 2, 3, 4, 5};

        Arrays.stream(nums).map(x->x*x).forEach(System.out::println);

    }

    /**
     * 怎样用map和reduce方法数一数流中有多少个employee呢？
     */
    List<Employee> emps = Arrays.asList(
            new Employee(101,"张三",18,999.99, Status.FRES),
            new Employee(102,"李四",59,666.66,Status.BUSY),
            new Employee(103,"王五",28,333.33,Status.VOCATION),
            new Employee(104,"赵六",8,777.77,Status.FRES),
            new Employee(105,"田七",38,555.55,Status.BUSY)

    );

    @Test
    public void test2(){
        Optional<Integer> optionalInteger = emps.stream().map(e -> 1).reduce(Integer::sum);
        System.out.println(optionalInteger.get());
    }


}
