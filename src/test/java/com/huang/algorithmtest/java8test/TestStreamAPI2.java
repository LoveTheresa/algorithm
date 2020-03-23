package com.huang.algorithmtest.java8test;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;


/**
 * @author Huangzhanpeng
 * @date 2020/3/22 - 10:29
 */
public class TestStreamAPI2 {

    List<Employee> emps = Arrays.asList(
            new Employee(101,"张三",18,999.99),
            new Employee(102,"李四",59,666.66),
            new Employee(103,"王五",28,333.33),
            new Employee(104,"赵六",8,777.77),
            new Employee(105,"田七",38,555.55),
            new Employee(105,"田七",38,555.55),
            new Employee(105,"田七",38,555.55)

    );

    //中间操作
    /**
     * 筛选与切片
     * filter---接收lambda，从流中排除某些元素
     * limit---截断流，使其元素不超过给定元素。
     * skip(n)---跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流，与limit(n)互补
     * distinct---筛选，通过流所生成元素的hashcode()和equals()去除重复元素
     */

    /**
     * 映射
     * map---接收lambda，将元素转换成其他形式或提取信息，接收一个函数作为参数，该函数会被应用到每一个元素上，并将其映射成一个新元素。
     * flatMap--接收一个函数作为参数，将流中的每个值都换成另一个流，然后将所有流连接成一个流
     */
    /**
     * 排序
     * sorted()---自然排序(comparable)
     * sorted(Comparator com)---定制排序(comparator)
     */
    @Test
    public void test7(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "eee","ddd");

        list.stream().sorted().forEach(System.out::println);

        System.out.println("---------------------------------------------");
        /**
         * //返回 对象集合以类属性一降序 属性二升序 注意两种写法
         *
         * list.stream().sorted(Comparator.comparing(类::属性一).reversed().thenComparing(类::属性二));//先以属性一升序,升序结果进行属性一降序,再进行属性二升序
         *
         * list.stream().sorted(Comparator.comparing(类::属性一,Comparator.reverseOrder()).thenComparing(类::属性二));//先以属性一降序,再进行属性二升序
         *
         */


        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println("---------------------------------------------");


        emps.stream().sorted((e1,e2)->{
            if ((e1.getAge())>(e2.getAge())) {
                return e1.getName().compareTo(e2.getName());
            }else {
                return (e1.getAge())>(e2.getAge())?e1.getAge()-e2.getAge():e2.getAge()-e1.getAge();
            }
        }).forEach(System.out::println);


    }


    @Test
    public void test5(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd","eee");

        list.stream().map(str->str.toUpperCase()).forEach(System.out::println);

        System.out.println("---------------------------------------------");
        emps.stream().map(Employee::getName).forEach(System.out::println);
        System.out.println("---------------------------------------------");
//
//        Stream<Stream<Character>> stream = list.stream().map(TestStreamAPI2::filterChacter);
//
//        stream.forEach(sm->{
//            sm.forEach(System.out::println);
//        });

        System.out.println("---------------------------------------------");

        Stream<Character> sm = list.stream().flatMap(TestStreamAPI2::filterChacter);
        sm.forEach(System.out::println);


    }

    public static Stream<Character> filterChacter(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character character : str.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }

    @Test
    public void test6(){

    }




    //内部迭代，迭代操作由stream api完成
    @Test
    public void test1(){
        //中间操作，不会执行任何操作
        Stream<Employee> s = emps.stream().filter(e ->{
            System.out.println("stream api 的中间操作");
            return  e.getAge() > 35;
        });
        //终止操作，一次性执行全部内容，即惰性求值
        s.forEach(System.out::println);
    }

    //外部迭代
    @Test
    public void test2(){
        Iterator<Employee> iterator = emps.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3(){
        emps.stream().filter(e->{
            System.out.println("短路"); //&& ||
                return e.getSalary()>500;
                }).limit(2).forEach(System.out::println);
    }

    @Test
    public void test4(){
        emps.stream().filter(e->e.getSalary()>500).skip(2).distinct().forEach(System.out::println);
    }



}
