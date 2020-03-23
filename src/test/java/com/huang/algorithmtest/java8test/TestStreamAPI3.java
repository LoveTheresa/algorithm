package com.huang.algorithmtest.java8test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import com.huang.algorithmtest.java8test.Employee.Status;
import org.junit.jupiter.api.Test;

import javax.print.attribute.standard.MediaSize;

/**
 * @author Huangzhanpeng
 * @date 2020/3/22 - 15:09
 */
public class TestStreamAPI3 {



    List<Employee> emps = Arrays.asList(
            new Employee(101,"张三",18,999.99, Status.FRES),
            new Employee(102,"李四",59,666.66,Status.BUSY),
            new Employee(103,"王五",28,333.33,Status.VOCATION),
            new Employee(104,"赵六",8,777.77,Status.FRES),
            new Employee(105,"田七",38,555.55,Status.BUSY)

    );


    /**
     * 查找与匹配
     * allMatch---检查是否匹配所有元素
     * anyMatch--检查是否至少匹配一个元素
     * noneMatch--检查是否没有匹配所有元素
     * findFirst--返回第一个元素
     * findAny---返回当前流中的任意元素
     * count--返回流中元素的总个数
     * max---返回流中的最大值
     * min--返回流中的最小值
     */
    /**
     * 归约
     * 将流中元素反复结合起来，得到一个值
     */
    /**
     * 收集
     * collect--将流转换为其他形式，接收一个collector接口实现，用于给stream中元素做汇总的方法
     */


    @Test
    public void test1(){
        boolean b1 = emps.stream().allMatch(e -> e.getStatus().equals(Status.BUSY));
        System.out.println(b1);
    }
    @Test
    public void test2(){
        boolean b1 = emps.stream().anyMatch(e -> e.getStatus().equals(Status.BUSY));
        System.out.println(b1);
    }

    @Test
    public void test3(){
        boolean b1 = emps.stream().noneMatch(e -> e.getStatus().equals(Status.BUSY));
        System.out.println(b1);
    }

    @Test
    public void test4(){
        Optional<Employee> op = emps.stream().sorted((e1, e2) -> -Double.compare(e1.getSalary(), e2.getSalary())).findFirst();
        System.out.println(op.get());
    }

    @Test
    public void test5(){
        //串行找
        Optional<Employee> any = emps.stream().filter(e -> e.getStatus().equals(Status.BUSY)).findAny();
        //并行找
        Optional<Employee> any2 = emps.parallelStream().filter(e -> e.getStatus().equals(Status.BUSY)).findAny();
        System.out.println(any.get());
        System.out.println(any2.get());
    }
    @Test
    public void test6(){
        long count = emps.stream().count();
        System.out.println(count);
    }

    @Test
    public void test7(){
        Optional<Employee> max = emps.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max.get());
        Optional<Employee> min = emps.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min.get());
        Optional<Double> min1 = emps.stream().map(Employee::getSalary).min(Double::compare);
        System.out.println(min1.get());
    }

    @Test
    public void test8(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        System.out.println("---------------------------------------");

        Optional<Double> op = emps.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(op.get());

    }

    @Test
    public void test9(){
        List<String> list = emps.stream().map(Employee::getName).collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
        Set<String> set = emps.stream().map(Employee::getName).collect(Collectors.toSet());
        set.forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
        HashSet<String> hs = emps.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
        hs.forEach(System.out::println);


    }

    @Test
    public void test10(){
        Long count=emps.stream().collect(Collectors.counting());
        System.out.println(count);

        System.out.println("----------------------------------------------------------");
        //平均值
        Double collect = emps.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(collect);
        System.out.println("----------------------------------------------------------");
        //总合
        Double collect1 = emps.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(collect1);
        System.out.println("----------------------------------------------------------");
        //最大值
        Optional<Employee> max = emps.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(max.get());

        System.out.println("----------------------------------------------------------");
        //最小值
        Optional<Double> min = emps.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());


    }

    //分组
    @Test
    public void test11(){
        Map<Status, List<Employee>> map = emps.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }

    //多级分组
    @Test
    public void test12(){
        Map<Status, Map<String, List<Employee>>> collect = emps.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
            if (((Employee) e).getAge() <= 35)
                return "青年";
            else if (((Employee) e).getAge() <= 50) {
                return "中年";
            } else return "老年";
        })));
        System.out.println(collect);


    }

    //分区
    @Test
    public void test13(){
        //true一个区，false一个区
        Map<Boolean, List<Employee>> map = emps.stream().collect(Collectors.partitioningBy((e) -> e.getSalary() > 500));
        System.out.println(map);
    }

    @Test
    public void test14(){
        DoubleSummaryStatistics collect = emps.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect.getAverage());
    }

    @Test
    public void test15(){
        String collect = emps.stream().map(Employee::getName).collect(Collectors.joining(",","***","---"));
        System.out.println(collect);
    }



}
