package com.huang.algorithmtest.sort;

import org.junit.jupiter.api.Test;

/**
 * @author Huangzhanpeng
 * @date 2020/3/20 - 12:44
 */
public class InsertSort {

    @Test
    public void test(){
        int [] numbers =new int[]{78 ,45 ,85,97,87};

        int size = numbers.length;
        int temp = 0;
        int  j =0;

        for (int i = 0; i < size; i++) {
            temp = numbers[i];

            for (j=i;j>0&&temp<numbers[j-1];j--){
                numbers[j]=numbers[j-1];
            }
            numbers[j]=temp;
        }




        for (int number : numbers) {
            System.out.print(number+"\t");
        }
        System.out.println();
    }


}
