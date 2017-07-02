package com.ues21.common;

import com.ues21.BaseTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fleon on 1/7/17.
 */
public class NodeTest extends BaseTest {

    @Test
    public void testEmptyNode() {
        Node<String> n = new Node(null);
        Assert.assertNull("Next node should be null", n.getNext());
        Assert.assertNull("Node data should be null", n.getData());
    }

    @Test
    public void testNodeWithData() {
        Node<String> n = new Node("Fede");
        Assert.assertNull("Next node should be null", n.getNext());
        Assert.assertEquals("Node data should be 'Fede'", MOCKED_STRING, n.getData());
    }

    @Test
    public void testNodeEquals() {
        Node n = new Node(null);

        // A node should be equals to itself.
        Assert.assertTrue(n.equals(n));

        // Two nodes with different content should be distinct.
        Assert.assertFalse(n.equals(new Long(1234567L)));

        Assert.assertFalse(n.equals(null));

        Node other = new Node(null);

        // Two nodes with same content are equals.
        Assert.assertTrue(n.equals(other));

        other.setData(MOCKED_STRING);
        // After a change in data, these nodes should be different.
        Assert.assertFalse(n.equals(other));

        n.setData(MOCKED_STRING);
        Assert.assertTrue(n.equals(other));
    }

    @Test
    public void testNodeGettersAndSetters() {
        Node<String> n = new Node(null);

        Assert.assertNull("Node data should be null", n.getData());
        Assert.assertNull("Next node should be null", n.getNext());

        n.setData(MOCKED_STRING);
        n.setNext(n);

        Assert.assertNotNull("Node data should NOT be null", n.getData());
        Assert.assertEquals("Data should be 'Fede'", MOCKED_STRING, n.getData());

        Assert.assertNotNull("Next node should NOT be null", n.getNext());
        Assert.assertEquals(n, n.getNext());

        Assert.assertEquals(MOCKED_STRING, n.toString());
    }

    @Test
    public void testNodeCompare() {
        Node<String> n = new Node<String>(null);
        Node<String> o = new Node<String>(null);

        Assert.assertTrue(o.compareTo(n) == 0);

        n = new Node<String>("David");
        o = new Node<String>("Federico");

        Assert.assertTrue(n.compareTo(o) < 0);
        Assert.assertTrue(o.compareTo(n) > 0);

        n = new Node<String>("David");
        o = new Node<String>("David");

        Assert.assertTrue(n.compareTo(o) == 0);
    }

    @Test
    public void testNodeHashCode() {
        Node<Integer> n = new Node<Integer>(null);
        Assert.assertEquals("Null data hash code should be 13", 13, n.hashCode());

        n.setData(10);
        Assert.assertEquals("Data 10 hash code should be 130", 130, n.hashCode());
    }
}
