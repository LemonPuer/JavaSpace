package bootQuartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/10/04 19:08:16
 */
@Service
public class MyService {
    @Scheduled(fixedRate = 1000)
    public void test(){
        System.out.println("Hello!");
    }
}
