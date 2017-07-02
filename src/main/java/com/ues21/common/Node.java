package com.ues21.common;

/**
 * Created by fleon on 1/7/17.
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    private Node next;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }
        if (data == null && ((Node) o).getData() == null) {
            return true;
        }

        if (data == null) {
            return false;
        }

        return data.equals(((Node) o).getData());
    }

    public int hashCode() {
        if (data == null) {
            return 13;
        }
        return 13 * data.hashCode();
    }

    @Override
    public String toString() {
        //TODO: Validate!
        return data.toString();
    }

    public int compareTo(Node<T> other) {
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
