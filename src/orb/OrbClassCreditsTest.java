package orb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrbClassCreditsTest {

    private OrbClassCredits obj;

    @BeforeEach
    public void setUp() {
        obj = new OrbClassCredits();
    }

    @Test
    public void testAddCredits() {
        // Scenario 1: Adding credits at different times
        obj.addCredits(5, 15, 23); // Add 5 credits at times 15 and 23
        obj.addCredits(8, 3, 19);  // Add 8 credits at times 3 and 19

        // Check balances after adding credits
        assertEquals(13, obj.get_balance_at(20), "Balance should be 13 at time 20");
        assertEquals(13, obj.get_balance_at(24), "Balance should be 13 at time 24");
        assertEquals(13, obj.get_balance_at(19), "Balance should be 13 at time 19");
        assertEquals(5, obj.get_balance_at(15), "Balance should be 5 at time 15");
        assertEquals(8, obj.get_balance_at(3), "Balance should be 8 at time 3");
    }

    @Test
    public void testDeductCredits() {
        // Setup with added credits
        obj.addCredits(5, 15, 23);
        obj.addCredits(8, 3, 19);

        // Deduct credits
        obj.deductCredits(4, 17); // Deduct 4 credits at time 17

        // Check balances after deduction
        assertEquals(9, obj.get_balance_at(20), "Balance should be 9 at time 20 after deduction");
        assertEquals(9, obj.get_balance_at(24), "Balance should be 9 at time 24 after deduction");
        assertEquals(9, obj.get_balance_at(19), "Balance should be 9 at time 19 after deduction");
        assertEquals(5, obj.get_balance_at(15), "Balance should be 5 at time 15 after deduction");
        assertEquals(8, obj.get_balance_at(3), "Balance should be 8 at time 3 after deduction");
    }

    @Test
    public void testZeroBalanceBeforeCredits() {
        // No credits added yet
        assertEquals(0, obj.get_balance_at(2), "Balance should be 0 at time 2 when no credits are added");
    }

    @Test
    public void testAddAndDeductScenario() {
        // Combination of add and deduct
        obj.addCredits(10, 5, 10);
        obj.deductCredits(3, 6);
        obj.addCredits(2, 8, 12);

        // Check various balances
        assertEquals(7, obj.get_balance_at(7), "Balance should be 7 at time 7");
        assertEquals(9, obj.get_balance_at(12), "Balance should be 9 at time 12");
        assertEquals(10, obj.get_balance_at(5), "Balance should be 10 at time 5");
    }
}

