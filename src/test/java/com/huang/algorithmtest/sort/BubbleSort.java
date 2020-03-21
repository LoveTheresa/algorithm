package com.huang.algorithmtest.sort;

import org.junit.jupiter.api.Test;

/**
 * @author Huangzhanpeng
 * @date 2020/3/20 - 10:54
 */
public class BubbleSort {

    @Test
    public void test1(){
        int [] scores = new int[]{78 ,45 ,85,97,87};
        int temp=0;
        int size =scores.length;
        for (int i =0;i<size-1;i++){
            for (int j=0;j<size-i-1;j++){
                if (scores[j]>scores[j+1]){
                    //交换两数的位置

                    temp = scores[j];
                    scores[j]=scores[j+1];
                    scores[j+1]=temp;

                }
            }
        }
        for (int score : scores) {
            System.out.println(score);
        }


    }


}
