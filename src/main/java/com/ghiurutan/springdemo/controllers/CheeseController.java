package com.ghiurutan.springdemo.controllers;

import com.ghiurutan.springdemo.data.CategoryDAO;
import com.ghiurutan.springdemo.data.CheeseDAO;
import com.ghiurutan.springdemo.models.Category;
import com.ghiurutan.springdemo.models.Cheese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Ghiurutan on 8/26/2017.
 */

@Controller
@RequestMapping("cheese")
public class CheeseController {

    @Autowired
    private CheeseDAO cheeseDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "A list of cheeses");
        model.addAttribute("cheeses", cheeseDAO.findAll());
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String sendCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese Formular");
        model.addAttribute(new Cheese());
        model.addAttribute("categories", categoryDAO.findAll());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processCheeseForm(Model model, @ModelAttribute @Valid Cheese cheese, @RequestParam int categoryId, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("Title", "Add Cheese");
            model.addAttribute("categories", categoryDAO.findAll());
            return "cheese/add";
        }
        Category category = categoryDAO.findOne(categoryId);
        cheese.setCategory(category);
        cheeseDAO.save(cheese);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String sendRemoveCheeseForm(Model model) {
        model.addAttribute("title", "Remove cheeses");
        model.addAttribute("cheeses", cheeseDAO.findAll());
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {

        for (int id : cheeseIds) {
            cheeseDAO.delete(id);
        }

        return "redirect:";
    }

    @RequestMapping(value = "category", method = RequestMethod.GET)
    public String category(Model model, @RequestParam int id) {

        Category category = categoryDAO.findOne(id);
        List<Cheese> cheeses = category.getCheeses();
        model.addAttribute("title", "Cheeses in category: " + category.getName());
        model.addAttribute("cheeses", cheeses);
        return "cheese/index";
    }
}
