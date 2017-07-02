package com.ues21.list;

import com.ues21.BaseTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fleon on 1/7/17.
 */
public class SimpleListTest extends BaseTest {

    @Test
    public void testsEmptyList() {
        SimpleList<String> list = new SimpleList<String>();

        Assert.assertEquals("New list size should be 0", 0, list.getSize());
        Assert.assertNull("List start should be null", list.getStart());

        list = new SimpleList<String>(true);

        Assert.assertEquals("New list size should be 0", 0, list.getSize());
        Assert.assertNull("List start should be null", list.getStart());
    }

    @Test
    public void testAddAndRemoveWithoutOccurrences() {
        // Create a new list without allowing duplicates.
        SimpleList<Integer> list = new SimpleList<Integer>();

        // Validate initial status of the list.
        Assert.assertEquals("New list size should be 0", 0, list.getSize());
        Assert.assertNull("List start data should be null", list.getStart());

        // Try to remove a null element:
        boolean removed = list.remove(false, null);
        Assert.assertFalse("Null elements are not allowed in the list", removed);

        list.add(1);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(null);
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(4);

        Assert.assertEquals("4 - 3 - 2 - 1", list.getAsString());
        Assert.assertEquals("List size should be 4", 4, list.getSize());

        // Remove first occurrence of 2.
        removed = list.remove(false, 4);
        Assert.assertTrue("Existent elements should be removed", removed);
        Assert.assertEquals("3 - 2 - 1", list.getAsString());
        Assert.assertEquals("List size should be 3", 3, list.getSize());

        // Remove all occurrences of 3.
        removed = list.remove(true, 1);
        Assert.assertTrue("Existent elements should be removed", removed);
        Assert.assertEquals("3 - 2", list.getAsString());
        Assert.assertEquals("List size should be 2", 2, list.getSize());
    }

    @Test
    public void testsElementExistst() {
        SimpleList<String> list = new SimpleList<String>();

        Assert.assertEquals("New list size should be 0", 0, list.getSize());
        Assert.assertNull("List start should be null", list.getStart());

        list.add("one");
        list.add("two");

        Assert.assertEquals("New list size should be 2", 2, list.getSize());
        Assert.assertEquals("List start should be 'two'", "two", list.getStart().getData());

        boolean exists = list.exists("ONE");
        Assert.assertFalse("List takes case into account", exists);

        exists = list.exists("two");
        Assert.assertTrue("'two' should exists into the list", exists);
    }

    @Test
    public void testAddAndRemoveWithOccurrences() {
        // Create a new list without allowing duplicates.
        SimpleList<Integer> list = new SimpleList<Integer>(true);

        // Validate initial status of the list.
        Assert.assertEquals("New list size should be 0", 0, list.getSize());
        Assert.assertNull("List start data should be null", list.getStart());

        // Try to remove a null element:
        boolean removed = list.remove(false, null);
        Assert.assertFalse("Null elements are not allowed in the list", removed);
        Assert.assertEquals("List size should be 0", 0, list.getSize());

        list.add(1);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(4);

        Assert.assertEquals("4 - 1 - 3 - 1 - 2 - 1 - 2 - 1", list.getAsString());
        Assert.assertEquals("List size should be 8", 8, list.getSize());

        // Remove first occurrence of 2.
        removed = list.remove(false, 2);
        Assert.assertTrue("Existent elements should be removed", removed);
        Assert.assertEquals("4 - 1 - 3 - 1 - 1 - 2 - 1", list.getAsString());
        Assert.assertEquals("List size should be 7", 7, list.getSize());

        // Remove all occurrences of 1.
        removed = list.remove(true, 1);
        Assert.assertTrue("Existent elements should be removed", removed);
        Assert.assertEquals("4 - 3 - 2", list.getAsString());
        Assert.assertEquals("List size should be 3", 3, list.getSize());
    }
}
