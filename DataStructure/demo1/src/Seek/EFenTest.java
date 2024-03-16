package Seek;

import java.util.Arrays;

/**
 * @author Lemon
 * @create 2023-05-01-19:32
 */
public class EFenTest {
    public static void main(String[] args) {
        int[] temp = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
//        int seek = Seek(temp, 0, temp.length - 1, 9);
//        int seek = ChaZhi(temp, 0, temp.length - 1, 1);
        int seek=fbnqSeek(temp,1);
        System.out.println(seek);
    }

    public static int Seek(int[] arr, int begin, int end, int target) {
        if (begin > end) {
            return -1;
        }
        int middle = (begin + end) / 2;
        if (arr[middle] > target) {//左递归
            return Seek(arr, begin, middle - 1, target);
        } else if (arr[middle] < target) {//右递归
            return Seek(arr, middle + 1, end, target);
        } else {
            return middle;
        }
    }

    public static int ChaZhi(int[] arr, int begin, int end, int target) {
        //这里的优化是必须的，防止当target的值太大时arr[middle]下标越界
        if (begin > end || target < arr[0] || target > arr[arr.length - 1]) {
            return -1;
        }
        int middle = begin + (target - begin) / (end - begin);
        if (arr[middle] > target) {//左递归
            return Seek(arr, begin, middle - 1, target);
        } else if (arr[middle] < target) {//右递归
            return Seek(arr, middle + 1, end, target);
        } else {
            return middle;
        }
    }

    private static int[] fbnq(int length) {
        int[] temp = new int[length];
        temp[0] = 1;
        temp[1] = 1;
        for (int i = 2; i < length - 1; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }
        return temp;
    }

    public static int fbnqSeek(int[] arr, int target) {
        int[] fbnq = fbnq(20);
        int k = 0;
        while (target >= fbnq[k]) {
            k++;
        }
        int[] temp = arr;
        if (arr.length < fbnq[k]) {
            temp = Arrays.copyOf(arr, fbnq[k]);
        }
        for (int i = arr.length; i < temp.length; i++)
            temp[i] = arr[arr.length - 1];
        int middle = 0;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            //因为f[k]-1=f[k-1]-1+f[k-2]-1+1,则长度为k的数组就可以分为f[k-1]-1和f[k-2]-1两段
            middle = low + fbnq[k - 1] - 1;
            if (target > temp[middle]) {
                low = middle + 1;
                //这里是数组右侧的前半段，即下一次循环的前半段：middle=low+f[k-1-2]-1;
                k -= 2;
            } else if (target < temp[middle]) {
                high = middle - 1;
                //这里是数组左侧的前半段，即下一次循环的前半段：middle=low+f[k-1-1]-1;
                k--;
            }else
                return middle;
        }
        return -1;
    }
}
