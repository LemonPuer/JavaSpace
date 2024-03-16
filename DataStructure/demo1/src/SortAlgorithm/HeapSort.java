package SortAlgorithm;


import java.util.Arrays;

/**
 * @author Lemon
 * @create 2023-05-16-9:39
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 8, 5, 9, -1, 90, 89, 56, -999};
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        //temp用于交换；count用于计算循环次数；node用于记录节点序号
        int temp, count, node;
        for (count = 0; count <= arr.length - 1; count++) {
            //这里是计算剩余元素中的非叶子节点
            node = (arr.length - count) / 2 - 1;
            while (node >= 0) {
                if (node * 2 + 1 < (arr.length - count) && arr[node] < arr[node * 2 + 1]) {
                    temp = arr[node];
                    arr[node] = arr[node * 2 + 1];
                    arr[node * 2 + 1] = temp;
                }
                if (node * 2 + 2 < (arr.length - count) && arr[node] < arr[node * 2 + 2]) {
                    temp = arr[node];
                    arr[node] = arr[node * 2 + 2];
                    arr[node * 2 + 2] = temp;
                }
                //第一个非叶子节点序号之前的节点都是非叶子节点
                node--;
            }
            temp = arr[0];
            arr[0] = arr[(arr.length - count) - 1];
            arr[(arr.length - count) - 1] = temp;
        }
    }
}
