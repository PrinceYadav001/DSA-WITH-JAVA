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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> lst = new ArrayList<>();
        if(root==null){
            return lst;
        }
        solution(root ,"" , lst);
        return lst;
    }
    public static void solution(TreeNode root , String path , List<String> lst){
        if(root==null){
            return;
        }
        path += root.val;
        if(root.left ==null && root.right==null){
            lst.add(path);
            return ;
        }
        path+="->";
        solution(root.left , path , lst);
        solution(root.right , path , lst);

    }
}