package SortAlgorithm;

import java.util.Arrays;

/**
 * @author Lemon
 * @create 2023-05-01-11:18
 */
public class OtherSort {
    public static void main(String[] args) {
//        int[] result = new int[]{8, 6, 7, 5, 4, 2, 1, 3};
//        int[] temp = new int[result.length];
//        guiBin(result, 0, result.length - 1, temp);
//        System.out.println(Arrays.toString(result));
        int[] result=new int[]{5,4,3,5,1,2};
        jiShu(result);
    }

    //拆分+合并
    public static void guiBin(int[] result, int begin, int end, int[] temp) {
        if (begin < end) {
            int middle = (begin + end) / 2;
            //左递归拆分
            guiBin(result, begin, middle, temp);
            //右递归拆分
            guiBin(result, middle + 1, end, temp);
            //递归到最小后会向上进行合并
            merge(result, begin, middle, end, temp);
        }
    }

    //合并;因为合并的有可能只是一小段，所以需要end参数限定
    public static void merge(int[] result, int begin, int middle, int end, int[] temp) {
        int l = begin;
        int r = middle + 1;
        int t = 0;
        //第一部分；左右两边开始比较添加进temp
        while (l <= middle && r <= end) {
            if (result[l] > result[r]) {
                temp[t] = result[r];
                r++;
                t++;
            } else {
                temp[t] = result[l];
                l++;
                t++;
            }
        }
        //第二部分；判断是否有一侧未比较完（过大有剩余）
        while (l <= middle) {
            temp[t] = result[l];
            l++;
            t++;
        }
        while (r <= end) {
            temp[t] = result[r];
            r++;
            t++;
        }
        //第三部分；将排序好的部分放回num数组
        t = 0;
        int num = begin;
        while (num <= end) {
            result[num] = temp[t];
            t++;
            num++;
        }
    }
    public static void jiShu(int[] result){
        //十个一维数组作为桶
        int[][] tong=new int[10][result.length];
        //一个一维数组记录十个桶中存储的值
        int[] count=new int[10];
        //先求出最大数值的位数,即大循环的次数
        int max=0;
        for(int i:result){
            if(i>max)
                max=i;
        }
        max=(max+"").length();
        int temp;
        for(int i=0,n=1;i<max;i++,n*=10){
            //将数据都存入桶中
            for(int j=0;j<result.length;j++){
                temp=result[j]/n%10;
                tong[temp][count[temp]]=result[j];
                count[temp]+=1;
            }
            //将桶中数据都放回数组
            temp=0;
            for(int j=0;j<10;j++){
                if(count[j]!=0){
                    for(int k=0;k<count[j];k++){
                        result[temp]=tong[j][k];
                        temp++;
                    }
                    //避免干扰下一次循环
                    count[j]=0;
                }
            }
            System.out.println("第"+(i+1)+"次:"+Arrays.toString(result));
        }
    }
}
