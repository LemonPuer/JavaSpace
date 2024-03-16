package controller;

import dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.Employee;

import java.util.Collection;
import java.util.Map;

/**
 * @author Lemon
 * @create 2022-11-14-9:35
 */
@Controller
public class controller {
    @Autowired
    private EmployeeDao eld;
    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String list(Map<String,Object> map){
        Collection<Employee> all = eld.getAll();
        map.put("list",all);
        return "list";
    }
    @DeleteMapping("/employee/{id}")
    public String delete(@PathVariable("id") Integer id){
        eld.delete(id);
        return "redirect:/employee";
    }
    @PostMapping("/employee")
    public String add(Employee emp){
        eld.save(emp);
        return "redirect:/employee";
    }
    @GetMapping("/employee/{id}")
    public String findOne(@PathVariable("id") Integer id,Map<String,Object> map){
        Employee emp = eld.get(id);
        map.put("employee",emp);
        return "update";
    }
    @PutMapping("/employee")
    public String update(Employee emp){
        eld.save(emp);
        return "redirect:/employee";
    }
}
