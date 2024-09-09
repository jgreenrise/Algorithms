public class a_0875_KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {

        int min = 1;
        int max = Integer.MIN_VALUE;
        int mid = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }


        while (min < max) {

            mid = (min + max) / 2;
            int currTot = 0;

            for (int pile : piles) {
                currTot += pile / mid;
                if (pile % mid != 0) {
                    currTot++;
                }
            }

            if (currTot <= h) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }

        return max;
    }

}