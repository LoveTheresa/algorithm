package com.huang.algorithmtest.sort;

/**
 * @author Huangzhanpeng
 * @date 2020/3/20 - 11:17
 */
public class QuickSort {


    /**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     * @param numbers 带查找数组
     * @param low 开始位置
     * @param high 结束位置
     * @return 中轴所在位置
     */
    public static int getMiddle(int[] numbers,int low,int high){
        int temp = numbers[low]; //数组第一个作为中轴
        while (low<high){
            while (low<high&&numbers[high]>=temp){
                high--;
            }
            numbers[low]=numbers[high]; //比中轴小的记录移到低端
            while (low<high&&numbers[low]<temp){
                low++;
            }
            numbers[high]=numbers[low];

        }
        numbers[low] = temp; //中轴记录到尾
        return low;
    }

    /**
     * 递归形式的分治排序算法
     * @param numbers 待排序数组
     * @param low 开始位置
     * @param high 结束位置
     */
    public static void quickSort(int[] numbers,int low,int high){
        if (low<high){
            int middle = getMiddle(numbers, low, high); //将numbers数组进行一分为二
            quickSort(numbers, low, middle-1); //对低字段表进行递归排序
            quickSort(numbers, middle+1, high); //对高字段表进行递归排序
        }
    }

    /**
     * 快速排序
     * @param numbers 待排序数组
     */
    public static void quick(int[] numbers){
        if (numbers.length>0){ //查看数组是否为空
            quickSort(numbers, 0, numbers.length-1);
        }
    }

    /**
     * 打印函数
     * @param numbers
     */
    public static void printArr(int[] numbers){
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]+",");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] numbers = {10,20,15,0,6,7,2,1,-5,55};
        System.out.print("排序前：");
        printArr(numbers);

        quick(numbers);
        System.out.print("快速排序后：");
        printArr(numbers);
    }






}




