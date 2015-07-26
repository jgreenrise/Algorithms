package Array.problems.ManTowerOrBoxStacking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestTower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Man> l = new ArrayList<Man>();
		l.add(new Man(65, 100));
		l.add(new Man(70, 150));
		l.add(new Man(56, 90));
		l.add(new Man(75, 190));
		l.add(new Man(60, 95));
		l.add(new Man(68, 110));
		l.add(new Man(76, 10));

		System.out.println(longestTower(l));
	}

	public static int longestTower(List<Man> list) {
		Collections.sort(list, new ManComparator());
		// now find the longest increasing sequence of 'weight' property
		int len = list.size();
		int maxLen = 1;
		int[] dp = new int[len];
		for (int i = 1; i < len; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (list.get(i).getWeight() > list.get(j).getWeight()) {
					System.out.println(dp[i]);
					System.out.println(dp[j] + 1);
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}
		return maxLen;
	}

}
