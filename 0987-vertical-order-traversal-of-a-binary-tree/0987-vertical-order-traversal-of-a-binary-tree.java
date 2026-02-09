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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,List<int[]>> map=new TreeMap<>();
        dfs(root,0,0,map);
        List<List<Integer>>result=new ArrayList<>();
        for(List<int[]>list:map.values()){
            Collections.sort(list, (a, b) -> {

                if(a[0] !=b[0])return a[0] -b[0];
                return a[1] -b[1];
            });
            List<Integer>colList=new ArrayList<>();
            for(int[] pair: list){
                colList.add(pair[1]);
            }
            result.add(colList);
            }
            return result;
            }
            private void dfs(TreeNode node,int row,int col,Map<Integer,List <int[]>>map){
                if(node==null) return;
                map.computeIfAbsent(col,k->new ArrayList<>()).add(new int[]{row,node.val});
                dfs(node.left,row+1,col-1,map);
                dfs(node.right,row+1,col+1,map);
            }
        }
        
    