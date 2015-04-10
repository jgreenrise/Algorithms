package String.group;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author JPatel
 * 
 */
public class ApplicationSBTest {

	private ArrayList<String> input_arrayList;
	private GroupStringsBasedUponLength mainApp;

	@Before
	public void executedBeforeEach() {
		input_arrayList = new ArrayList<String>();
		mainApp = new GroupStringsBasedUponLength();
		System.out.println("@Before: executed Before Each");
	}

	@After
	public void executedAfterEach() {
		if (input_arrayList != null)
			input_arrayList.clear();

		input_arrayList = null;
		mainApp = null;
		System.out.println("@Before: executed After Each");
	}

	@Test
	public void EmptyColl() {
		assertTrue(mainApp.getListOfWordsGrouped(input_arrayList).isEmpty());
		System.out.println("@Test: Check if test case passed with No items in input collection.");
	}

	@Test
	public void OneItemColl() {
		input_arrayList.add("Speak");
		assertEquals(1, mainApp.getListOfWordsGrouped(input_arrayList).size());
		System.out.println("@Test: Check if test case passed with only 1 item in input collection.");
	}

	@Test
	public void Null() {
		input_arrayList = null;
		assertNull(mainApp.getListOfWordsGrouped(input_arrayList));
		System.out.println("@Test: Check if test case passed with, input value null.");
	}

	@Test
	public void TestInputWithEvenNumbers() {
		input_arrayList = new ArrayList<String>(Arrays.asList("i", "a", "e", "l"));
		assertTrue(mainApp.getListOfWordsGrouped(input_arrayList).size() > 0);
		System.out.println("@Test: Check if test case passed with, with even numbers.");
	}

	@Test
	public void TestInputWithEvenNumberOfEqualSizeStrings() {
		input_arrayList = new ArrayList<String>(Arrays.asList("i", "a", "e", "l"));
		assertEquals(4, (mainApp.getListOfWordsGrouped(input_arrayList).get(0)).size());
		assertEquals(1, (mainApp.getListOfWordsGrouped(input_arrayList)).size());
		System.out.println("@Test: Check if test case passed with, with equal size string.");
	}

	@Test
	public void TestInputWithOddNumbers() {
		input_arrayList = new ArrayList<String>(Arrays.asList("i", "a", "e"));
		assertTrue(mainApp.getListOfWordsGrouped(input_arrayList).size() > 0);
		System.out.println("@Test: Check if test case passed with, with odd numbers.");
	}

	@Test
	public void TestInputWithOddNumbersHavingEqualSize() {
		input_arrayList = new ArrayList<String>(Arrays.asList("i", "a", "e"));
		assertEquals(3, (mainApp.getListOfWordsGrouped(input_arrayList).get(0)).size());
		assertEquals(1, (mainApp.getListOfWordsGrouped(input_arrayList)).size());
		System.out.println("@Test: Check if test case passed with, with odd numbers.");
	}

	@Test
	public void TestInputWitRandomInputStringSize() {
		input_arrayList = new ArrayList<String>(Arrays.asList("cali", "ny", "virginia", "giants", "caltrain"));
		assertTrue((mainApp.getListOfWordsGrouped(input_arrayList)).size() > 0);
		System.out.println("@Test: Check if test case passed with, with odd numbers.");
	}

}
