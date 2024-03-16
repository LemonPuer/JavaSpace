import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import workspace.MapStructRun;
import workspace.domain.Courses;
import workspace.domain.CoursesVO;
import workspace.service.CoursesService;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/11/12 20:08:08
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MapStructRun.class)
public class SpringCacheTest {
    @Autowired
    private CoursesService coursesService;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void test2() {
        redisTemplate.opsForValue().set("hello", "hi");
        System.out.println(redisTemplate.opsForValue().get("hello"));
    }

    @Test
    public void testCache() {
        if (coursesService != null) {
            List<CoursesVO> coursesVOS = null;
            for (int i = 0; i < 3; i++) {
                coursesVOS = coursesService.filledList();
            }
            log.info("coursesVOS:{}", coursesVOS);
        } else {
            log.info("coursesService is null");
        }
    }

    @Test
    public void test1() throws InterruptedException {
        System.out.println(coursesService.findById(18L));
        System.out.println(coursesService.filledList());
        coursesService.update(new CoursesVO().setId(19L).setCode("hi"));
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(coursesService.findById(18L));
        System.out.println(coursesService.filledList());
    }
}
