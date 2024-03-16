package servlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Lemon
 * @create 2022-11-09-16:21
 */
@Controller
public class Index {
//@RequestMapping("/")
//public String index() {
//    return "index";
//}

    @RequestMapping(value = "/target")
    public String target() {
        System.out.println("target运行了");
        return "target";
    }

    @RequestMapping(value = "/target", method = RequestMethod.POST, params = "password!=123456")
    public String targetPost(String user, String password) {
        System.out.println("user:" + user + ",password:" + password);
        return "target";
    }

    @RequestMapping("/mav")
    public ModelAndView success() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", "mav张三");
        mav.setViewName("success");
        return mav;
    }

    //    public String success(HttpServletRequest req) {
//        req.setAttribute("user", "张三");
//        req.getSession().setAttribute("user","李四");
//        req.getSession().getServletContext().setAttribute("user","王五");
//        return "success";
//    }
    @RequestMapping("/model")
    public String model(Model model) {
        model.addAttribute("user", "model张三");
        return "success";
    }

    @RequestMapping("/map")
    public String map(Map<String, Object> map) {
        map.put("user", "map张三");
        return "success";
    }

    @RequestMapping("/mmp")
    public String mmp(ModelMap modelMap) {
        modelMap.addAttribute("user", "mmp张三");
        return "success";
    }

    @RequestMapping("/session")
    public String session(HttpSession hs) {
        hs.setAttribute("user", "李四");
        return "success";
    }

    @RequestMapping("/application")
    public String application(HttpSession hs) {
        hs.getServletContext().setAttribute("user", "王五");
        return "success";
    }

    @RequestMapping("/forward")
    public String forward(HttpSession hs) {
        return "forward:/map";
    }

    @RequestMapping("/redirect")
    public String redirect(){
        System.out.println("调用了");
        return "redirect:static/hello.jsp";
    }
}
