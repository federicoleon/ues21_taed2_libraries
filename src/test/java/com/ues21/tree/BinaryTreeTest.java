package com.ues21.tree;

import com.ues21.BaseTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fleon on 2/7/17.
 */
public class BinaryTreeTest extends BaseTest {

    @Test
    public void testCreateTree() {
        BinaryTree<String> tree = new BinaryTree<String>();

        Assert.assertEquals("Nodes count should be 0", 0, tree.getNodesCount());

        boolean inserted = tree.insert(null);
        Assert.assertFalse("Null should NOT be inserted", inserted);

        Assert.assertEquals("Nodes count should be 0", 0, tree.getNodesCount());

        inserted = tree.insert("Federico");
        Assert.assertTrue("Valid string should be inserted", inserted);
        Assert.assertEquals("Nodes count should be 1", 1, tree.getNodesCount());

        inserted = tree.insert("David");
        Assert.assertTrue("Valid string should be inserted", inserted);
        Assert.assertEquals("Nodes count should be 2", 2, tree.getNodesCount());

        inserted = tree.insert("Hector");
        Assert.assertTrue("Valid string should be inserted", inserted);
        Assert.assertEquals("Nodes count should be 3", 3, tree.getNodesCount());

        inserted = tree.insert("Raquel");
        Assert.assertTrue("Valid string should be inserted", inserted);
        Assert.assertEquals("Nodes count should be 4", 4, tree.getNodesCount());

        inserted = tree.insert("Gustavo");
        Assert.assertTrue("Valid string should be inserted", inserted);
        Assert.assertEquals("Nodes count should be 5", 5, tree.getNodesCount());

        inserted = tree.insert("Ana");
        Assert.assertTrue("Valid string should be inserted", inserted);
        Assert.assertEquals("Nodes count should be 6", 6, tree.getNodesCount());
    }

    @Test
    public void testSmallestData() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        Assert.assertEquals("Nodes count should be 0", 0, tree.getNodesCount());
        Assert.assertNull("Smallest data should be null", tree.getSmallestData());

        tree.insert(10);
        tree.insert(5);
        tree.insert(8);
        tree.insert(3);
        tree.insert(0);
        tree.insert(7);

        Assert.assertEquals("Nodes count should be 6", 6, tree.getNodesCount());
        Assert.assertEquals("Smallest data should be 0", new Integer(0), tree.getSmallestData());
    }

    @Test
    public void testBiggestData() {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        Assert.assertEquals("Nodes count should be 0", 0, tree.getNodesCount());
        Assert.assertNull("Biggest data should be null", tree.getBiggestData());

        tree.insert(10);
        tree.insert(5);
        tree.insert(8);
        tree.insert(3);
        tree.insert(0);
        tree.insert(13);
        tree.insert(7);

        Assert.assertEquals("Nodes count should be 7", 7, tree.getNodesCount());
        Assert.assertEquals("Biggest data should be 13", new Integer(13), tree.getBiggestData());
    }
}
