package Array.problems;

/*-
 * 
 
 Write a method in Java to: 

Given N number of ArrayLists. Each ArrayList has a different length. 

Find ALL combinations where each combination is formed by picking one (and ONLY one) item from each input ArrayList.

You have to exhaust ALL combinations.

Example:

Input: List<ArrayList<String>> inputData


N number of array lists with different length
[a1,a2,a3]
[b1,b2]
[c1,c2 ]
 
...
Output: ALL combinations
[a1, b1, c1...], 
[a1,b1, c2..]
 * 
Output
1. Silver Petrol Toyota
2. Silver Petrol Micro
3. Silver Hybrid Toyota
4. Silver Hybrid Micro
5. White Petrol Toyota
6. White Petrol Micro
7. White Hybrid Toyota
8. White Hybrid Micro
9. Grey Petrol Toyota
10. Grey Petrol Micro
11. Grey Hybrid Toyota
12. Grey Hybrid Micro
13. Purple Petrol Toyota
14. Purple Petrol Micro
15. Purple Hybrid Toyota
16. Purple Hybrid Micro

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllCombinationsFromNArrayLists {

	public static void main(String[] args) {

		List<String> listOne = Arrays.asList("Silver", "White", "Grey",
				"Purple");
		List<String> listTwo = Arrays.asList("Petrol", "Hybrid");
		List<String> listThree = Arrays.asList("Toyota", "Micro");
		
		List<List<String>> totalList = Arrays.asList(listOne, listTwo,
				listThree);

		printAllCases(totalList);
	}

	public static void printAllCases(List<List<String>> totalList) {
		List<String> result = new ArrayList<String>(totalList.get(0));

		for (int index = 1; index < totalList.size(); index++) {
			result = combineTwoLists(result, totalList.get(index));
		}

		/* print */
		int count = 0;
		for (String s : result) {
			System.out.printf("%d. %s\n", ++count, s);
		}
	}

	private static List<String> combineTwoLists(List<String> list1, List<String> list2) {
		List<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		for (String s1 : list1) {
			for (String s2 : list2) {
				sb.setLength(0);
				sb.append(s1).append(' ').append(s2);
				result.add(sb.toString());
			}
		}
		return result;
	}

}
