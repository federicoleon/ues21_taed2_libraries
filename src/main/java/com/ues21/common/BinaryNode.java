package com.ues21.common;

/**
 * Created by fleon on 1/7/17.
 */
public class BinaryNode<T extends Comparable<T>> implements Comparable<BinaryNode<T>> {

    private T data;
    private BinaryNode left;
    private BinaryNode right;

    private int height;
    private int balanceFactor;

    public BinaryNode(T data) {
        this.data = data;
        height = 0;
        balanceFactor = 0;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBalanceFactor() {
        return balanceFactor;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

    @Override
    public int hashCode() {
        T data = getData();
        if (data == null) {
            return 13;
        }
        return 13 * data.hashCode();
    }

    public int compareTo(BinaryNode<T> other) {
        if (other == null || other.getData() == null) {
            if (this.data == null) {
                return 0;
            }
            return 1;
        }

        if (data == null) {
            return -1;
        }

        return data.compareTo(other.getData());
    }
}
