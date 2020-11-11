package tree.problems;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("Hello, World!");
		strings.add("Welcome to CoderPad.");
		strings.add("This pad is running Java " + Runtime.version().feature());

		//int [][] schedules = {{1,4}, {5,6}, {8,9}, {2,6}};
/*		System.out.println("0 Positive test case "+returnMinSchedules(new int [][]{{0,30}, {5,10}, {15,20}}));
		System.out.println("1 Positive test case "+returnMinSchedules(new int [][]{{1,4}, {5,6}, {8,9}, {2,6}}));
		System.out.println("2 Positive test case "+returnMinSchedules(new int [][]{{1,4},{8,9}}));
		System.out.println("3 Positive test case "+returnMinSchedules(new int [][]{{1,4}}));*/
		//System.out.println("4 Positive test case "+returnMinSchedules(new int [][]{{1,2}, {2,3}, {3,4}, {4,5}, {5,6}}));
		System.out.println("5 Positive test case "+returnMinSchedules(new int [][]{{1,2}, {4,5}, {3,4}, {2,7}}));
		System.out.println("1 Negative test case "+returnMinSchedules(null));
		System.out.println("2 Negative test case "+returnMinSchedules(new int [][]{}));

	}

	// 1. Two pointers
	// 2. PQ

	public static int returnMinSchedules(int [][] schedules){

		if(schedules == null || schedules.length == 0){
			return 0;
		}

		if(schedules.length == 1){
			return 1;
		}

		// Ignoring negative case
		int minSchedules = 0;
		int ignoreIndex = -1;

		// 1. Sort Schedules by start time
		//(1, 4), (1, 6)
		// (1, 4), (2, 6)
		// (2, 4), (1, 6)
		// Sort intervals by start time
		Arrays.sort(schedules, (left, right) -> left[0] - right[0]);

		// Create Max heap
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);

		// Adding first entry
		pq.add(schedules[0][0]); // 1
		pq.add(schedules[0][1]); // 4

		for(int j=1; j< schedules.length; j++){

			if(schedules[j][0] != -1) {

				int currStart = schedules[j][0]; // 8
				int currEnd = schedules[j][1]; // 9

				Integer top = null;
				if (!pq.isEmpty()) {
					top = pq.remove();  // 6
				} else {
					System.out.println("PQ is empty");
					continue;
				}

				// 4 > 2 , 4 > 5, 6 > 8
				if (top > currStart) {
					if(ignoreIndex < 0)
						ignoreIndex = j;

					pq.offer(top); // 4

					if(j+1 == schedules.length && ignoreIndex > -1) {
						pq.remove();
						pq.remove();
						pq.add(schedules[ignoreIndex][0]); //1
						pq.add(schedules[ignoreIndex][1]); // 4
						j = ignoreIndex;
						ignoreIndex = -1;
						continue;
					}

				} else {
					if(minSchedules == 0){
						minSchedules ++;
					}
					//pq.remove(); // 1
					pq.offer(currEnd);

					// Ignore this schedule
					schedules[j][0] = -1;

					if(j+1 == schedules.length && ignoreIndex != -1) {
						pq.remove();
						pq.remove();
						pq.add(schedules[ignoreIndex][0]); //1
						pq.add(schedules[ignoreIndex][1]); // 4
						j = ignoreIndex;
						ignoreIndex = -1;
						continue;
					}

					// All schedules are considered
					if(j+1 == schedules.length && ignoreIndex == -1){
						pq.remove();
						pq.remove();
					}

				}
			}

		}

		if(!pq.isEmpty()){
			minSchedules++;
		}

		return minSchedules;
	}
}