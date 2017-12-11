/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wad.domain.Item;
import wad.domain.Writer;
import wad.repository.ItemRepository;

import wad.repository.WriterRepository;

/**
 *
 * @author petteri
 */
@Service
public class WriterService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private WriterRepository writerRepository;

    @Transactional
    public void setCategory(Long itemId, Long writerId) {
        Writer w = this.writerRepository.getOne(writerId);
        Item i = this.itemRepository.getOne(itemId);

        if (!w.getItems().contains(i)) {
            w.getItems().add(i);
        }
        if (!i.getWriters().contains(w)) {
            i.getWriters().add(w);
        }

    }
}
