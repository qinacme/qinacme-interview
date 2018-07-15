import java.util.*;

public class Solution {
    static Set<Character> n1s = new HashSet<>();
    static Set<Character> n2s = new HashSet<>();
    public static void main(String[] args) {
        System.out.print("{");
        for (int i=1;i<10001;i++){
            System.out.print(helper(i)+",");
        }
        System.out.print("}");
    }
    public static int helper(int N) {
        n1s.add('0');
        n1s.add('1');
        n1s.add('8');
        n2s.add('2');
        n2s.add('5');
        n2s.add('6');
        n2s.add('9');
        int count = 0;
        for (int i=1;i<=N;i++){
            if (isGoodNumber(i))
                count++;
        }
        return count;
    }
    public static boolean isGoodNumber(int n){
        String s = n+"";
        boolean containsChange = false;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (n2s.contains(c)){
                containsChange = true;
            } else if (n1s.contains(c)){
                continue;
            } else {
                return false;
            }
        }
        return containsChange;
    }
}