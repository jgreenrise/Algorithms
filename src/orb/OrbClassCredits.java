package orb;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OrbClassCredits {

    PriorityQueue<int[]> pq_credits = null;
    PriorityQueue<int[]> pq_deduct_credits = null;
    PriorityQueue<int[]> pq_tmp_credits = null;
    PriorityQueue<int[]> pq_tmp_deduct_credits = null;
    PriorityQueue<int[]> pq_temp = null;

    public static void main(String args[]) {
        OrbClassCredits obj = new OrbClassCredits();
        obj.addCredits(5, 15, 23);
        obj.deductCredits(4, 17);
        obj.addCredits(8, 3, 19);
        System.out.println(obj.get_balance_at(20));
        System.out.println(obj.get_balance_at(24));
        System.out.println(obj.get_balance_at(19));
        System.out.println(obj.get_balance_at(15));
        System.out.println(obj.get_balance_at(3));
        System.out.println(obj.get_balance_at(2));

        /**
         System.out.println("#Test 2");
         obj = new OrbClassCredits();
         obj.addCredits(30, 15, 23);
         obj.deductCredits(10, 16);
         obj.deductCredits(10, 18);
         obj.addCredits(10, 20, 30);
         obj.deductCredits(15, 18);
         **/

    }

    private void updateBalance() {
    }

    public int get_balance_at(int effective_at) {

        updateBalance();

        int[] top_credits = pq_credits.poll();
        int[] top_deduct_credits = pq_deduct_credits.poll();

        if (top_deduct_credits[1] < effective_at) {
            int top_credit = top_credits[0];
            int top_effective_from = top_credits[1];
            int top_efffective_at = top_credits[2];

            if (effective_at >= top_effective_from && effective_at <= top_efffective_at) {
                if (top_credit > top_deduct_credits[0]) {
                    pq_credits.offer(new int[]{top_credit - top_deduct_credits[0], top_credits[1], top_credits[2]});
                }

                }
            }
        }



    int top_credit = top_credits[0];
        int top_effective_from = top_credits[1];
        int top_efffective_at = top_credits[2];

        if (effective_at >= top_effective_from && effective_at <= top_efffective_at) {
            if (top_credit > credits) {
                pq_credits.offer(new int[]{top_credits[0] - credits, top_credits[1], top_credits[2]});
            } else {
                credits = top_credit - credits;
                deductCredits(credits, effective_at);
            }
        } else {
            // Find the slot
            boolean matchFound = false;
            pq_temp = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);

            while (!(effective_at >= top_effective_from && effective_at <= top_efffective_at)) {
                pq_temp.offer(top_credits);
                top_credits = pq_credits.poll();
                matchFound = true;
            }

            if (matchFound) {
                if (top_credit > credits) {
                    pq_credits.offer(new int[]{top_credits[0] - credits, top_credits[1], top_credits[2]});
                } else {
                    credits = top_credit - credits;
                    deductCredits(credits, effective_at);
                }
            } else {
                System.out.println("No match found");
            }

            while (!pq_temp.isEmpty()) {
                pq_credits.offer(pq_temp.poll());
            }
        }

        int ans = 0;
        pq_temp = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        while (!pq_credits.isEmpty()) {
            int[] top = pq_credits.poll();
            if (effective_at >= top[1] && effective_at <= top[2]) {
                ans += top[0];
            }
            pq_temp.offer(top);
        }

        while (!pq_temp.isEmpty()) {
            pq_credits.offer(pq_temp.poll());
        }

        return ans;

    }

    public void deductCredits(int credits, int effective_at) {
        pq_credits.offer(new int[]{effective_at, credits});
    }

    public void addCredits(int credits, int effective_from, int effective_at) {
        pq_credits.offer(new int[]{credits, effective_from, effective_at});
    }

    public OrbClassCredits() {
        pq_credits = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        pq_deduct_credits = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq_temp = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
    }


}
