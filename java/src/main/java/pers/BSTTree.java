package pers;

import java.util.*;

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

    /**235
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> p1 = new LinkedList<>();
        LinkedList<TreeNode> p2 = new LinkedList<>();
        makeList(root, p, p1);
        makeList(root, q, p2);
        int index = 0;
        int size = Math.min(p1.size(), p2.size());
        for (int i = 0; i < size; i++) {
            if (p1.get(i).val == p2.get(i).val) {
                index = i;
            } else {
                break;
            }
        }
        return p1.get(index);
    }

    private void makeList(TreeNode root, TreeNode p, LinkedList<TreeNode> node) {
        node.add(root);
        if (root.val == p.val) {
            return;
        }
        if (root.val > p.val) {
            makeList(root.left, p, node);
        }
        if (root.val < p.val) {
            makeList(root.right, p, node);
        }
    }

    /**236
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> p1 = new LinkedList<>();
        LinkedList<TreeNode> p2 = new LinkedList<>();
        findPath(root, p, p1);
        findPath(root, q, p2);
        int index = 0;
        int size = Math.min(p1.size(), p2.size());
        for (int i = 0; i < size; i++) {
            if (p1.get(i).val == p2.get(i).val) {
                index = i;
            } else {
                break;
            }
        }
        return p1.get(index);
    }

    private boolean findPath(TreeNode root, TreeNode p, LinkedList<TreeNode> p1) {
        if (root == null) {
            return false;
        }
        if (root.val == p.val) {
            p1.addFirst(root);
            return true;
        }
        if (findPath(root.left, p, p1)) {
            p1.addFirst(root);
            return true;
        }
        if (findPath(root.right, p, p1)) {
            p1.addFirst(root);
            return true;
        }
        return false;
    }

    /**108
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeBST(nums, 0, mid - 1);
        root.right = makeBST(nums, mid + 1, nums.length - 1);
        return root;
    }

    private TreeNode makeBST(int[] nums, int i, int i1) {
        if (i1 < i) {
            return null;
        }
        if (i == i1) {
            return new TreeNode(nums[i]);
        }
        int mid = (i1 + i) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeBST(nums, i, mid - 1);
        root.right = makeBST(nums, mid + 1, i1);
        return root;
    }

    /**109
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> values = new ArrayList<>();
        while (head!= null) {
            values.add(head.val);
            head = head.next;
        }
        int[] param = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            param[i] = values.get(i);
        }
        return sortedArrayToBST(param);
    }

    /**653
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> set = new HashMap();
        mid(root, set);
        for (Map.Entry<Integer, Integer> entry : set.entrySet()) {
            if (entry.getKey() == k - entry.getKey()) {
                if (entry.getValue() > 1) {
                    return true;
                }
            } else if (set.containsKey(k - entry.getKey())) {
                return true;
            }
        }
        return false;
    }

    private void mid(TreeNode root, Map<Integer, Integer> res) {
        if (root == null) {
            return;
        }
        res.merge(root.val, 1, Integer::sum);
        mid(root.left, res);
        mid(root.right, res);
    }


    /**530
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getMinimumDifference(root.left, list);
        list.add(root.val);
        getMinimumDifference(root.right, list);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            if ((list.get(i + 1) - list.get(i)) < min) {
                min = list.get(i + 1) - list.get(i);
            }
        }
        return min;
    }

    private void getMinimumDifference(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        getMinimumDifference(root.left, list);
        list.add(root.val);
        getMinimumDifference(root.right, list);
    }

    /**501
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        preBST(root, map);
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                res.add(entry.getKey());
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void preBST(TreeNode root, Map<Integer, Integer> res) {
        if (root == null) {
            return;
        }
        res.merge(root.val, 1, Integer::sum);
        preBST(root.left, res);
        preBST(root.right, res);
    }

}
