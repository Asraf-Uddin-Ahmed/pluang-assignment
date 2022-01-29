package com.pluang.services;

import com.pluang.data.ItemData;

public interface NumberService {
    ItemData getItem(double item);

    void insert(double item);

    void increaseSearchCount(ItemData itemData);

    void updateLastSearchTime(ItemData itemData);
}
