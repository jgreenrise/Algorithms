package tree.problems;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog");

		start = "red";
		end = "tax";
		words = Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");

        Solution class1 = new Solution();
        System.out.println(class1.ladderLength(start, end, words));

    }

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	Queue<String> q = new LinkedList<>();
    	q.add("1-"+beginWord);
    	Set<String> excludeList = new HashSet<>();
    	excludeList.add(beginWord);

    	while(!q.isEmpty()){

    		String pop = q.poll();
    		List<String> childrens = getChildrens(pop, wordList, excludeList);

    		if(childrens.isEmpty())
    			continue;
    		else{
    			boolean isEndWord = isEndWord(childrens, endWord, q);
    			if(isEndWord)
    				return Integer.parseInt(pop.split("-")[0]) + 1;
			}
		}

    	return 0;

    }

	private boolean isEndWord(List<String> children, String endWord, Queue<String> q) {

    	for(String str: children){
    		if((str.split("-")[1]).equalsIgnoreCase(endWord))
    			return true;
    		else
    			q.add(str);
		}

    	return false;

	}

	private List<String> getChildrens(String stringWithTreeLevel, List<String> wordList, Set<String> excludeList) {

    	String[] strArr = stringWithTreeLevel.split("-");
    	String str = strArr[1];

    	List<String> out = new ArrayList<>();
    	Set<String> set = new HashSet<>(wordList);

    	for(int j =0 ; j < str.length(); j++){

			String right = "";
			String left = "";

    		if(j == 0){
    			right = str.substring(1);
    			left = "";
			}else{
    			left = str.substring(0, j);
    			right = j+1 < str.length()  ? str.substring(j+1) : right;
			}

			for (char ch = 'a';  ch <= 'z' ; ++ch)
				if(set.contains(left + ch +right) && !excludeList.contains(left + ch +right)){
					out.add((Integer.parseInt(strArr[0]) + 1)+ "-"+left + ch +right);
					excludeList.add(left+ch+right);
				}
		}
    	return out;
	}
}