package ra.acedemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.acedemy.model.Student;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    @RequestMapping({"/",""})
    public String dashboard(){
        return "redirect:/student";
    }
    @RequestMapping({"/category",""})
    public String category(){
        return "admin/category";
    }
    @RequestMapping({"/product",""})
    public String product(){
        return "admin/product";
    }
    @RequestMapping({"/user",""})
    public String user(){
        return "admin/user";
    }
    @RequestMapping("/demo")
    public String demo(Model model){
        model.addAttribute("name","Nguyen van A");
        model.addAttribute("age",21);
        model.addAttribute("gen",true);
        model.addAttribute("html","<div><ul><li><a href=\"/\">demo</a></li></ul></div>");
        model.addAttribute("today", new Date());
        model.addAttribute("student", new Student(1L,"Nguyen Van A",20,true));
        return "demo";
    }
    @RequestMapping("/find/{id}")
    public String target(Model model, @PathVariable int id){
        model.addAttribute("id",id);
        List<String> list = Arrays.asList("nam","hoa","hanh");
        model.addAttribute("list",list);
        return "admin/target";
    }
}
