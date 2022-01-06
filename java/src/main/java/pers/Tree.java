package pers;

import java.util.*;

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

    /**101
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }

    /**111
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Stack<TreeNode> temp = new Stack<>();
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                if (pop.left == null && pop.right == null) {
                    return res;
                } else {
                    if (pop.left != null) {
                        temp.push(pop.left);
                    }
                    if (pop.right != null) {
                        temp.push(pop.right);
                    }
                }
            }
            res++;
            stack = temp;
        }
        return res;
    }

    /**404
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> left = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Stack<TreeNode> temp = new Stack<>();
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                if (pop.left != null) {
                    temp.push(pop.left);
                    left.push(pop.left);
                }
                if (pop.right != null) {
                    temp.push(pop.right);
                }
            }
            stack = temp;
        }
        while (!left.isEmpty()) {
            TreeNode pop = left.pop();
            if (pop.left == null && pop.right == null) {
                res += pop.val;
            }
        }
        return res;
    }

    /**687
     * @param root
     * @return
     */
    int longestUnivaluePathMax = 0;

    public int longestUnivaluePath(TreeNode root) {
        longestUnivaluePath1(root);
        return longestUnivaluePathMax;
    }

    private int longestUnivaluePath1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = longestUnivaluePath1(root.left);
        int right = longestUnivaluePath1(root.right);
        if (root.left != null && root.val == root.left.val) {
            left++;
        } else {
            left = 0;
        }
        if (root.right != null && root.val == root.right.val) {
            right++;
        } else {
            right = 0;
        }
        int max = Math.max(left, right);
        if (root.left != null && root.right != null && root.val == root.left.val && root.val == root.right.val) {
            max = left + right;
        }
        longestUnivaluePathMax = Math.max(max, longestUnivaluePathMax);
        return Math.max(left, right);
    }

    /**337 丑了点，需要看题解优化下
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        TreeNode dp = copy(root);
        makeDp(dp, root);
        return dp.val;
    }

    private void makeDp(TreeNode dp, TreeNode root) {
        if (root == null) {
            return;
        }
        if (dp.val != -1) {
            return;
        }
        int rootV = root.val;
        int nextLevel = 0;
        makeDp(dp.left, root.left);
        makeDp(dp.right, root.right);
        if (root.left != null) {
            nextLevel += dp.left.val;
            if (root.left.left != null) {
                makeDp(dp.left.left, root.left.left);
                rootV += dp.left.left.val;
            }
            if (root.left.right != null) {
                makeDp(dp.left.right, root.left.right);
                rootV += dp.left.right.val;
            }
        }
        if (root.right != null) {
            nextLevel += dp.right.val;
            if (root.right.left != null) {
                makeDp(dp.right.left, root.right.left);
                rootV += dp.right.left.val;
            }
            if (root.right.right != null) {
                makeDp(dp.right.right, root.right.right);
                rootV += dp.right.right.val;
            }
        }
        dp.val = Math.max(nextLevel, rootV);
    }

    private TreeNode copy(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode dp = new TreeNode();
        dp.val = -1;
        dp.left = copy(root.left);
        dp.right = copy(root.right);
        return dp;
    }

//    /** 超时了
//     * @param root
//     * @return
//     */
//    public int rob(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int rootV = root.val;
//        int left = rob(root.left);
//        int right = rob(root.right);
//        if (root.left != null) {
//            rootV += rob(root.left.left);
//            rootV += rob(root.left.right);
//        }
//        if (root.right != null) {
//            rootV += rob(root.right.left);
//            rootV += rob(root.right.right);
//        }
//        return Math.max(left + right, rootV);
//    }

    /**671
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null) {
            return -1;
        }
        int left = root.left.val;
        int right = root.right.val;
        if (left == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        if (right == root.val) {
            right = findSecondMinimumValue(root.right);
        }
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }
        return Math.min(left, right);
    }

    /**637
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode pop = stack.pop();
                sum += pop.val;
                if (pop.left != null) {
                    stack.add(pop.left);
                }
                if (pop.right != null) {
                    stack.add(pop.right);
                }
            }
            res.add((sum)/size);
        }
        return res;
    }

    /**513
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<TreeNode> last = new LinkedList<>();
        stack.add(root);
        last.add(root);
        while (!stack.isEmpty()) {
            LinkedList<TreeNode> tempLast = new LinkedList<>();
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = stack.pop();
                if (pop.left != null) {
                    stack.add(pop.left);
                    tempLast.add(pop.left);
                }
                if (pop.right != null) {
                    stack.add(pop.right);
                    tempLast.add(pop.right);
                }
            }
            if (!tempLast.isEmpty()) {
                last = tempLast;
            }
        }
        return last.pop().val;
    }

    /**144 递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
        return res;
    }

    private void preorderTraversal(TreeNode left, List<Integer> res) {
        if (left == null) {
            return;
        }
        res.add(left.val);
        preorderTraversal(left.left, res);
        preorderTraversal(left.right, res);
    }

    /**144 循环
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return res;
    }

    /**145 递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        postorderTraversal(root.left, res);
        postorderTraversal(root.right, res);
        res.add(root.val);
        return res;
    }

    private void postorderTraversal(TreeNode left, List<Integer> res) {
        if (left == null) {
            return;
        }
        postorderTraversal(left.left, res);
        postorderTraversal(left.right, res);
        res.add(left.val);
    }

    /**145 循环
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            TreeNode pop = treeNodes.pop();
            res.addFirst(pop.val);
            if (pop.left != null) {
                treeNodes.push(pop.left);
            }
            if (pop.right != null) {
                treeNodes.push(pop.right);
            }
        }
        return res;
    }

    /**94 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
        return res;
    }

    private void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }

    /**94 循环
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode t = root;
        while (t.left != null) {
            stack.push(t.left);
            t = t.left;
        }
        while (!stack.isEmpty()) {
            TreeNode pop1 = stack.pop();
            res.add(pop1.val);
            if (pop1.right != null) {
                stack.push(pop1.right);
                TreeNode temp = pop1.right;
                while (temp.left != null) {
                    stack.push(temp.left);
                    temp = temp.left;
                }
            }
        }
        return res;
    }

}
