package pers;

import java.util.Stack;

/**
 * @author qiaozhe
 * @date 2021/12/26
 */
public class Tree {

    /**104
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 1;
        while (true) {
            Stack<TreeNode> stack2 = new Stack<>();
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                if (pop.left != null) {
                    stack2.push(pop.left);
                }
                if (pop.right != null) {
                    stack2.push(pop.right);
                }
            }
            if (stack2.isEmpty()) {
                break;
            }
            sum++;
            stack = stack2;
        }
        return sum;
    }

    /**110
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode left) {
        if (left == null) {
            return 0;
        }
        return Math.max(height(left.left), height(left.right)) + 1;
    }

    /**543
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        return 0;
    }

}
