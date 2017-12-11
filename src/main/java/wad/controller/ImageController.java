/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import wad.domain.Image;
import wad.domain.Item;
import wad.repository.ImageRepository;
import wad.repository.ItemRepository;

/**
 *
 * @author petteri
 */
@Controller
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;
    
    @Autowired
    private ItemRepository itemRepository;

//    @PostMapping("/image/{id}")
//    public String save(@RequestParam("file") MultipartFile file, @PathVariable Long id) throws IOException {
//        if (!file.getContentType().equals("image/jpeg")) {
//            return "redirect:/";
//        }
//        Image img = new Image();
//        img.setImage(file.getBytes());
//
//        imageRepository.save(img);
//        Item i = this.itemRepository.getOne(id);
//        i.setImage(img);
//        
//        this.itemRepository.save(i);
//        
//        
//
//        return "redirect:/{id}";
//    }
//
//    @GetMapping(path = "/image/{id}/content", produces = "image/jpeg")
//    @ResponseBody
//    public byte[] getContent(@PathVariable Long id) {
//        
//        return this.itemRepository.getOne(id).getImage().getImage();
//    }
}
