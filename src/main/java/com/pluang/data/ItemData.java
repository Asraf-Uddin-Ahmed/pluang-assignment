package com.pluang.data;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class ItemData {
    @Getter
    private final double item;
    @Getter
    private final Date insertionTime;
    @Getter
    @Setter
    private Date lastSearchTime;
    @Getter
    @Setter
    private int searchCount;

    public ItemData(double item) {
        this.item = item;
        insertionTime = new Date();
        searchCount = 0;
    }

    public ItemData(double item, Date insertionTime) {
        this.item = item;
        this.insertionTime = insertionTime;
    }
}
