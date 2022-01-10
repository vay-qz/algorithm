package pers;

import java.util.Stack;

/**
 * @author qiaozhe
 * @date 2022/1/6
 */
public class BSTTree {

    /**669
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    /**230
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode t = root;
        while (t.left != null) {
            stack.push(t.left);
            t = t.left;
        }
        while (!stack.isEmpty()) {
            k--;
            TreeNode pop1 = stack.pop();
            if (k == 0) {
                return pop1.val;
            }
            if (pop1.right != null) {
                stack.push(pop1.right);
                TreeNode temp = pop1.right;
                while (temp.left != null) {
                    stack.push(temp.left);
                    temp = temp.left;
                }
            }
        }
        return -1;
    }

    /**538
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        convertBST(root, 0);
        return root;
    }

    private int convertBST(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        int rightSum = convertBST(root.right, val);
        root.val += rightSum;
        if (root.right == null) {
            root.val += val;
        }
        int leftSum = convertBST(root.left, root.val);
        if (root.left != null) {
            return leftSum;
        }
        return root.val;
    }

}
