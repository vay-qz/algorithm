package pers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author qiaozhe
 * @date 2022/1/10
 */
public class BSTTreeTest {
    BSTTree bstTree = new BSTTree();

    @Test
    public void convertBST() {
        TreeNode root = new TreeNode(4);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(6);
        TreeNode root3 = new TreeNode(0);
        TreeNode root4 = new TreeNode(2);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(7);
        TreeNode root7 = new TreeNode(3);
        TreeNode root8 = new TreeNode(8);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root2.left = root5;
        root2.right = root6;
        root4.right = root7;
        root6.right = root8;
        bstTree.convertBST(root);
    }
}