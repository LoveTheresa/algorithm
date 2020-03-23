package com.huang.algorithmtest.kaoshi;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Huangzhanpeng
 * @date 2020/3/19 - 18:51
 */
public class test {

    public static void main(String[] args) {

        //取需要多少个数
        Scanner sc = new Scanner(System.in);
        final int t =sc.nextInt();



        List<Integer> x = new ArrayList<>();
        for(int j = 1; j <=t; j++){



            x.add(sc.nextInt());
        }

        //排序
        Collections.sort(x);

        //用一个for循环查找排序好的队伍中相邻中的最大差值
        int sum = 0;
        int zhan;
        if (t>=3){
            zhan =x.get(2)-x.get(0);;
        }else if (t==2){
            zhan = x.get(1)-x.get(0);;
        }else {
            zhan=0;
        }
        sum = zhan;
        for (int i = 3; i < t; i++) {

            if ((t-i)==1){
                zhan=x.get(i)-x.get(i-1);
                if (zhan>sum){
                    sum=zhan;
                }
            }else {
                zhan=x.get(i)-x.get(i-2);
                if (zhan>sum){
                    sum=zhan;
                }
            }


        }

        //输出结果
        System.out.println(sum);

    }

}
