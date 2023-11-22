package ra.acedemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.acedemy.dao.impl.StudentDao;
import ra.acedemy.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentDao studentDao;
    @GetMapping
    public String list(Model model){
        model.addAttribute("list",studentDao.getAll());
        return "admin/student/student";
    }
    @GetMapping("/delete/{id}")
    public String list(Model model, @PathVariable Long id){
        studentDao.delete(id);
        return "redirect:/student";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id){
        model.addAttribute("student",studentDao.findById(id));
        return "admin/student/editStudent";
    }
    @PostMapping("/add")
    public String add(@RequestParam String name, @RequestParam boolean sex, @RequestParam int age, @RequestParam String address){
        studentDao.save(new Student(null, name,address,age,sex));
        return "redirect:/student";
    }
    @PostMapping("/doEdit")
    public String doEdit(@RequestParam String name, @RequestParam boolean sex, @RequestParam int age, @RequestParam String address, @RequestParam Long id){
        studentDao.update(new Student(id,name,address,age,sex));
        return "redirect:/student";
    }
    @GetMapping("/search")
    public String doSearch(@RequestParam String search, Model model){
        if(search.isEmpty()){
            return "redirect:/student";
        } else {
            model.addAttribute("list",studentDao.findByName(search));
            return "admin/student/student";
        }

    }

}
