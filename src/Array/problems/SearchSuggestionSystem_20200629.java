package Array.problems;

import java.util.*;

public class SearchSuggestionSystem_20200629 {

    public Tri root;

    public SearchSuggestionSystem_20200629() {
        root = new Tri();
    }

    public static void main(String[] args) {

        String[] products = {"apple", "bannana", "choclate", "car", "camry", "camp", "campacola", "dog", "elephant", "google"};
        String searchedWord = "camp";

        products = new String [] {"mobile","mouse","moneypot","monitor","mousepad"};
        searchedWord = "mouse";

/*        products = new String [] { "havana"};
        searchedWord = "havana";

        products = new String [] { "bags","baggage","banner","box","cloths"};
        searchedWord = "bags";

 */

        products = new String [] { "havana"};
        searchedWord = "tatiana";



        System.out.println(suggestedProducts(products, searchedWord));

    }


    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        Arrays.sort(products);
        List<String> listProds = Arrays.asList(products);

        for (int i = 0; i < products.length; i++) {
            map.put(products[i], i);
        }

        StringBuilder sbr = new StringBuilder();
        List<String> currOut = new ArrayList<>();
        for (char ch: searchWord.toCharArray()) {
            sbr.append(ch);
            String key = sbr.toString();
            String ceilingKey = map.ceilingKey(key);
            String floorKey = map.floorKey(key + "~");
            if (ceilingKey == null || floorKey == null) {
                res.add(new ArrayList<>());
                continue;
            }


            // Starting word that matches char ch
            int ceiling = map.get(ceilingKey);

            // Last word index that matches char ch
            int floor = map.get(floorKey);

            if(floor - ceiling >= 3){
                res.add(listProds.subList(ceiling, ceiling+3));
            }else{
                res.add(listProds.subList(ceiling, floor+1));
            }
        }

        return res;
        
    }

    public static List<List<String>> suggestedProductsUsingTri(String[] products, String searchWord) {

        List<List<String>> out = new ArrayList();
        SearchSuggestionSystem_20200629 solution = new SearchSuggestionSystem_20200629();
        for (int j = 0; j < products.length; j++) {
            solution.buildTri(products[j], j);
        }

        StringBuilder sbr = new StringBuilder();
        for (int j = 0; j < searchWord.length(); j++) {
            sbr.append(searchWord.charAt(j));
            solution.searchWord(sbr.toString(), out, products);
        }

        return out;


    }

    public void searchWord(String str, List<List<String>> out, String[] products) {
        Tri curr = root;
        int index = 0;
        boolean matchFound = false;

        while (index < str.length()) {
            if (curr.map.containsKey(str.charAt(index))) {
                curr = curr.map.get(str.charAt(index));
                index++;
                matchFound = true;
            } else {
                // Do something here
                matchFound = false;
                break;
            }
        }

        List<String> currOut = new ArrayList();
        if (!matchFound) {
            out.add(currOut);
        } else {
            fetchThreeWordsFromThisIndex(currOut, 3, curr, products);
            out.add(currOut);
        }

    }


    public boolean fetchThreeWordsFromThisIndex(List<String> out, int count, Tri node, String[] products) {

        TreeMap<Character, Tri> map = (TreeMap) node.map;
        boolean matchFound = false;

        if (node.isEndOfWord) {
            out.add(products[node.index]);
            if (out.size() == count) {
                return true;
            }
        }

        for (Character ch : map.keySet()) {

            Tri newNode = node.map.get(ch);
            matchFound = fetchThreeWordsFromThisIndex(out, count, newNode, products);
            if (matchFound) {
                break;
            }
        }

        return matchFound;

    }

    public void buildTri(String product, int index) {

        Tri curr = root;
        char[] chars = product.toCharArray();

        for (int j = 0; j < chars.length; j++) {
            char ch = chars[j];

            if (!curr.map.containsKey(ch)) {
                Tri newNode = new Tri();
                curr.map.putIfAbsent(ch, newNode);
                curr = newNode;
            } else {
                curr = curr.map.get(ch);
            }

        }

        curr.isEndOfWord = true;
        curr.index = index;

    }

    public class Tri {
        Map<Character, Tri> map;
        boolean isEndOfWord;
        int index;

        public Tri() {
            map = new TreeMap();
        }
    }

}
