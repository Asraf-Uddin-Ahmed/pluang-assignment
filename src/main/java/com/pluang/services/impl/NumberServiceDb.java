package com.pluang.services.impl;

import com.pluang.data.ItemData;
import com.pluang.entities.Item;
import com.pluang.repositories.ItemRepository;
import com.pluang.services.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class NumberServiceDb implements NumberService {

    private final ItemRepository itemRepository;

    @Autowired
    public NumberServiceDb(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    private ItemData getItemData(Item item) {
        if (item == null) {
            return null;
        }
        ItemData itemData = new ItemData(item.getNumber(), item.getCreatedAt());
        itemData.setLastSearchTime(item.getLastSearchedAt());
        itemData.setSearchCount(item.getSearchCount());
        return itemData;
    }

    @Override
    public ItemData getItem(double item) {
        return this.getItemData(itemRepository.findByNumber(item));
    }

    @Override
    @Transactional
    public void insert(double item) {
        Item itemEntity = new Item();
        itemEntity.setNumber(item);
        itemRepository.save(itemEntity);
    }

    @Override
    @Transactional
    public void increaseSearchCount(ItemData itemData) {
        Item itemEntity = itemRepository.findByNumber(itemData.getItem());
        itemEntity.setSearchCount(itemEntity.getSearchCount() + 1);
        itemRepository.save(itemEntity);
        itemData.setSearchCount(itemEntity.getSearchCount());
    }

    @Override
    @Transactional
    public void updateLastSearchTime(ItemData itemData) {
        Item itemEntity = itemRepository.findByNumber(itemData.getItem());
        itemEntity.setLastSearchedAt(new Date());
        itemRepository.save(itemEntity);
        itemData.setLastSearchTime(itemEntity.getLastSearchedAt());
    }
}
