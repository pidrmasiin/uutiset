/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.domain.Category;
import wad.domain.Item;
import wad.repository.CategoryRepository;
import wad.repository.ItemRepository;

/**
 *
 * @author petteri
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public void setCategory(Long itemId, Long categoryId) {
        Category c = this.categoryRepository.getOne(categoryId);
        Item i = this.itemRepository.getOne(itemId);
        
        if(!c.getItems().contains(i)){
            c.getItems().add(i);
        }
        if(!i.getCategories().contains(c)){
            i.getCategories().add(c);
        }
        
   

    }
    
   

}
