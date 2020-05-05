package com.github.hcsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 *      1
 *      \
 *      2
 *     / \
 *    3  4
 *        \
 *        5
 */

public class BinaryTreeInorderTraversal94 {
    public static List<Integer> inorderNonRecursive(TreeNode root) {
        //
        // 根节点压入栈
        // 栈不为空，循环：
        //   如果当前节点有左子树，
        //      当前节点的左子树入栈，开始下一次循环
        //   如果当前节点没有左子树
        //      访问当前节点
        //      如果当前节点有右子树
        //          当前节点右子树入栈，开始下一轮循环
        //      如果是叶子节点
        //          弹出
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        stack.push(current);

        while (!stack.isEmpty()) {
            while (current.left != null) {
                stack.push(current.left);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.val);

            if (current.right != null) {
                stack.push(current.right);
                current = current.right;
            }
        }
        return result;
    }

    public static void inorderNonRecursive2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.val);

            current = current.right;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);


        node1.right = node2;
        node2.left = node3;
        node2.right = node4;
        node4.right = node5;

        inorderNonRecursive2(node1);
        System.out.println(inorderNonRecursive(node1));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
