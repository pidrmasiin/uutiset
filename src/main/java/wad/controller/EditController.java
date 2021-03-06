/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Category;
import wad.domain.Item;
import wad.repository.CategoryRepository;
import wad.repository.ItemRepository;
import wad.repository.WriterRepository;

/**
 *
 * @author petteri
 */
@Controller
public class EditController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private WriterRepository writerRepository;

    @GetMapping("/hallinnoiKategorioita")
    public String listCategories(Model model) {

        model.addAttribute("categories", this.categoryRepository.findAll());
        return "setCategories";
    }

    @GetMapping("/hallinnoiKirjoittajia")
    public String listWriters(Model model) {

        model.addAttribute("writers", this.writerRepository.findAll());
        return "setWriters";
    }

    @GetMapping("/lisaaUutinen")
    public String addNewItem(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "newItem";
    }

    @GetMapping("/uutinen/{id}")
    public String showItem(Model model, @PathVariable Long id) {
        Item i = this.itemRepository.findById(id).get();
        i.setReads(i.getReads() + 1);
        this.itemRepository.save(i);
        model.addAttribute("item", itemRepository.findById(id).get());
        model.addAttribute("categories", itemRepository.findById(id).get().stringCategories());
        model.addAttribute("itemWri", itemRepository.findById(id).get().stringWriters());

        return "showItem";
    }

    @GetMapping("/uutistenMuokkaaminen")
    public String modifyNews(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "editItems";
    }

    @PostMapping("/post")
    public String create(@RequestParam String name) {
        if(name.isEmpty()){
            name = "ei otsikkoa";
        }
        List<Category> categories = new ArrayList();

        Item i = new Item();
        i.setCategories(categories);
        i.setName(name);
        i.setReads(0);
        i.setTime(LocalDateTime.now());
        itemRepository.save(i);
        return "redirect:/uutistenMuokkaaminen";
    }

    @DeleteMapping("/{id}")
    public String remove(Model model, @PathVariable Long id) {
        itemRepository.deleteById(id);
        return "redirect:/";
    }

}
