import java.util.Arrays;
import java.util.List;

public class Prob120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len==1)
            return triangle.get(0).get(0);
        int[] minPath = new int[len], tempPath;
        minPath[0]=triangle.get(0).get(0);
        for (int i=1;i<len;i++){
            tempPath = minPath;
            List<Integer> curRow = triangle.get(i);
            minPath = new int[len];
            minPath[0]=curRow.get(0)+tempPath[0];
            for (int j=1;j<i;j++){
                minPath[j] = curRow.get(j)+Math.min(tempPath[j-1],tempPath[j]);
            }
            minPath[i]=curRow.get(i)+tempPath[i-1];
            tempPath=null;
        }
        int res = Integer.MAX_VALUE;
        for (int path:minPath){
            if (path<res)
                res=path;
        }
        return res;
    }
}
