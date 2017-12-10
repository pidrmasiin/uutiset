package wad.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import wad.service.CategoryService;

@Controller
public class DefaultController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/hallinnoiKategorioita")
    public String listCategories(Model model) {
        
        model.addAttribute("categories", this.categoryRepository.findAll());
        return "setCategories";
    }

    @GetMapping("/")
    public String list(Model model) {
        Pageable pageable = PageRequest.of(0, 100, Sort.Direction.DESC, "time");
        model.addAttribute("items", itemRepository.findAll(pageable));
        return "index";
    }

    @GetMapping("/lisaaUutinen")
    public String addNewItem(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "newItem";
    }

    @GetMapping("/{id}/uutinen")
    public String showItem(Model model, @PathVariable Long id) {
        Item i = this.itemRepository.findById(id).get();
        i.setReads(i.getReads() + 1);
        this.itemRepository.save(i);
        model.addAttribute("item", itemRepository.findById(id).get());
        model.addAttribute("categories", itemRepository.findById(id).get().stringCategories());
        
        return "showItem";
    }

    @GetMapping("/uutistenMuokkaaminen")
    public String modifyNews(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "editItems";
    }

    @PostMapping("/post")
    public String create(@RequestParam String name) {
        
        List<Category> categories = new ArrayList();
      
        Item i = new Item();
        i.setCategories(categories);
        i.setName(name);
        i.setReads(0);
        i.setTime(LocalDateTime.now());
        itemRepository.save(i);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String remove(Model model, @PathVariable Long id) {
        itemRepository.deleteById(id);
        return "redirect:/";
    }
    
     
}
