import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Prob433 {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end))
            return 0;
        Set<String> bankSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        char[] charSet = new char[]{'A','C','G','T'};
        Queue<String> queue = new LinkedList<>();
        for (String s : bank) bankSet.add(s);
        queue.offer(start);
        visited.add(start);
        int level =0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- >0){
                String cur = queue.poll();
                if (cur.equals(end))
                    return level;
                char[] curArray = cur.toCharArray();
                for (int i=0;i<curArray.length;i++){
                    char old = curArray[i];
                    for (char c: charSet){
                        curArray[i] = c;
                        String next = new String(curArray);
                        if (!visited.contains(next) && bankSet.contains(next)){
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    curArray[i] = old;
                }
            }
            level ++;
        }
        return -1;

    }
}
