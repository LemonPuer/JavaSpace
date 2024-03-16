package arrayTest;

/**
 * @author Lemon
 * @create 2022-12-06-16:32
 */
public class Duilie {
    public static void main(String[] args) {

    }
}

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int arr[];

    public ArrayQueue(int max) {
        maxSize = max;
        front = -1;//指向队列头的前一个位置
        rear = -1;//指向队列最后一个数据
        arr = new int[max];
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队尾
    public void add(int n) {
        if (isFull()) {
            System.out.println("队列已满!");
            return;
        }
        rear++;//先后移
        arr[rear] = n;
    }

    //取出数据
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空!");
        }
        front++;//先后移
        return arr[front];
    }

    //显示所有数据
    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空!");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

class CircleQueue {
    private int maxSize;
    private int front;//指向队列的第一个元素
    private int rear;//指向队列最后一个元素的后一个位置
    private int arr[];

    public CircleQueue(int max) {
        maxSize = max;
        arr = new int[max];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void add(int n) {
        if (isFull()) {
            System.out.println("队列已满!");
            return;
        }
        arr[rear] = n;
        //当rear指向最后一个数据时需要考虑循环指向arr[0]
        rear = (rear + 1) % maxSize;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空!");
        }
        int value = arr[front];
        //当front指向最后一个数据时需要考虑循环指向arr[0]
        front = (front + 1) % maxSize;
        return value;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空!");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            //i有可能大于maxSize，防止数组越界
            System.out.println(arr[i % maxSize]);
        }
    }

    //返回队列中有效数据的个数
    private int size() {
        return (rear + maxSize - front) % maxSize;
    }
}