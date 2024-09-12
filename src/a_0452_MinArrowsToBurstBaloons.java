import java.util.Arrays;

public class a_0452_MinArrowsToBurstBaloons {
    // [[10,16],[2,8],[1,6],[7,12]]

    public int findMinArrowShots(int[][] points) {

        //Arrays.sort(points, (a,b) -> a[0]-b[0]);    // After sorting: 1,6   2,8     7,12    10,16
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));    // After sorting: 1,6   2,8     7,12    10,16
        //System.out.println("Point: "+Arrays.toString(points[0]));

        int arrows = 1;
        int[] prevpoint = points[0];

        //System.out.println("Points: "+Arrays.toString(points));
        // System.out.println("Condition 1: >");
        for (int j = 1; j < points.length; j++) {
            int[] point = points[j];       // 2,8  7,12    10,16
            int a = prevpoint[0];           // 1    2       7
            int b = prevpoint[1];           // 6    6       12
            int c = point[0];               // 2    7       10
            int d = point[1];               // 8    12      16

            if (c == a) {
                /**
                 1,4:1,8> 1:4        1,4:1,3: 1,3
                 */
                prevpoint = new int[]{c, Math.min(b, d)};
                //System.out.println("Condition 1: > a:"+a+", b:"+b+", c:"+c+", d: "+d+", prev point: "+Arrays.toString(prevpoint));
            } else if (c <= b) {   // 2 < 6  10 <=12
                /**
                 1,2:2,3 > 2:2  1,5:4,6> 4:5    1,5:4:6 >4:5
                 1,6:2,8 > 2:6
                 */
                prevpoint = new int[]{c, Math.min(b, d)};
                //System.out.println("Condition 2: > a:"+a+", b:"+b+", c:"+c+", d: "+d+", prev point: "+Arrays.toString(prevpoint));
            } else if (c > b) {
                /**
                 2,6:7:12 > 7:12
                 */
                prevpoint = point;
                arrows++;   // 2
                //System.out.println("Condition 3: > a:"+a+", b:"+b+", c:"+c+", d: "+d+", prev point: "+Arrays.toString(prevpoint));
            }

        }
        return arrows;
    }
}
