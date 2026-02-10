/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,new ArrayList<>());
        return ans;
    }
    void dfs(TreeNode root,int sum,List<Integer>path){
        if(root==null) return;
        path.add(root.val);
        sum-=root.val;
        if(root.left==null && root.right==null && sum==0){
            ans.add(new ArrayList<>(path));
        }
        dfs(root.left,sum,path);
        dfs(root.right,sum,path);
        path.remove(path.size()-1);
    }
}
        

    