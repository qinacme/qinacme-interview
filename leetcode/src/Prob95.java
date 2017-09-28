import java.util.ArrayList;
import java.util.List;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Prob95 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (n==1){
            res.add(new TreeNode(1));
        }
        if (n>1){
            List<TreeNode> temp = generateTrees(n-1);
            for (TreeNode t : temp){
                // Case1: n as the new tree's leave
                TreeNode pt = t;
                TreeNode nLeaveTree;
                TreeNode npt;
                int count = 1;
                while (pt.right!=null){
                    pt = pt.right;
                    count ++;
                }
                for (int i=0;i<count;i++){
                    nLeaveTree = new TreeNode(t.val);
                    nLeaveTree.left = t.left;
                    npt = nLeaveTree;
                    pt = t;
                    for (int j=0;j<i;j++){
                        pt = pt.right;
                        npt.right = new TreeNode(pt.val);
                        npt.right.left = pt.left;
                        npt = npt.right;
                    }
                    npt.right = new TreeNode(n);
                    npt.right.left = pt.right;
                    res.add(nLeaveTree);
                }
            }
            for (TreeNode t : temp){
                // Case2: n as the new tree's root
                TreeNode nRootTree = new TreeNode(n);
                nRootTree.left = t;
                res.add(nRootTree);
            }
        }
        return res;
    }
}
