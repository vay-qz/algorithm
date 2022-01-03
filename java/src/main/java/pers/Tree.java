package pers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        Holder<Integer> res = new Holder();
        res.value = 0;
        diameterOfBinaryTree(root, res);
        return res.value - 1;
    }

    private int diameterOfBinaryTree(TreeNode root, Holder<Integer> res) {
        if (root == null) {
            return 0;
        }
        int left = diameterOfBinaryTree(root.left, res);
        int right = diameterOfBinaryTree(root.right, res);
        int max = res.value;
        if (max < (left + right + 1)) {
            max = left + right + 1;
            res.value = max;
        }
        return Math.max(left, right) + 1;
    }



    /**226 翻转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode res = new TreeNode();
        invertTree(root, res);
        return res;
    }

    private void invertTree(TreeNode root, TreeNode res) {
        if (res == null) {
            return;
        }
        res.val = root.val;
        if (root.left != null) {
            TreeNode right = new TreeNode();
            res.right = right;
            invertTree(root.left, res.right);
        }
        if (root.right != null) {
            TreeNode left = new TreeNode();
            res.left = left;
            invertTree(root.right, res.left);
        }
    }

    /**617 归并两棵树
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode res = new TreeNode(root1.val + root2.val);
        res.left = mergeTrees(root1.left, root2.left);
        res.right = mergeTrees(root1.right, root2.right);
        return res;
    }

    /**路径总和 112
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, root.val, targetSum);
    }

    private boolean hasPathSum(TreeNode root, int i, int targetSum) {
        if (root.left == null && root.right == null) {
            if (i == targetSum) {
                return true;
            }
            return false;
        }
        if (root.left == null) {
            return hasPathSum(root.right, i + root.right.val, targetSum);
        }
        if (root.right == null) {
            return hasPathSum(root.left, i + root.left.val, targetSum);
        }
        return hasPathSum(root.left, i + root.left.val, targetSum) || hasPathSum(root.right, i + root.right.val, targetSum);
    }

    /**路经总和2 113
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        pathSum(root, targetSum, res, temp, root.val);
        return res;
    }

    private void pathSum(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> temp, int i) {
        if (root.left == null && root.right == null) {
            if (targetSum == i) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        if (root.left != null) {
            temp.add(root.left.val);
            pathSum(root.left, targetSum, res, temp, i + root.left.val);
            temp.remove(temp.size() - 1);
        }
        if (root.right != null) {
            temp.add(root.right.val);
            pathSum(root.right, targetSum, res, temp, i + root.right.val);
            temp.remove(temp.size() - 1);
        }
    }

    /**437 路经总和3
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum3(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        HashMap<Integer, Integer> res = new HashMap<>();
        res.put(0, 1);
        return pathSum3(root, targetSum, res, 0);
    }

    private int pathSum3(TreeNode root, int targetSum, HashMap<Integer, Integer> res, int curr) {
        if (root == null) {
            return 0;
        }
        curr += root.val;
        int now = res.getOrDefault(curr - targetSum, 0);
        res.put(curr, res.getOrDefault(curr, 0) + 1);
        now += pathSum3(root.left, targetSum, res, curr);
        now += pathSum3(root.right, targetSum, res, curr);
        res.put(curr, res.getOrDefault(curr, 0) - 1);
        return now;
    }

    class Holder<T> {
        public T value;
    }

    /**572
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        Stack<TreeNode> stack = getStack(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val == subRoot.val && compare(node, subRoot)) {
                return true;
            }
        }
        return false;
    }

    private boolean compare(TreeNode node, TreeNode subRoot) {
        if (node == null && subRoot == null) {
            return true;
        }
        if (node == null || subRoot == null) {
            return false;
        }
        boolean same = node.val == subRoot.val;
        return same && compare(node.left, subRoot.left) && compare(node.right, subRoot.right);
    }

    private Stack<TreeNode> getStack(TreeNode root) {
        Stack<TreeNode> res = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();
        res.push(root);
        temp.push(root);
        while (!temp.isEmpty()) {
            TreeNode pop = temp.pop();
            if (pop.left != null) {
                temp.push(pop.left);
                res.push(pop.left);
            }
            if (pop.right != null) {
                temp.push(pop.right);
                res.push(pop.right);
            }
        }
        return res;
    }

}
