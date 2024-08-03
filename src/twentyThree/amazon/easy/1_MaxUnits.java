package twentyThree.amazon.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/maximum-units-on-a-truck/
 * 
 * You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.

 

Example 1:

Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
Output: 8
Explanation: There are:
- 1 box of the first type that contains 3 units.
- 2 boxes of the second type that contain 2 units each.
- 3 boxes of the third type that contain 1 unit each.
You can take all the boxes of the first and second types, and one box of the third type.
The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
Example 2:

Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
Output: 91
 

Constraints:

1 <= boxTypes.length <= 1000
1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
1 <= truckSize <= 106

 */
class Solution {

    public static void main(String args[]) {
        
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> (a[1] - b[1]));
        Arrays.sort(boxTypes, Comparator.comparingInt(o -> o[0]));

        
        return findMaxUnits(0, truckSize, boxTypes);
    }

    public int findMaxUnits(int currIndex, int truckSize, int[][] boxTypes){

        if(currIndex >= boxTypes.length){
            return 0;
        }

        if(truckSize - boxTypes[currIndex][0] > 0){
            int maxUnits = findMaxUnits(currIndex++, truckSize - boxTypes[currIndex][0], boxTypes);
            return maxUnits + boxTypes[currIndex][0] * boxTypes[currIndex][1]; 
        }else if(truckSize - boxTypes[currIndex][1] < 0){ 
            // less than 0
            int maxunits = 0;
            int numberofBox = boxTypes[currIndex][0];
            int unitsInBox = boxTypes[currIndex][1];
            while(numberofBox - truckSize != 0){
                numberofBox--;
            }
            return numberofBox * unitsInBox;
        }else{
            // Equal to zero
            return boxTypes[currIndex][0] * boxTypes[currIndex][1];
        }


    }
}