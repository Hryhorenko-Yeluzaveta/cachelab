package ua.com.cache.cachelab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.cache.cachelab.entity.Category;
import ua.com.cache.cachelab.entity.Rate;
import ua.com.cache.cachelab.service.CategoryService;
import ua.com.cache.cachelab.service.RateService;

import java.math.BigDecimal;

@Controller
public class CategoryController {

    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        return "index";
    }

    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable("id") Long id,
                                  Model model){
        model.addAttribute("category",categoryService.findCategoryById(id));
        return "category";
    }




    @PostMapping("/save")
    public String saveNewCategory(@RequestParam(name = "name") String name1,
                                  @RequestParam(name = "description") String description,
                                  @RequestParam(name = "image") String image){

        Category category = new Category();
        category.setDescription(description);
        category.setName(name1);

        category.setImage(image);

        categoryService.saveNewCategory(category);

        return "redirect:/";
    }


    @PostMapping("/update")
    public String updateCategory(@RequestParam(name = "id") Category category,
                                 @RequestParam(name = "name") String name,
                                 @RequestParam(name = "description") String description,
                                 @RequestParam(name = "image") String image){

        category.setDescription(description);
        category.setName(name);
        category.setImage(image);

        categoryService.updateCategory(category);

        return "redirect:/";
    }



    @PostMapping("/delete")
    public String deleteCategoryById(@RequestParam(name = "id") Long id){
        categoryService.deleteCategory(id);
        return "redirect:/";
    }




}