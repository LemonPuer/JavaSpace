package workspace.controller;


import cn.hutool.core.io.resource.ClassPathResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import workspace.domain.Courses;
import workspace.domain.CoursesVO;
import workspace.service.CoursesService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 培训课程 前端控制器
 * </p>
 *
 * @author Lemon
 * @since 2023-10-15
 */
@Slf4j
@RestController
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    private CoursesService coursesService;
    @Autowired
    private JavaMailSender javaMailSender;
    // @Autowired
    // private MyCacheUtils myCacheUtils;

    @GetMapping("/list")
    public List<CoursesVO> getList() {
        return coursesService.filledList();
    }

    @GetMapping("/{id}")
    public Courses getCourse(@PathVariable("id") Long id) {
        return coursesService.getById(id);
    }

    @GetMapping("/change/{id}/{name}")
    public List<Courses> change(@PathVariable("id") Long id, @PathVariable("name") String name) {
        List<Courses> result = new ArrayList<>();
        result.add(coursesService.getById(id));
        coursesService.changeName(id, name);
        result.add(coursesService.getById(id));
        return result;
    }

    @GetMapping("email")
    public ResponseEntity<String> senEmail() {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("lemonpuer@foxmail.com");
            //"自动化 熊博"<774117739@qq.com>;
            helper.setTo("774117739@qq.com");
            helper.setBcc("lemonpuer@foxmail.com");
            helper.setSubject("您 Steam 愿望单上的 消逝的光芒2 正在特卖！");
            helper.setText(readHtmlFile(), true);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(500).body("发送失败！");
        }
        return ResponseEntity.ok("成功发送！");
    }

    private String readHtmlFile() throws IOException {
        // 使用 ClassPathResource 读取文件内容
        ClassPathResource resource = new ClassPathResource("classpath:test.html");
        File file = resource.getFile();
        // 读取文件内容
        byte[] bytes = Files.readAllBytes(file.toPath());
        return new String(bytes, StandardCharsets.UTF_8);
    }
    // @Scheduled(cron = "0/5 * * * * ? ")
    // public void scheduledTest1() throws Exception {
    //     List<Courses> courses = myCacheUtils.getCourseCache().get("test");
    //     log.error("获取到缓存1的数据长度{}", courses.size());
    //     List<Courses> haha = myCacheUtils.getAsyncCourseCache().get("haha").get();
    //     log.error("获取到异步缓存1的数据长度{}", haha.size());
    //     List<Courses> courses1 = myCacheUtils.getCourseCache2().get("courses");
    //     log.error("获取到缓存2的数据长度{}", courses1.size());
    // }
    //
    // @Scheduled(cron = "0/5 * * * * ? ")
    // public void scheduledTest2() throws Exception {
    //     List<Courses> haha = myCacheUtils.getAsyncCourseCache().get("enen").get();
    //     log.error("获取到异步缓存1的数据长度{}", haha.size());
    //     List<Courses> courses1 = myCacheUtils.getCourseCache2().get("courses");
    //     log.error("获取到缓存2的数据长度{}", courses1.size());
    // }
    //
    // @Scheduled(cron = "0/5 * * * * ? ")
    // public void scheduledTest3() throws Exception {
    //     List<Courses> xixi = myCacheUtils.getAsyncCourseCache2().get("xixi").get();
    //     log.error("获取到异步缓存2的数据长度{}", xixi.size());
    // }
}
