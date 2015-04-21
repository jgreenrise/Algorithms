package sort.InsertionSort;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InsertionSortTest {

	BasicInsertionSort insertionSort = null;

	@Before
	public void beforeMethodExecution() {
		insertionSort = new BasicInsertionSort();
	}

	/**
	 * TEST ASCENDING ORDER
	 
	
	@Test
	public void testExecuteInsertionSort_equal() {
		int[] response = { 10, 20, 30, 40 };
		Assert.assertArrayEquals(response, insertionSort.executeInsertionSort(new int[] { 20, 30, 40, 10 }));
	}

	@Test
	public void testExecuteInsertionSort_not_equal() {
		int[] response = { 10, 20, 30 };
		Assert.assertNotSame(response, insertionSort.executeInsertionSort(new int[] { 20, 30, 40, 10 }));
	}

	@Test
	public void testExecuteInsertionSort_with_no_arguments() {
		Assert.assertEquals(0, (insertionSort.executeInsertionSort(new int[] {})).length);
	}

	@Test
	public void testExecuteInsertionSort_with_null_input() {
		Assert.assertNull(insertionSort.executeInsertionSort(null));
	}

	@Test
	public void testExecuteInsertionSort_with_negative_input() {
		int[] response = { -40, -30, -20, -10 };
		Assert.assertArrayEquals(response, insertionSort.executeInsertionSort(new int[] { -20, -30, -40, -10 }));
	}

	@Test
	public void testExecuteInsertionSort_with_negative_and_positive_input() {
		int[] response = { -40, -30, -20, -10, 50, 60 };
		Assert.assertArrayEquals(response, insertionSort.executeInsertionSort(new int[] { -20, -30, 50, -40, 60, -10 }));
	}

	@Test
	public void testExecuteInsertionSort_with_input_having_dups() {
		int[] response = { -40, -30, -20, -20, -10, 50, 50, 60, 60 };
		Assert.assertArrayEquals(response, insertionSort.executeInsertionSort(new int[] { -20, 60, -20, 50, -30, 50, -40, 60, -10 }));
	}

	/**
	 * TEST DESCENDING ORDER
	 
	
	@Test
	public void testExecuteInsertionSort_descending_equal() {
		int[] response = { 40, 30, 20, 10 };
		Assert.assertArrayEquals(response, insertionSort.executeInsertionSort_descending(new int[] { 20, 30, 40, 10 }));
	}

	@Test
	public void testExecuteInsertionSort_descending_not_equal() {
		int[] response = { 10, 20, 30 };
		Assert.assertNotSame(response, insertionSort.executeInsertionSort_descending(new int[] { 30, 20, 10 }));
	}

	@Test
	public void testExecuteInsertionSort_descending_with_no_arguments() {
		Assert.assertEquals(0, (insertionSort.executeInsertionSort_descending(new int[] {})).length);
	}

	@Test
	public void testExecuteInsertionSort_descending_with_null_input() {
		Assert.assertNull(insertionSort.executeInsertionSort_descending(null));
	}

	@Test
	public void testExecuteInsertionSort_descending_with_negative_input() {
		int[] response = { -10, -20, -30, -40 };
		Assert.assertArrayEquals(response, insertionSort.executeInsertionSort_descending(new int[] { -20, -30, -40, -10 }));
	}

	@Test
	public void testExecuteInsertionSort_descending_with_negative_and_positive_input() {
		int[] response = { 60, 50, -10, -20, -30, -40 };
		Assert.assertArrayEquals(response, insertionSort.executeInsertionSort_descending(new int[] { -20, -30, 50, -40, 60, -10 }));
	}

	@Test
	public void testExecuteInsertionSort_descending_with_input_having_dups() {
		int[] response = { 60, 60, 50, 50, -10, -20, -20, -30, -40 };
		Assert.assertArrayEquals(response, insertionSort.executeInsertionSort_descending(new int[] { -20, 60, -20, 50, -30, 50, -40, 60, -10 }));
	}
	
	*/
}
