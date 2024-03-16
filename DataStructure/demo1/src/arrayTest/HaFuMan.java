package arrayTest;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author Lemon
 * @create 2023-05-16-20:46
 */
public class HaFuMan {
    public static void main(String[] args) {
//        int[] arr={13,7,8,3,29,6,1};
//        ArrayList<HFMNode> nodes = new ArrayList<>();
//        for (int a : arr) {
//            nodes.add(new HFMNode(a));
//        }
//        HFMNode node = haFuManTree(arr);
//        pre(node);
        byte[] bytes = hFMZip("i like like like java do you like a java".getBytes(StandardCharsets.UTF_8));
        System.out.println(Arrays.toString(bytes));
        byte[] bytes1 = unZip(hashRoad, bytes);
        System.out.println(new String(bytes1));
    }

    public static byte[] unZip(Map<Byte, String> hashCode, byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        //1.首先需要将压缩后的bytes数组转换回二进制
        for (byte b : bytes) {
            //只有最后一个字节不需要补高位
            sb.append(change(!(b == bytes[bytes.length - 1]), b));
        }
        //2.将哈夫曼编码表反转
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> e : hashCode.entrySet()) {
            map.put(e.getValue(), e.getKey());
        }
        //3.将字符串转为byte
        //用于存放转换的byte
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < sb.length(); ) {
            int count = 1;//i前进的步长
            boolean flag = true;
            Byte b=null;
            while (flag) {
                String st = sb.substring(i, i+count);
                b = map.get(st);
                if (b != null) {//匹配到一个
                    flag=false;
                } else
                    count++;
            }
            list.add(b);
            i+=count;
        }
        byte[] result=new byte[list.size()];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }

    //将byte转为二进制字符串
    private static String change(boolean flag, byte b) {
        int a = b;
        if (flag) {//判断是否需要补高位，防止出现1（byte）转换后为“1”
            a |= 256;
        }
        //底层都是使用补码存储，如-4原码是1000 0100，但实际存储为1111 1100；
        String str = Integer.toBinaryString(a);
        if (flag) {
            return str.substring(str.length() - 8);
        } else
            return str;
    }

    public static byte[] hFMZip(byte[] bytes) {
        Map<Byte, Integer> map = new HashMap<>();
        for (byte i : bytes) {
            if (map.get(i) != null) {
                map.put(i, map.get(i) + 1);
            } else map.put(i, 1);
        }
        ArrayList<HFMNode> nodes = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            nodes.add(new HFMNode(entry.getKey(), entry.getValue()));
        }
        //创建哈夫曼树
        HFMNode hfmNode = haFuManTree(nodes);
        road(hfmNode, "", new StringBuilder());
        StringBuilder sb = new StringBuilder();
        //转换哈夫曼编码
        for (byte i : bytes) {
            sb.append(hashRoad.get(i));
        }
//        System.out.println(sb);
        //压缩后的字节数组，长度*8要>=字符串的长度
        byte[] result = new byte[(sb.length() + 7) / 8];
        //数组下标的计数器
        int index = 0;
        for (int i = 0; i < sb.length(); i += 8) {
            if (i + 8 <= sb.length()) {
                result[index++] = (byte) Integer.parseInt(sb.substring(i, i + 8), 2);
            } else result[index++] = (byte) Integer.parseInt(sb.substring(i), 2);
        }
        return result;
    }

    //用于记录各个字母对应字节的路径，即哈夫曼编码
    static Map<Byte, String> hashRoad = new HashMap<>();

    public static void road(HFMNode node, String code, StringBuilder stb) {
        StringBuilder stb2 = new StringBuilder(stb);
        stb2.append(code);
        if (node != null) {
            if (node.data == null) {//不是叶子节点
                road(node.left, "0", stb2);
                road(node.right, "1", stb2);
            } else hashRoad.put(node.data, stb2.toString());
        }
    }

    public static void pre(HFMNode node) {
        if (node != null) {
            node.preOut(node);
        } else System.out.println("is null");
    }

    public static HFMNode haFuManTree(List<HFMNode> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            HFMNode node = new HFMNode(nodes.get(0).val + nodes.get(1).val);
            node.left = nodes.get(0);
            node.right = nodes.get(1);
            nodes.remove(1);
            nodes.remove(0);
            nodes.add(node);
        }
        return nodes.get(0);
    }
}

class HFMNode implements Comparable<HFMNode> {
    Byte data;
    int val;
    HFMNode left;
    HFMNode right;

    public HFMNode() {
    }

    public HFMNode(int val) {
        this.val = val;
    }

    public HFMNode(byte data, int val) {
        this.data = data;
        this.val = val;
    }

    public void preOut(HFMNode node) {
        System.out.println(node);
        if (node.left != null) preOut(node.left);
        if (node.right != null) preOut(node.right);
    }

    @Override
    public String toString() {
        return "HFMNode{" + "data=" + data + ", val=" + val + '}';
    }

    @Override
    public int compareTo(HFMNode o) {
        return this.val - o.val;
    }
}
