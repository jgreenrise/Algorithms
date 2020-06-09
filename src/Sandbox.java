import java.util.*;

class Solution {

    public static void main(String[] args) {

        Solution class1 = new Solution();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println("Ladder length: "+class1.ladderLength(beginWord, endWord, wordList));

        beginWord = "hot";
        endWord = "dog";
        wordList = Arrays.asList(new String[]{"hot", "dog"});
        //System.out.println("Ladder length:"+class1.ladderLength(beginWord, endWord, wordList));

        beginWord = "hit";
        endWord = "cog";
        wordList = Arrays.asList(new String[]{"hot","cog","dot","dog","hit","lot","log"});
        //System.out.println("Ladder length:"+class1.ladderLength(beginWord, endWord, wordList));

        beginWord = "qa";
        endWord = "sq";
        wordList = Arrays.asList(new String[]{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"});
        //System.out.println("Ladder length:"+class1.ladderLength(beginWord, endWord, wordList));

        beginWord = "hot";
        endWord = "dog";
        wordList = Arrays.asList(new String[]{"hot","dog","cog","pot","dot"});
        //System.out.println("Ladder length:"+class1.ladderLength(beginWord, endWord, wordList));

        beginWord = "cet";
        endWord = "ism";
        wordList = Arrays.asList(new String[]{"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"});
        //System.out.println("Ladder length:"+class1.ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        // COUNT NUMBER OF WORDS TRANSFORMED
        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // FOR ALL WORDS THIS ROUND
            for (int i = 0; i < size; i++) {
                char[] current = queue.poll().toCharArray();

                // TRAVERSE CURRENT WORD
                for (int j = 0; j < current.length; j++) {
                    char tmp = current[j];

                    // CHANGE ONE LETTER AT A TIME
                    for (char c = 'a'; c <= 'z'; c++) {
                        current[j] = c;
                        String next = new String(current);

                        // WHEN NEXT WORD IS IN THE SET
                        if (set.contains(next)) {
                            if (next.equals(endWord)) return count + 1;
                            queue.add(next);
                            set.remove(next);
                        }
                    }
                    // HAVE TO UNDO FOR NEXT CHANGE OF LETTER
                    current[j] = tmp;
                }
            }

            // THIS ROUND ENDS WITH ONE LETTER CHANGED
            count++;
        }
        return 0;
    }

    /**
     * Works but throws OOM
     */
    public int ladderLengthUsingCustomClass(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<CustomWordList> queue = new LinkedList<>();
        set.remove(beginWord);
        queue.add(new CustomWordList(beginWord, set, 0));
        int count = 1;

        if(!set.contains(endWord))
            return 0;

        if(set.contains(beginWord)){
            set.remove(beginWord);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            CustomWordList parent = queue.poll();

            if (parent.word.equals(endWord))
                return parent.counter+1;

            String[] siblings = getSiblings(parent.word, parent.words);
            for (String sibling:siblings){
                Set newSet = new HashSet();
                newSet.addAll(parent.words);
                newSet.remove(sibling);
                queue.add(new CustomWordList(sibling, newSet, parent.counter+1));
            }
            count++;
        }
        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

        Map<String, Integer> memo = new HashMap<>();
        Set<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord))
            return 0;

        int max = wordLadder(beginWord, endWord, 0, set, memo);
        return  max == Integer.MAX_VALUE ? 0 : max ;

    }

    public int wordLadder(String begin, String end, int counter, Set<String> words, Map<String, Integer> memo) {

        System.out.println("begin: "+begin);

        if(memo.containsKey(begin)){
            return memo.get(begin);
        }


        int out = Integer.MAX_VALUE;

        if (isSimilarToEnd(begin, end)) {
            return counter+2;
        } else {

            String[] siblings = getSiblings(begin, words);

            if (siblings.length == 0) {
                return Integer.MAX_VALUE;
            } else {
                for (int j = 0; j < siblings.length; j++) {
                    Set<String> newSet = new HashSet<>();
                    newSet.addAll(words);
                    newSet.remove(siblings[j]);
                    int ladderCount = 0;
                    if(siblings[j] == begin){
                        ladderCount = wordLadder(siblings[j], end, counter, newSet, memo);
                    }else{
                        ladderCount = wordLadder(siblings[j], end, counter + 1, newSet, memo);
                    }
                    memo.put(siblings[j], ladderCount);
                    out = Math.min(out, ladderCount);
                }
            }

        }

        return out;


    }

    private String[] getSiblings(String begin, Set<String> words) {

        return words
                .stream()
                .filter(Objects::nonNull)
                //.filter(a -> !a.equalsIgnoreCase(begin))
                .filter(a -> isSimilarToEnd(begin, a))
                .toArray(String[]::new);


    }

    private boolean isSimilarToEnd(String left, String right) {

        int counter = 0;
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) == right.charAt(i)) {
                continue;
            } else {
                counter++;
            }
        }

        return counter < 2;
    }

    private class CustomWordList {

        String word;
        Set<String> words;
        int counter=0;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public CustomWordList(String word, Set<String> words, int counter) {
            this.word = word;
            this.words = words;
            this.counter = counter;
        }

    }
}

