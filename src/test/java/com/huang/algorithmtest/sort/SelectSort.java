package com.huang.algorithmtest.sort;

import org.junit.jupiter.api.Test;

/**
 * @author Huangzhanpeng
 * @date 2020/3/20 - 12:32
 */
public class SelectSort {

    @Test
    public void test(){
        int [] numbers =new int[]{78 ,45 ,85,97,87};

        int size=numbers.length; //数组长度
        int temp =0; //中间变量

        for (int i = 0; i < size; i++) {
            int k = i; //待确定的位置
            //选择出应该在第i个位置的数
            for (int j=size-1;j>i;j--) {
                if (numbers[j]<numbers[k]){
                    k=j;
                }
            }
            //交换两个数
            temp = numbers[i];
            numbers[i]=numbers[k];
            numbers[k]=temp;

        }


        for (int number : numbers) {
            System.out.print(number+"\t");
        }
        System.out.println();
    }


}
