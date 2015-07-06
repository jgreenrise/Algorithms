package Array.problems;

/**
 * Validation 
 * http://sephlietz.com/gale-shapley/
 */
public class StableMarriageProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int pairs = 5;

		int[][] boys = {{4, 3, 2, 1, 0}, {4, 1, 2, 3, 0}, {2, 3, 4, 0, 1}, {1, 3, 4, 0, 2}, {1, 3, 2, 4, 0}};
		boolean available_boys[] = new boolean[5];
		for (int i = 0; i < available_boys.length; i++) {
			available_boys[i] = true;
		}

		int[][] girls = {{1, 3, 0, 2, 4}, {0, 2, 1, 4, 3}, {1, 0, 4, 2, 3}, {3, 1, 0, 2, 4}, {4, 2, 1, 0, 3}};
		boolean available_girls[] = new boolean[5];
		for (int i = 0; i < available_girls.length; i++) {
			available_girls[i] = true;
		}

		int[][] match = {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};

		while (isAnyBoyAvailable(available_boys)) {

			// Looping through boys
			for (int i = 0; i < boys.length; i++) {

				if (available_boys[i]) {

					// Get preference
					int[] tmp = boys[i];

					// Looping through boys preference and checking for
					// availability
					int j = 0;
					for (j = 0; j < tmp.length; j++) {

						//System.out.println(tmp[j]);

						if (available_girls[tmp[j]]) {

							match[i][0] = i;
							match[i][1] = tmp[j];
							available_girls[tmp[j]] = false;
							available_boys[i] = false;
							
							break;

						} else {

							int girls_currently_selected_boy = 0;
							int[] girls_preference = girls[tmp[j]];
							
							/**
							 * Get currently selected boy
							 */
							for (int k = 0; k < pairs; k++) {
								
								if (match[k][1] == tmp[j]) {
									girls_currently_selected_boy = k;
									break;
								}
							}

							/**
							 * Detect if, girl can find a better match
							 */
							int index_curr_selection = 0;
							int index_new_selection = 0;

							for (int k = 0; k < girls_preference.length; k++) {
								if (girls_preference[k] == girls_currently_selected_boy)
									index_curr_selection = k;
								else if (girls_preference[k] == i)
									index_new_selection = k;
							}

							if (index_new_selection < index_curr_selection) {
								// If girl finds a better match

								match[i][0] = i;
								match[i][1] = tmp[j];
								available_boys[i] = false;

								// Erase old connection
								match[girls_currently_selected_boy][0] = 0;
								match[girls_currently_selected_boy][1] = 0;
								available_boys[girls_currently_selected_boy] = true;
								
								break;

							}

						}
					}

				}
			}
		}
		
		System.out.println(match);

	}

	private static boolean isAnyBoyAvailable(boolean[] available_boys) {
		for (int i = 0; i < available_boys.length; i++) {
			if (available_boys[i])
				return true;
		}

		return false;
	}

}
