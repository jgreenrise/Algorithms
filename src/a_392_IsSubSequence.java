public class a_392_IsSubSequence {
    public boolean isSubsequence(String s, String t) {
        return isSubsequence(s, t, 0, 0);
    }

    public boolean isSubsequence(String s, String t, int lIdx, int rIdx){

        if(lIdx >= s.length())    return true;
        if(rIdx >= t.length()) return false;

        if(s.charAt(lIdx) == t.charAt(rIdx)){
            return isSubsequence(s, t, lIdx + 1, rIdx + 1);
        }else{
            return isSubsequence(s, t, lIdx, rIdx + 1);
        }
    }
}
