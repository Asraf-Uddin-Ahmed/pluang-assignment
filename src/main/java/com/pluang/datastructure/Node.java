package com.pluang.datastructure;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Node {
    @Getter
    private double item;
    @Getter
    @Setter
    private int height;
    @Getter
    @Setter
    private Node left;
    @Getter
    @Setter
    private Node right;
    @Getter
    private Date insertionTime;
    @Getter
    @Setter
    private Date lastSearchTime;
    @Getter
    @Setter
    private int searchCount;

    Node(double value) {
        item = value;
        height = 1;
        insertionTime = new Date();
        searchCount = 0;
    }
}