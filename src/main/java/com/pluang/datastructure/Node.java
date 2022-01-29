package com.pluang.datastructure;

import lombok.Getter;
import lombok.Setter;

public class Node extends ItemData {
    @Getter
    @Setter
    private int height;
    @Getter
    @Setter
    private Node left;
    @Getter
    @Setter
    private Node right;

    Node(double value) {
        super(value);
        height = 1;
    }
}