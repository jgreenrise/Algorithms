import java.util.HashMap;
import java.util.Map;

public class a_0091_DecodeWays {

    public static void main(String[] args) {

        a_0091_DecodeWays obj = new a_0091_DecodeWays();
        System.out.println(obj.numDecodingsv1("125212019"));
    }


    public int numDecodingsv1(String s) {

        Map<Integer, Integer> map = new HashMap<>();
        return numDecodingsByRange(s, 0, map);
    }

    public int numDecodingsByRange(String s, int idx, Map map) {

        if (map.containsKey(idx)) return (int) (map.get(idx));
        if (idx == s.length()) return 1;
        if (s.charAt(idx) == '0') return 0;

        int resp = numDecodingsByRange(s, idx + 1, map);
        if (idx + 1 < s.length() && Integer.valueOf(s.substring(idx, idx + 2)) <= 26) {
            resp = resp + numDecodingsByRange(s, idx + 2, map);
        }

        map.put(idx, resp);
        return resp;
    }

}