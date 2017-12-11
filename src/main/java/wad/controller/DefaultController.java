package wad.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wad.repository.ItemRepository;


@Controller
public class DefaultController {

    @Autowired
    private ItemRepository itemRepository;

   
    
    @GetMapping("/")
    public String list(Model model) {
        Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "time");
        model.addAttribute("items", itemRepository.findAll(pageable));
        return "index";
    }
    
    @GetMapping("/lukujenMukaan")
    public String sortByReads(Model model) {
        Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "reads");
        model.addAttribute("items", itemRepository.findAll(pageable));
        return "index";
    }
    
    @GetMapping("/kirjaudu")
    public String logIn(Model model) {
        
        return "logIn";
    }
}
