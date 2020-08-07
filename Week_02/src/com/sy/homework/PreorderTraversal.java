package com.sy.homework;

import com.sy.homework.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    /**
     * 前序遍历，递归 根-左-右
     * @param root
     * @return
     */
    public List<Integer> preorder(TreeNode root){
        List<Integer> list=new ArrayList<>();
        preorder(root,list);
        return list;
    }
    public void preorder(TreeNode root,List<Integer> list){
        if(root!=null){
            list.add(root.val);
            preorder(root.left,list);
            preorder(root.right,list);
        }
    }

    public List<Integer> preorder1(TreeNode root){
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode node=stack.pop();
            //先访问根节点
            list.add(node.val);
            //先放右子节点再放左子节点，根据栈的特性先弹出来会是左子节点
            if(node.right!=null){
                //放右子节点
                stack.push(node.right);
            }
            if(node.left!=null){
                //放左子节点
                stack.push(node.left);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root=TreeNode.generateATree(new int[]{1,2,3,4,5,6,7});
        System.out.println(new PreorderTraversal().preorder1(root));
    }
}
