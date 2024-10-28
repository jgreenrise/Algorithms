public class a_2347_BestPokerHand {

    public String bestHand(int[] ranks, char[] suits) {

        int[] rankFreq = new int[14];
        int[] suitFreq = new int[5];
        int maxRankCount = 0;
        int maxSuitCount = 0;

        for (int k = 0; k < ranks.length; k++) {
            rankFreq[ranks[k]]++;
            maxRankCount = Integer.max(rankFreq[ranks[k]], maxRankCount);

            suitFreq[suits[k] - 'a']++;
            maxSuitCount = Integer.max(maxSuitCount, suitFreq[suits[k] - 'a']);
        }

        if (maxSuitCount == 5) {
            return "Flush";
        } else if (maxRankCount >= 3) {
            return "Three of a Kind";
        } else if (maxRankCount >= 2) {
            return "Pair";
        } else {
            return "High Card";
        }

    }
}
