package wad.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Item;
import wad.repository.ItemRepository;

@Controller
public class DefaultController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/")
    public String list(Model model) {
     
        model.addAttribute("items", itemRepository.findAll());
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
        return "showItem";
    }
    
    @GetMapping("/uutistenMuokkaaminen")
    public String modifyNews(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "editItems";
    }

    @PostMapping("/post")
    public String create(@RequestParam String name) {
        Item i = new Item();
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
