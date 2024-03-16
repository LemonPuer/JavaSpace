package arrayTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author Lemon
 * @create 2022-12-06-16:09
 */
public class Little {
    public static void main(String[] args) {
        try {
            Reader r=new FileReader("arrTest.txt");
            int read = r.read(new char[1024]);
            System.out.println(read);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
