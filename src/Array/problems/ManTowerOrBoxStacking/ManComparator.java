package Array.problems.ManTowerOrBoxStacking;

import java.util.Comparator;

public class ManComparator implements Comparator<Man> {
	@Override
	public int compare(Man o1, Man o2) {
		return o1.getHeight() - o2.getHeight();
	}
}