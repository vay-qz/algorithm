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
}
