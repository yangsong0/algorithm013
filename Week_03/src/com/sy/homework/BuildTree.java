package com.sy.homework;

import com.sy.homework.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder,int[] inorder){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return reconstruct(preorder,0,preorder.length-1,0,map);
    }

    private TreeNode reconstruct(int[] preorder, int preL, int preR, int inL, Map<Integer, Integer> map) {
        //递归终止条件，左索引>右索引就退出
        if(preL>preR){
            return null;
        }
        //前序遍历 根-左-右 每次创建出一个根节点
        TreeNode root=new TreeNode(preorder[preL]);
        //根据前序中序，以根节点为中心将中序序列分为两部分
        int index=map.get(preorder[preL]);
        int leftSize=index-inL;
        //重新划分左右界限，构造左右子树
        root.left=reconstruct(preorder,preL+1,preL+leftSize,inL,map);
        root.right=reconstruct(preorder,preL+leftSize+1,preR,inL+leftSize+1,map);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder=new int[]{3,9,20,15,7};
        int[] inorder=new int[]{9,3,15,20,7};
        TreeNode treeNode = new BuildTree().buildTree(preorder, inorder);
        System.out.println(TreeNode.levelOrder(treeNode));
    }
}
