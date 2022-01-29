package com.pluang.datastructure;

import org.springframework.stereotype.Component;

@Component
public class AVLTree {
    private Node root;

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    private int getMax(int a, int b) {
        return (a > b) ? a : b;
    }

    private Node rotateRight(Node node) {
        Node leftNode = node.getLeft();
        Node rightNodeOfLeftNode = leftNode.getRight();
        leftNode.setRight(node);
        node.setLeft(rightNodeOfLeftNode);
        node.setHeight(getMax(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
        leftNode.setHeight(getMax(getHeight(leftNode.getLeft()), getHeight(leftNode.getRight())) + 1);
        return leftNode;
    }

    private Node rotateLeft(Node node) {
        Node rightNode = node.getRight();
        Node leftNodeOfRightNode = rightNode.getLeft();
        rightNode.setLeft(node);
        node.setRight(leftNodeOfRightNode);
        node.setHeight(getMax(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
        rightNode.setHeight(getMax(getHeight(rightNode.getLeft()), getHeight(rightNode.getRight())) + 1);
        return rightNode;
    }

    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    private Node updateBalanceFactor(Node node, double item) {
        node.setHeight(1 + getMax(getHeight(node.getLeft()), getHeight(node.getRight())));
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (item < node.getLeft().getItem()) {
                return rotateRight(node);
            } else if (item > node.getLeft().getItem()) {
                node.setLeft(rotateLeft(node.getLeft()));
                return rotateRight(node);
            }
        }
        if (balanceFactor < -1) {
            if (item > node.getRight().getItem()) {
                return rotateLeft(node);
            } else if (item < node.getRight().getItem()) {
                node.setRight(rotateRight(node.getRight()));
                return rotateLeft(node);
            }
        }
        return node;
    }

    private Node insertNode(Node node, double item) {
        if (node == null) {
            return (new Node(item));
        }

        if (item < node.getItem()) {
            node.setLeft(insertNode(node.getLeft(), item));
        } else if (item > node.getItem()) {
            node.setRight(insertNode(node.getRight(), item));
        } else {
            return node;
        }
        return this.updateBalanceFactor(node, item);
    }

    private Node getItem(Node node, double item) {
        if (node == null) {
            return null;
        }
        if (item < node.getItem()) {
            return getItem(node.getLeft(), item);
        }
        if (item > node.getItem()) {
            return getItem(node.getRight(), item);
        }
        return node;
    }

    public void insert(double item) {
        this.root = this.insertNode(this.root, item);
    }

    public Node getItem(double item) {
        return this.getItem(this.root, item);
    }

}