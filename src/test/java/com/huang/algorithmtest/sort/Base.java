package com.huang.algorithmtest.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Huangzhanpeng
 * @date 2020/3/20 - 10:28
 */
public class Base {

    @Test
    public void test1(){
        Integer [] scores = new Integer[]{78 ,45 ,85,97,87};

        Arrays.sort(scores);
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i]+"\t");
        }
        System.out.println();

        Arrays.sort(scores, Collections.reverseOrder());
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i]+"\t");
        }
        System.out.println();

    }

    @Test
    public void test(){
        int [] numbers =new int[]{78 ,45 ,85,97,87};


        for (int number : numbers) {
            System.out.print(number+"\t");
        }
        System.out.println();
    }


}
