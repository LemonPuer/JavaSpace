package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;

/**
 * @author Lemon
 * @create 2022-11-15-11:30
 */
@Controller
public class myController {
    @RequestMapping("/ResponseBody")
    @ResponseBody
    public User test1(String name,Integer age){
        System.out.println(name+"_"+age);
        return new User(1,"john",23);
    }
}
