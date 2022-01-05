package pers;

import org.junit.Test;

public class TreeTest {

    @Test
    public void pathSum3() {
        Tree tree = new Tree();
        TreeNode root = new TreeNode(0);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        root.left = root1;
        root.right = root2;
        tree.pathSum3(root, 1);
    }

    @Test
    public void rob() {
        Tree tree = new Tree();
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(1);
        root.left = root1;
        root.right = root2;
        root1.right = root3;
        root2.right = root4;
        tree.rob(root);
    }
}
