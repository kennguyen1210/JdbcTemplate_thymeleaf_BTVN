package ra.acedemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.acedemy.dao.impl.CategoryDao;
import ra.acedemy.model.Category;

import java.time.LocalDate;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryDao categoryDao;
    @GetMapping
    public String list(Model model){
        model.addAttribute("list",categoryDao.findAll());
        return "admin/category";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        categoryDao.delete(id);
        return "redirect:/category";
    }
    @GetMapping("/search")
    public String search(@RequestParam String search, Model model){
        if(search.isEmpty()){
            return "redirect:/category";
        }
        model.addAttribute(categoryDao.findByName(search));
        return "admin/category";
    }
    @GetMapping("/edit/{id}")
    public String getEditItem(@PathVariable Long id, Model model){
        model.addAttribute("category",categoryDao.findById(id));
        return "admin/editCategory";
    }
    @PostMapping("/doEdit")
    public String doEdit(@ModelAttribute("calegory") Category category){
        categoryDao.update(category);
        return "redirect:/category";
    }
    @PostMapping("/add")
    public String doAdd(@RequestParam String name,@RequestParam String des){
        categoryDao.save(new Category(null,name,des, LocalDate.now()));
        return "redirect:/category";
    }
}
