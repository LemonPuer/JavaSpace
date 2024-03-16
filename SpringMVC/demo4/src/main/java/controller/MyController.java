package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Lemon
 * @create 2022-11-16-21:32
 */
@Controller
public class MyController {
    @RequestMapping("/login")
    public String test(){
        return "login";
    }
}
