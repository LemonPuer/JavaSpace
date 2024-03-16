package workspace;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/10/15 13:42:21
 */
@EnableScheduling
@SpringBootApplication
@MapperScan("workspace.mapper")
public class MapStructRun {
    public static void main(String[] args) {
        SpringApplication.run(MapStructRun.class, args);
    }
}