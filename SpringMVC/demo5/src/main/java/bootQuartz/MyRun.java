package bootQuartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/10/04 18:08:10
 */
@EnableScheduling
@SpringBootApplication
public class MyRun {
    public static void main(String[] args) {
        SpringApplication.run(MyRun.class, args);
    }
}
