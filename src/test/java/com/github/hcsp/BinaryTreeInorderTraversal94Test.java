package com.github.hcsp;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Arrays;


public class BinaryTreeInorderTraversal94Test {

    BinaryTreeInorderTraversal94.TreeNode node1 = new BinaryTreeInorderTraversal94.TreeNode(1);
    BinaryTreeInorderTraversal94.TreeNode node2 = new BinaryTreeInorderTraversal94.TreeNode(2);
    BinaryTreeInorderTraversal94.TreeNode node3 = new BinaryTreeInorderTraversal94.TreeNode(3);
    BinaryTreeInorderTraversal94.TreeNode node4 = new BinaryTreeInorderTraversal94.TreeNode(4);
    BinaryTreeInorderTraversal94.TreeNode node5 = new BinaryTreeInorderTraversal94.TreeNode(5);
    BinaryTreeInorderTraversal94.TreeNode node6 = new BinaryTreeInorderTraversal94.TreeNode(6);

    {
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;
    }

    @Test
    public void testInorderNonRecursive() {
        Assertions.assertTrue(BinaryTreeInorderTraversal94.inorderNonRecursive(node1).equals(Arrays.asList(4, 2, 5, 1, 3, 6)));
    }
}