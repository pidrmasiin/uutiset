/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Category;
import wad.repository.CategoryRepository;

/**
 *
 * @author petteri
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

   

    @PostMapping("/lisaaKategoria")
    public String addCategory(@RequestParam String name) {
        Category c = new Category();
        c.setName(name);
        this.categoryRepository.save(c);
        return "redirect:/hallinnoiKategorioita";
    }

}
