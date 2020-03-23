package com.huang.algorithmtest.java8test;

/**
 * @author Huangzhanpeng
 * @date 2020/3/19 - 14:19
 */

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * 方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”
 * （可以理解为方法引用时lambda表达式的另外一种表现形式）
 *
 * 主要有三种语法格式：
 *(注意:Lambda 体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的参数列表和返回值类型保持一致！)
 *(若lambda参数列表中的第一参数是实力方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method)
 *
 * 对象：：实例方法名
 *
 * 类：：静态方法名
 *
 * 类：：实例方法名
 *
 * 二。构造器引用
 * ClassName::New
 * 注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致
 *
 *
 * 三、数组引用
 * Type::new;
 *
 */
public class TestMethodRef {




    @Test
    public void test1(){
        Consumer<String> consumer = x -> System.out.println(x);

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;

        Consumer<String> con2 = System.out::println;
        con2.accept("alfsdf");

    }

    @Test
    public void test2(){

        Employee employee = new Employee();

        Supplier<String> supplier = () ->employee.getName();
        String str = supplier.get();
        System.out.println(str);

        Supplier<Integer> sup2= employee::getAge;
        Integer num = sup2.get();
        System.out.println(num);
    }

    //类：：静态方法名
    @Test
    public void test3(){
        Comparator<Integer> comparator = (x,y) ->Integer.compare(x, y);

        Comparator<Integer> comparator1 = Integer::compare;

    }

    //类：：实例方法名
    @Test
    public void test4(){
        BiPredicate<String,String> biPredicate = (x,y) ->x.equals(y);

        BiPredicate<String,String> biPredicate1=String::equals;

    }

    //构造器引用
    @Test
    public void test5(){
        Supplier<Employee> supplier = () ->new Employee();

        //构造器引用方式
        Supplier<Employee> supplier1=Employee::new;
        Employee employee = supplier1.get();
        System.out.println(employee); //自动匹配无参构造器

    }

    @Test
    public void test6(){
        Function<Integer,Employee> function = x->new Employee(x);

        Function<Integer,Employee> function1 = Employee::new;
        Employee apply = function1.apply(101);//匹配id的构造器
        System.out.println(apply);

        BiFunction<Integer,Integer,Employee> biFunction =Employee::new;

    }
    @Test
    public void test7(){
        Function<Integer,String[]> function=x->new String[x];
        String[] strs = function.apply(10);
        System.out.println(strs.length);

        Function<Integer,String[]> function1 = String[]::new;
        String[] str2 = function1.apply(20);
        System.out.println(str2.length);

    }



}
