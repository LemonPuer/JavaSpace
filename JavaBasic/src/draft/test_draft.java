package draft;

import org.junit.Test;

import java.util.Arrays;
/**
 * @author Lemon
 * @create 2022-10-08-9:42
 */
public class test_draft {
    public static void main(String[] arg) {
//        int a = 0;
//        label:
//        for (int i = 2; i <= 100; i++) {
//            for (int j = 2; j < i; j++) {
//                if (i % j == 0) {
//                    a = 1;
//                    break;//break可以改为continue label
//                }
//            }
//            if (a == 0) {
//                System.out.print(i + " ");
//            }
//            a=0;
//        }
//求100以内的质数
//        label:
//        for (int i = 2; i <= 100; i++) {
//            for (int j = 2; j < i / 2; j++) {
//                if (i % j == 0) continue label;
//            }
//            System.out.print(i + "  ");
//        }
//二分法查找：要求此数组必须是有序的。
//int[] arr = new int[]{-99, -54, -2, 0, 2, 33, 43, 256, 999};
        int[] arr = new int[]{98, 97, 65, 45, 78, 23, 12, 49};
for (int i = 0; i < arr.length - 1; i++) {
    for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
    }
}
Arrays.fill(arr,13);
        System.out.println(Arrays.toString(arr));
//        for (Integer i : arr) {
//            System.out.println(i);
//        }
//boolean isFlag = true;
//int number = 256;
//int head = 0;//首索引位置
//int end = arr.length - 1;//尾索引位置
//while(head<=end){
//    int middle=(head+end)/2;
//    if(number==arr[middle]){
//        System.out.println("找到了指定的元素，位置为："+middle);
//        isFlag=false;
//        break;
//    }else if(arr[middle]>number){
//        end=middle-1;
//    }else{//arr2[middle] < number
//        head=middle+1;
//    }
//}
//if(isFlag){
//    System.out.println("未找打指定的元素");
//}
    }
    @Test
    public void test1(){
        int[] a=new int[100];
        for (int i = 0; i <100; i++) {
            a[i]=i+1;
        }
        for (int i = 0; i < 100; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
