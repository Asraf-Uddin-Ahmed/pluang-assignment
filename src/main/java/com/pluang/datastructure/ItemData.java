package com.pluang.datastructure;

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

    ItemData(double item) {
        this.item = item;
        insertionTime = new Date();
        searchCount = 0;
    }
}
