package com.ues21.common;

import com.ues21.BaseTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fleon on 1/7/17.
 */
public class BinaryNodeTest extends BaseTest {

    @Test
    public void testEmptyBinaryNode() {
        BinaryNode<String> n = new BinaryNode(null);
        Assert.assertNull("Data should be null", n.getData());
        Assert.assertNull("Left node should be null", n.getLeft());
        Assert.assertNull("Right data should be null", n.getRight());
    }

    @Test
    public void testBinaryNodeData() {
        BinaryNode<String> n = new BinaryNode(null);
        Assert.assertNull("Data should be null", n.getData());
        Assert.assertNull("Left node should be null", n.getLeft());
        Assert.assertNull("Right data should be null", n.getRight());

        n.setData(MOCKED_STRING);
        Assert.assertEquals("Data should be 'Fede'", MOCKED_STRING, n.getData());
        Assert.assertNull("Left node should be null", n.getLeft());
        Assert.assertNull("Right data should be null", n.getRight());

        n.setLeft(n);
        Assert.assertEquals("Data should be 'Fede'", MOCKED_STRING, n.getData());
        Assert.assertEquals("Node left should be n", n, n.getLeft());
        Assert.assertNull("Right data should be null", n.getRight());

        n.setRight(n);
        Assert.assertEquals("Data should be 'Fede'", MOCKED_STRING, n.getData());
        Assert.assertEquals("Node left should be n", n, n.getLeft());
        Assert.assertEquals("Node right should be n", n, n.getRight());

        n = new BinaryNode(MOCKED_STRING);
        Assert.assertEquals("Data should be 'Fede'", MOCKED_STRING, n.getData());
        Assert.assertNull("Left node should be null", n.getLeft());
        Assert.assertNull("Right data should be null", n.getRight());
    }

    @Test
    public void testBinaryNodeCompare() {
        BinaryNode<String> n = new BinaryNode<String>(null);
        BinaryNode<String> o = new BinaryNode<String>(null);

        Assert.assertTrue(o.compareTo(n) == 0);

        n = new BinaryNode<String>("David");
        o = new BinaryNode<String>("Federico");

        Assert.assertTrue(n.compareTo(o) < 0);
        Assert.assertTrue(o.compareTo(n) > 0);

        n = new BinaryNode<String>("David");
        o = new BinaryNode<String>("David");

        Assert.assertTrue(n.compareTo(o) == 0);

        n = new BinaryNode<String>(null);
        o = new BinaryNode<String>("David");

        Assert.assertTrue(n.compareTo(o) < 0);
        Assert.assertTrue(o.compareTo(n) > 0);
    }

    @Test
    public void testNodeHashCode() {
        BinaryNode<Integer> n = new BinaryNode<Integer>(null);
        Assert.assertEquals("Null data hash code should be 13", 13, n.hashCode());

        n.setData(10);
        Assert.assertEquals("Data 10 hash code should be 130", 130, n.hashCode());
    }
}
