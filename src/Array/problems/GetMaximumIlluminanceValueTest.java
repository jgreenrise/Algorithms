package Array.problems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GetMaximumIlluminanceValueTest {

    GetMaximumIlluminanceValue illumance;

    @Test
    public void getMaxIlluminanceValueWithEmptyMatrix() {
        illumance = new GetMaximumIlluminanceValue();
        // 4 by 5
        String[][] matrix = {};
        assertEquals(0, illumance.getMaxIlluminanceValue(matrix));
    }

    @Test
    public void getMaxIlluminanceValueWithNullMatrix() {
        illumance = new GetMaximumIlluminanceValue();
        // 4 by 5
        String[][] matrix = null;
        assertEquals(0, illumance.getMaxIlluminanceValue(matrix));
    }

    /**
     * ╔══╦═══╦═══╦═══╦══╗
     * ║  ║   ║   ║   ║  ║
     * ╠══╬═══╬═══╬═══╬══╣
     * ║  ║ L ║   ║   ║  ║
     * ╠══╬═══╬═══╬═══╬══╣
     * ║  ║ R ║   ║ L ║  ║
     * ╠══╬═══╬═══╬═══╬══╣
     * ║  ║   ║   ║   ║  ║
     * ╚══╩═══╩═══╩═══╩══╝
     */
    @Test
    public void getMaxIlluminanceValue_with1Rock2lightHouse() {
        illumance = new GetMaximumIlluminanceValue();
        // 4 by 5
        String[][] matrix = new String[4][5];
        matrix[1][1] = "L";
        matrix[2][1] = "R";
        matrix[2][3] = "L";
        assertEquals(2, illumance.getMaxIlluminanceValue(matrix));
    }


    /**
     * ╔══╦═══╦═══╦═══╦══╗
     * ║  ║   ║   ║   ║  ║
     * ╠══╬═══╬═══╬═══╬══╣
     * ║  ║ L ║   ║   ║  ║
     * ╠══╬═══╬═══╬═══╬══╣
     * ║  ║ L ║   ║ L ║  ║
     * ╠══╬═══╬═══╬═══╬══╣
     * ║  ║   ║   ║   ║  ║
     * ╚══╩═══╩═══╩═══╩══╝
     */
    @Test
    public void getMaxIlluminanceValue_with3lightHouse() {
        illumance = new GetMaximumIlluminanceValue();
        // 4 by 5
        String[][] matrix = new String[4][5];
        matrix[1][1] = "L";
        matrix[2][1] = "L";
        matrix[2][3] = "L";
        assertEquals(2, illumance.getMaxIlluminanceValue(matrix));
    }

    /**
     * ╔══╦═══╦═══╦═══╦══╗
     * ║  ║   ║ L ║   ║  ║
     * ╠══╬═══╬═══╬═══╬══╣
     * ║  ║ L ║   ║   ║  ║
     * ╠══╬═══╬═══╬═══╬══╣
     * ║  ║   ║   ║ L ║  ║
     * ╠══╬═══╬═══╬═══╬══╣
     * ║  ║   ║ L ║   ║  ║
     * ╚══╩═══╩═══╩═══╩══╝
     */
    @Test
    public void getMaxIlluminanceValue_with4lightHouse() {
        illumance = new GetMaximumIlluminanceValue();
        // 4 by 5
        String[][] matrix = new String[4][5];
        matrix[1][1] = "L";
        matrix[0][2] = "L";
        matrix[2][3] = "L";
        matrix[3][2] = "L";
        assertEquals(3, illumance.getMaxIlluminanceValue(matrix));
    }

    /**
     * ╔══╦═══╦═══╦═══╦══╗
     * ║  ║   ║   ║   ║  ║
     * ╠══╬═══╬═══╬═══╬══╣
     * ║  ║   ║   ║   ║  ║
     * ╠══╬═══╬═══╬═══╬══╣
     * ║  ║   ║   ║   ║  ║
     * ╠══╬═══╬═══╬═══╬══╣
     * ║  ║   ║   ║   ║ L║
     * ╚══╩═══╩═══╩═══╩══╝
     */
    @Test
    public void getMaxIlluminanceValue_with1lightHouse() {
        illumance = new GetMaximumIlluminanceValue();
        // 4 by 5
        String[][] matrix = new String[4][5];
        matrix[3][4] = "L";
        assertEquals(1, illumance.getMaxIlluminanceValue(matrix));
    }

    /**
     * ╔══╦═══╦═══╦═══╦══╗
     * ║  ║   ║   ║   ║  ║
     * ╠══╬═══╬═══╬═══╬══╣
     * ║  ║   ║   ║   ║  ║
     * ╠══╬═══╬═══╬═══╬══╣
     * ║  ║   ║ R ║   ║  ║
     * ╠══╬═══╬═══╬═══╬══╣
     * ║  ║   ║   ║   ║  ║
     * ╚══╩═══╩═══╩═══╩══╝
     */
    @Test
    public void getMaxIlluminanceValue_with1RockNolightHouse() {
        illumance = new GetMaximumIlluminanceValue();
        // 4 by 5
        String[][] matrix = new String[4][5];
        matrix[2][3] = "R";
        assertEquals(0, illumance.getMaxIlluminanceValue(matrix));
    }
}