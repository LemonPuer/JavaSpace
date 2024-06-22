package f_1;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Lemon
 * @create 2022-09-25-15:12
 */
public class UDPTest {

@Test
public void Test() {
    try (DatagramSocket ds = new DatagramSocket(8080)) {
        byte[] a = "你好！".getBytes();
        DatagramPacket dp = new DatagramPacket(a, 0, a.length, InetAddress.getLocalHost(), 8989);
        ds.send(dp);
        ds.receive(dp);
        System.out.println(new String(dp.getData(), 0, dp.getLength()));
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    @Test
    public void Test1() {
        try (DatagramSocket ds = new DatagramSocket(8989)) {
            byte[] a = new byte[100];
            DatagramPacket dp = new DatagramPacket(a, 0, a.length);
            ds.receive(dp);
            System.out.println(new String(dp.getData(), 0, dp.getLength()));
            dp = new DatagramPacket("Hello!".getBytes(), 0, "Hello!".length(), InetAddress.getLocalHost(), 8080);
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
