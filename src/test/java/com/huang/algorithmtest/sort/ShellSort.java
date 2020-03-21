package com.huang.algorithmtest.sort;

import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.external.com.google.gdata.util.common.base.Escaper;

/**
 * @author Huangzhanpeng
 * @date 2020/3/20 - 18:06
 */
public class ShellSort {

    @Test
    public void test(){
        int [] numbers =new int[]{78 ,45 ,85,97,87};

        int j=0;
        int temp =0;
        //每次将步长缩短为原来的一半
        for (int increment = numbers.length/2;increment>0;increment/=2){
            for (int i = increment;i<numbers.length;i++){
                temp=numbers[i];
                for (j=i;j>=increment;j-=increment){
                    if (temp>numbers[j-increment]){ //如果想从小到大排只需修改这里
                        numbers[j]=numbers[j-increment];
                    }else {
                        break;
                    }
                }
                numbers[j]=temp;
            }
        }

        for (int number : numbers) {
            System.out.print(number+"\t");
        }
        System.out.println();
    }

}
