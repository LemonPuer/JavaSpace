package demo2;

/**
 * @author Lemon
 * @create 2023-05-09-14:04
 */
public class arrToTree {
    private int[] arr=null;
    public static void main(String[] args) {
        arrToTree at = new arrToTree();
        at.setArr(new int[]{1,2,3,4,5,6,7});
        at.pre(0);
        System.out.println();
        at.mid(0);
        System.out.println();
        at.post(0);
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void pre(int index){
        if(arr!=null||arr.length!=0){
            System.out.print(arr[index]+" ");
        }
        if(index*2+1<arr.length){
            pre(index*2+1);
        }
        if(index*2+2<arr.length){
            pre(index*2+2);
        }
    }

    public void mid(int index){
        if(index*2+1<arr.length){
            mid(index*2+1);
        }
        if(arr!=null||arr.length!=0){
            System.out.print(arr[index]+" ");
        }
        if(index*2+2<arr.length){
            mid(index*2+2);
        }
    }
    public void post(int index){
        if(index*2+1<arr.length){
            post(index*2+1);
        }
        if(index*2+2<arr.length){
            post(index*2+2);
        }
        if(arr!=null||arr.length!=0){
            System.out.print(arr[index]+" ");
        }
    }
}
