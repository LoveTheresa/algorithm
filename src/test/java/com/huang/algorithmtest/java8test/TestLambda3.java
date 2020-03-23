package com.huang.algorithmtest.java8test;

/**
 * @author Huangzhanpeng
 * @date 2020/3/19 - 12:41
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8内置的四大核心函数式接口
 *
 * Consumer<T>:消费型接口
 *      void accept(T t)
 * Suplier<T>: 供给型接口
 *      T get();
 * Function<T,R>:函数型接口
 *      R apply(T t);
 * Predicate<T>: 断言型接口
 *      boolean test(T t);
 *
 */
public class TestLambda3 {

    //consumer
    @Test
    public void test1(){
        happy(10000, m-> System.out.println("每次消费："+m+"元"));
    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    //supplier
    //需求：产生一些整数，并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }

        return list;
    }


    @Test
    public void test2(){
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));

        for (Integer integer : numList) {
            System.out.println(integer);
        }

    }

    //-----------------------------------------
    //function<t,r>
    //需求：用于处理字符串
    public String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);
    }
    @Test
    public void test3(){
        String strHandler = strHandler("\t\t\t 我大尚硅谷威武 ", str -> str.trim());
        System.out.println(strHandler);

    }

    //-----------------------------------
    //predicate<T>
    //需求：将满足条件的字符串，接入集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> stringList = new ArrayList<>();

        for (String s : list) {
            if (pre.test(s)){
                stringList.add(s);
            }
        }

        return stringList;

    }

    @Test
    public void test4(){

        List<String> list = Arrays.asList("hello","atguigu","lambda","www","ok");
        List<String> stringList = filterStr(list, s -> s.length() > 3);

        for (String s : stringList) {
            System.out.println(s);
        }

    }







}
