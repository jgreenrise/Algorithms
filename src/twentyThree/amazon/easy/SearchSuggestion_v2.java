package twentyThree.amazon.easy;

import java.util.*;

public class SearchSuggestion_v2 {

    public Tri root;

    public SearchSuggestion_v2() {
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
        
        products = new String [] { "havana"};
        searchedWord = "tatiana";

 */





        System.out.println(suggestedProducts(products, searchedWord));

    }
    
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);
        Tri node = new Tri();
        for(int j = 0; j <products.length; j++){
        	char [] chars = (products[j]).toCharArray();
        	
        	for(int k =0 ; k < chars.length; k++) {
        		
        		if(node.map.containsKey(chars[k])) {
        			node = node.map.get(chars[k]);
        		}else {
        			Tri newNode = new Tri(chars[k], false);
        			
        		}
        		
        	}
        	
        	node.isEndOfWord = true;
        	
        }
		return null;
        
    }

    public static Tri buildTrietree(String currWord, Tri node, int currIndex){
    	
        if(currIndex == currWord.length()){
            return new Tri(true, ' ', null);
        }
    	
    	char ch = currWord.charAt(currIndex);
    	Map<Character, Tri> children = node.map;
    	
    	
    	if(children.containsKey(ch)) {
    		Tri childNode = (node.map).get(ch);
    		return buildTrietree(currWord, (node.map).get(ch), currIndex + 1);
    	}
    	else {
    		Tri childNode = buildTrietree(currWord, node, currIndex + 1);
    		HashMap map = new HashMap();
    		map.put(childNode.value, childNode);
    		Tri primaryNode = new Tri(false, ch, map);
    		return primaryNode;
    	}

    }


    
    public static class Tri {
        public boolean isEndOfWord;
		public char value;
        public Map<Character, Tri> map;

        public Tri(boolean isEndOfWord, char value, Map<Character, Tri> map){
            this.isEndOfWord = isEndOfWord;
            this.value = value;
            this.map = map;
        }

		public Tri() {
			// TODO Auto-generated constructor stub
			map = new HashMap();
		}

		public Tri(char value, boolean isEndOfWord) {
			// TODO Auto-generated constructor stub
			// TODO Auto-generated constructor stub
            this.isEndOfWord = isEndOfWord;
            this.value = value;
						map = new HashMap();
		}

		public boolean isEndOfWord() {
			return isEndOfWord;
		}

		public void setEndOfWord(boolean isEndOfWord) {
			this.isEndOfWord = isEndOfWord;
		}

		public char getValue() {
			return value;
		}

		public void setValue(char value) {
			this.value = value;
		}

		public Map<Character, Tri> getMap() {
			return map;
		}

		public void setMap(Map<Character, Tri> map) {
			this.map = map;
		}
		
		
    }

}
