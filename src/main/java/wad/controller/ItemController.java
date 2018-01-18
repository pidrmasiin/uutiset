/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import java.io.IOException;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import wad.domain.Category;
import wad.domain.Item;
import wad.repository.CategoryRepository;
import wad.repository.ItemRepository;
import wad.repository.WriterRepository;
import wad.service.CategoryService;
import wad.service.WriterService;

/**
 *
 * @author petteri
 */
@Controller
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired WriterRepository writerRepository;
    
    @Autowired
    private WriterService writerService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public String list(Model model, @PathVariable Long id) {
        List<String> c = this.itemRepository.getOne(id).stringCategories();
        List<String> w = this.itemRepository.getOne(id).stringWriters();
        model.addAttribute("itemWri", w);
        model.addAttribute("itemCat", c);
        model.addAttribute("writers", this.writerRepository.findAll());
        model.addAttribute("categories", this.categoryRepository.findAll());
        model.addAttribute("item", itemRepository.findById(id).get());
        return "editItem";
    }

    @PostMapping("/newName/{id}")
    public String changeName(Model model, @PathVariable Long id, @RequestParam String name) {
        if(name.isEmpty()){
            name = "ei otsikkoa";
        }
        Item i = itemRepository.findById(id).get();
        i.setName(name);
        this.itemRepository.save(i);
        return "redirect:/{id}";
    }

    @PostMapping("/setLead/{id}")
    public String setLead(Model model, @PathVariable Long id, @RequestParam String lead) {

        Item i = itemRepository.findById(id).get();
        i.setLead(lead);
        this.itemRepository.save(i);
        return "redirect:/{id}";
    }
    
    @PostMapping("/setImage/{id}")
    public String setImage(Model model, @PathVariable Long id, @RequestParam String image) {

        Item i = itemRepository.findById(id).get();
        i.setImage(image);
        this.itemRepository.save(i);
        return "redirect:/{id}";
    }

    @PostMapping("/asetaKategoria/{id}")
    public String setCategory(Model model, @PathVariable(value = "id") Long id, @RequestParam(required = false, value = "categoryId") Long categoryId) {
        if (categoryId != null) {
            this.categoryService.setCategory(id, categoryId);
        }

        return "redirect:/{id}";
    }
    
    @PostMapping("/asetaKirjoittaja/{id}")
    public String setWriter(Model model, @PathVariable(value = "id") Long id, @RequestParam(required = false, value = "writerId") Long writerId) {
        if (writerId != null) {
            this.writerService.setCategory(id, writerId);
        }

        return "redirect:/{id}";
    }

    @PostMapping("/setText/{id}")
    public String setText(Model model, @PathVariable Long id, @RequestParam String text) {

        Item i = itemRepository.findById(id).get();
        i.setText(text);
        this.itemRepository.save(i);
        return "redirect:/{id}";
    }
    

}
