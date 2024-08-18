import java.util.\*;

public class a_0049_GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> out = new ArrayList();
        Map<String, List<String>> map = new HashMap();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            if (map.containsKey(sortedStr)) {
                List<String> list = map.get(sortedStr);
                list.add(str);
                map.put(sortedStr, list);
            } else {
                List<String> list = new ArrayList();
                list.add(str);
                map.put(sortedStr, list);
            }
        }

        int index = 0;
        for (String key : map.keySet()) {
            List currList = map.get(key);
            out.add(index++, currList);
        }

        return out;
    }

}
