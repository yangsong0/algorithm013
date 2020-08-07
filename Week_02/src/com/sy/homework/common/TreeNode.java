package com.sy.homework.common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val=val;
    }

    /**
     *       1       1 2 3 4 5 6
     *     2   3
     *    4 5 6
     * 按照层序遍历构建一棵完全二叉树
     * @return
     */
    public static TreeNode generateATree(int[] arr){
        int len;
        if(arr==null || (len=arr.length)==0){
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode root=new TreeNode(arr[0]);
        queue.offer(root);
        //循环到最后一个非叶子节点
        for(int i=0;i<len/2;i++) {
            TreeNode temp = queue.poll();
            int leftIndex = i * 2 + 1;
            int rightIndex = i * 2 + 2;
            if (rightIndex < len) {
                TreeNode left = new TreeNode(arr[leftIndex]);
                TreeNode right = new TreeNode(arr[rightIndex]);
                temp.left = left;
                temp.right = right;
                queue.offer(left);
                queue.offer(right);
            } else if (leftIndex < len) {
                TreeNode left = new TreeNode(arr[leftIndex]);
                temp.left = left;
                temp.right = null;
                queue.offer(left);
            } else {
                temp.left = null;
                temp.right = null;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root=generateATree(new int[]{1,2,3,4,5,6});

    }
}
