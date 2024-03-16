package SortAlgorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Lemon
 * @create 2023-02-11-17:39
 */
public class EasySort {
    public static void main(String[] args) {
        EasySort es = new EasySort();
//        int arr[]=new int[]{1,2,3,4,5,8,7,6};
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = new Random().nextInt(arr.length * 10);
        }
//        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
//        es.MaoPao(arr);
        es.quick(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("程序运行所花费的时间为：" + (end - start));
//        System.out.println(Arrays.toString(arr));
    }

    //冒泡:每一次遍历都会选出一个最大的数
    public void MaoPao(int[] arr) {
        int temp;
        boolean isChange = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    isChange = true;
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
            if (isChange) {
                isChange = false;
            } else break;
        }
    }

    //选择:一次遍历得到最小的一个数
    public void select(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < temp) {
                    temp = arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
    }

    //插入
    public void insert(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp < arr[j]) {
                    arr[j + 1] = arr[j];
                    arr[j] = temp;//防止j=0时还未排序
                } else {
                    arr[j + 1] = temp;
                    break;
                }
            }
//            System.out.printf("第%d次\n%s\n", i, Arrays.toString(arr));
        }
    }

    //希尔：交换法,思路有点像分组的冒泡
    public void shellChange(int[] arr) {
        int temp;
        //组内序号跨越的步数
        for (int steps = arr.length / 2; steps > 0; steps /= 2) {
            for (int i = steps; i < arr.length; i++) {
                for (int j = i - steps; j >= 0; j -= steps) {
                    if (arr[j] > arr[j + steps]) {
                        temp = arr[j];
                        arr[j] = arr[j + steps];
                        arr[j + steps] = temp;
                    }
                }
            }
            System.out.printf("steps=%d\n%s\n", steps, Arrays.toString(arr));

        }
    }

    //插入（移动）法
    public void shell(int[] arr) {
        int temp;
        int j;
        for (int steps = arr.length / 2; steps > 0; steps /= 2) {
            for (int i = steps; i < arr.length; i++) {
                j = i;
                temp = arr[i];
                while (j - steps >= 0 && arr[j - steps] > temp) {
                    arr[j] = arr[j - steps];
                    j -= steps;
                }
                arr[j] = temp;
            }
            System.out.printf("steps=%d\n%s\n", steps, Arrays.toString(arr));
        }
    }

    //快速排序
    public void quick(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int middle = (right+left)/2;
        int temp;
        while(l<r){
            while(arr[l]<arr[middle])
                l++;
            while(arr[r]>arr[middle])
                r--;
            if(l>=r)
                break;
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            if(arr[l]==arr[middle])
                r--;
            if(arr[r]==arr[middle])
                l++;
        }
        if(r==l){
            r--;
            l++;
        }
        if(r>left)
            quick(arr,left,r);
        if(l<right)
            quick(arr,l,right);
    }
}