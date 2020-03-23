package com.huang.algorithmtest.java8test;

/**
 * @author Huangzhanpeng
 * @date 2020/3/19 - 10:09
 */

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * lambda表达式的基础语法，java8中引入了一个新的操作符"->" 该操作符被称为箭头操作符或Lambda操作符
 *                                  箭头操作符将lambda表达式拆分成两部分
 *                                  左侧：lambda表达式的参数列表
 *                                  右侧：lambda表达式中所需执行的功能，即lambda体
 *
 *                                  语法格式一：无参数，无返回值
 *                                  ()->Sysout.out.println("Hello Lambda!");
 *                                  语法格式二：有一个参数，并且无返回值
 *                                  Consumer<String> con = (x) -> System.out.println(x);
*                                   con.accept("我大尚硅谷威武");
 *                                  语法格式三：若只有一个参数，小括号可以省略不写
 *                                  语法格式四： 有两个以上的参数，有返回值，并且lambda体中有多条语句
 *                                    Comparator<Integer> com =(x,y) ->{
 *                                       System.out.println("函数式接口");
 *                                       return Integer.compare(x,y);
 *                                       };
*                                   语法格式五：若lambda体中只有一条语句，return和大括号都可以省略不写
 *
 *                                  语法格式六：lambda表达式的参数列表的数据类型可以省略不写，因为jvm编译器通过上下文推断出数据类型，即“类型推断”
 *                                  上联：左右遇一括号省
 *                                  下联：左侧推测类型省
 *                                  横批：能省则省
 *
 * 二 lambda表达式需要"函数式接口的支持"
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。可以使用@FunctionalInterface修饰
 *      可以检查是否是函数式接口
 *
 *
 *
 *
 */
public class TestLamboda {

    @Test
    public void test1(){

        final int num=0; //jdk1.7以前，必须是final

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world!"+num);
            }
        };

        r.run();
        System.out.println("----------------------------------");

        Runnable r1 = () -> System.out.println("hello lambda!");
        r1.run();

    }
    @Test
    public void test2(){
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("我大尚硅谷威武");
    }
    @Test
    public void test3(){
        Consumer<String> con = x -> System.out.println(x);
        con.accept("我大尚硅谷威武");
    }
    @Test
    public void test4(){
        Comparator<Integer> com =(x,y) ->{
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };

        Comparator<Integer> com2 =(x,y)->Integer.compare(x, y);
    }

    //需求：对一个数进行运算
    @Test
    public void test5(){

        Integer num = operation(100, x -> x * x);
        System.out.println(num);

        System.out.println(operation(200, y->y+200));

    }

    public Integer operation(Integer num,MyFun mf){
        return mf.getValue(num);
    }













}
