package Picture;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Lemon
 * @create 2023-05-23-16:57
 */
public class Picture {
    public static void main(String[] args) {
        Picture picture = new Picture(8);
        String[] temp=new String[]{"1","2","3","4","5","6","7","8"};
        for(int i=0;i<temp.length;i++){
            picture.add(temp[i]);
        }
        picture.addEdge(0, 1, 1);
        picture.addEdge(0, 2, 1);
        picture.addEdge(4, 1, 1);
        picture.addEdge(3, 1, 1);
        picture.addEdge(3, 7, 1);
        picture.addEdge(4, 7, 1);
        picture.addEdge(2, 5, 1);
        picture.addEdge(2, 6, 1);
        picture.addEdge(5, 6, 1);
        for (int i = 0; i < picture.arr.length; i++) {
            for (int j = 0; j < picture.arr[i].length; j++) {
                System.out.print(picture.arr[i][j] + " ");
            }
            System.out.println();
        }
        //深度优先遍历
        picture.dff();
        System.out.println();
        //广度优先遍历
        picture.bfs();
    }

    //此二维数组用于存储各端点之间的连接关系
    int[][] arr;
    //集合用于存储各端点的值
    List<String> list = new ArrayList<>();
    //记录边的个数
    int edgeSum;

    public Picture(int num) {
        arr = new int[num][num];
    }

    public void bfs() {
        boolean[] isRead = new boolean[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (!isRead[i])
                bfs(isRead, i);
        }
    }

    private void bfs(boolean[] isRead, int num) {
        //用于记录需要遍历的行号
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(num);
        System.out.print(list.get(num) + "=>");
        isRead[num] = true;
        //tail是当前遍历的行号；next是遍历到的列号
        int tail, next;
        while (!queue.isEmpty()) {
            tail = queue.removeFirst();
            next = findNext(tail, 0);
            while (next != -1) {
                if (!isRead[next]) {
                    System.out.print(list.get(next) + "=>");
                    isRead[next] = true;
                    queue.addLast(next);
                }
                next = findNext(tail, next);
            }
        }
    }

    public void dff() {
        //用于记录结点是否已经访问过了
        boolean[] isRead = new boolean[list.size()];
        for (int i = 0; i < list.size(); i++) {
            dff(isRead, i);
        }
    }

    private void dff(boolean[] arr, int start) {
        if (!arr[start]) {
            System.out.print(list.get(start) + "->");
            //该节点已访问
            arr[start] = true;
        }
        int next = findNext(start, start);
        while (next != -1) {//说明有直连的下一个节点
            if (!arr[next]) {
                dff(arr, next);
            }
            next = findNext(start, next);
        }
    }

    //查询num结点从start（不含）开始的第一个结点
    private int findNext(int num, int start) {
        for (int i = start + 1; i < arr[num].length; i++) {
            if (arr[num][i] > 0)
                return i;
        }
        return -1;
    }

    //添加结点
    public void add(String point) {
        list.add(point);
    }

    /**
     * description 添加边长以及权值
     *
     * @param first  第一个端点的序号
     * @param second 第二个端点的序号
     * @param weight 边的的权值
     * @return void
     * @author Lemon
     * @date 2023/5/23 17:33
     * @version 1.0.0
     */
    public void addEdge(int first, int second, int weight) {
        arr[first][second] = weight;
        arr[second][first] = weight;
        edgeSum++;
    }
}
