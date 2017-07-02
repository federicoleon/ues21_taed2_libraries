package com.ues21.list;

import com.ues21.common.Node;

/**
 * Created by fleon on 1/7/17.
 */
public class SimpleList<T extends Comparable<T>> {

    private Node<T> start;
    private int length;

    private boolean allowDuplicates;

    public SimpleList() {
        length = 0;
        this.allowDuplicates = false;
    }

    public SimpleList(boolean allowDuplicates) {
        length = 0;
        this.allowDuplicates = allowDuplicates;
    }

    public int getSize() {
        return length;
    }

    public Node<T> getStart() {
        return start;
    }

    public boolean exists(T data) {
        Node c = start;
        while (c != null) {
            if (data.equals(c.getData())) {
                return true;
            }
            c = c.getNext();
        }
        return false;
    }

    public boolean add(T data) {
        if (data == null) {
            return false;
        }

        if (!allowDuplicates && exists(data)) {
            return false;
        }

        Node<T> n = new Node(data);
        if (start == null) {
            start = n;
        } else {
            n.setNext(start);
            start = n;
        }
        length++;

        return true;
    }

    public boolean remove(boolean removeAll, T data) {
        if (data == null) {
            return false;
        }

        boolean removed = false;
        boolean shouldMove = true;
        Node c = start;
        Node aux = start;
        while (c != null) {
            shouldMove = true;
            if (data.equals(c.getData())) {
                // Remove element, decrease size and mark as removed.
                if (c == start) {
                    start = start.getNext();
                } else {
                    aux.setNext(c.getNext());
                    shouldMove = false;
                }
                length--;
                removed = true;
                if (!removeAll) {
                    break;
                }
            }
            if (shouldMove) {
                aux = c;
            }
            c = c.getNext();
        }
        return removed;
    }

    public String getAsString() {
        Node<T> a = start;
        StringBuilder r = new StringBuilder();
        while (a != null) {
            r.append(a.getData());
            if (a.getNext() != null) {
                r.append(" - ");
            }
            a = a.getNext();
        }
        return r.toString();
    }
}
