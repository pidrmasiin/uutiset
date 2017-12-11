/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Writer;
import wad.repository.WriterRepository;

/**
 *
 * @author petteri
 */
@Controller
public class WriterController {

    @Autowired
    private WriterRepository writerRepository;

   

    @PostMapping("/lisaaKirjoittaja")
    public String addCategory(@RequestParam String name) {
        Writer w = new Writer();
        w.setName(name);
        this.writerRepository.save(w);
        return "redirect:/hallinnoiKirjoittajia";
    }

}
