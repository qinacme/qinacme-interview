public class Prob392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length()==0)
            return true;
        if (t.length()==0)
            return false;
        int spt = 0;
        int tpt = 0;
        while (spt<s.length() && tpt<t.length()){
            char curChar = s.charAt(spt);
            while (tpt<t.length()){
                if (t.charAt(tpt) == curChar){
                    tpt++;
                    spt++;
                    break;
                }
                tpt++;
            }
        }
        return spt == s.length();
    }
}
