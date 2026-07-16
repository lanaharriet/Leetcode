// Last updated: 7/16/2026, 4:10:04 PM
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

    TreeMap<Integer,                    //stores column in order -> coz our first sorting is on basis of col

            TreeMap<Integer,            // stores row in stored order -> coz our 2nd sorting is on basis of row

            PriorityQueue<Integer>>>          //pq stores val -> coz our 3rd sorting is on basis of val

     map = new TreeMap<>();





    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        func(root,0,0);

        List<List<Integer>> ans = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> list = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {

                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }

            ans.add(list);
        }

        return ans;
        
    }



    // function which adds to data structure
    public  void func(TreeNode root, int cr, int cc){
        if(root==null) return;
        
        map.putIfAbsent(cc,new TreeMap<>());

        map.get(cc).putIfAbsent(cr,new PriorityQueue<>());

        map.get(cc).get(cr).offer(root.val);

        func(root.left,cr+1,cc-1);

        func(root.right,cr+1,cc+1);
    }
    
}