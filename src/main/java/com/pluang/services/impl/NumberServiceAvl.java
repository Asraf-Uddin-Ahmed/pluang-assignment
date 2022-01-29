package com.pluang.services.impl;

import com.pluang.datastructure.AVLTree;
import com.pluang.data.ItemData;
import com.pluang.services.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NumberServiceAvl implements NumberService {

    private final AVLTree avlTree;

    @Autowired
    public NumberServiceAvl(AVLTree avlTree) {
        this.avlTree = avlTree;
    }

    @Override
    public ItemData getItem(double item) {
        return avlTree.getItem(item);
    }

    @Override
    public void insert(double item) {
        avlTree.insert(item);
    }

    @Override
    public void increaseSearchCount(ItemData itemData) {
        itemData.setSearchCount(itemData.getSearchCount() + 1);
    }

    @Override
    public void updateLastSearchTime(ItemData itemData) {
        itemData.setLastSearchTime(new Date());
    }
}
