package com.ues21.tree;

import com.ues21.common.BinaryNode;

/**
 * Created by fleon on 2/7/17.
 */
public class BinaryTree<T extends Comparable<T>> {

    private BinaryNode<T> root;

    private int nodesCount;

    public BinaryTree() {
        nodesCount = 0;
    }

    public int getNodesCount() {
        return nodesCount;
    }

    private void incrementNodesCount() {
        nodesCount++;
    }

    private void decrementNodesCount() {
        nodesCount--;
    }

    public boolean insert(T data) {
        if (data == null) {
            return false;
        }

        if (root == null) {
            BinaryNode<T> n = new BinaryNode<T>(data);
            root = n;
            incrementNodesCount();
            return true;
        }
        return insert(root, data);
    }

    protected boolean insert(BinaryNode<T> node, T data) {
        BinaryNode<T> n = new BinaryNode<T>(data);
        // Validate if data goes to Left node:
        if (n.compareTo(node) <= 0) {
            if (node.getLeft() == null) {
                node.setLeft(n);
                incrementNodesCount();
                return true;
            } else {
                return insert(node.getLeft(), data);
            }
        }

        // Otherwise, just use right node.
        if (node.getRight() == null) {
            node.setRight(n);
            incrementNodesCount();
            return true;
        } else {
            return insert(node.getRight(), data);
        }
    }


    public T getSmallestData() {
        if (root == null) {
            return null;
        }
        return getSmallestData(root);
    }

    private T getSmallestData(BinaryNode<T> node) {
        if (node.getLeft() != null) {
            return getSmallestData(node.getLeft());
        } else {
            return node.getData();
        }
    }

    public T getBiggestData() {
        if (root == null) {
            return null;
        }
        return getBiggestData(root);
    }

    private T getBiggestData(BinaryNode<T> node) {
        if (node.getRight() != null) {
            return getBiggestData(node.getRight());
        } else {
            return node.getData();
        }
    }
}
