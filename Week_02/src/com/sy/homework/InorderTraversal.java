package com.sy.homework;

import com.sy.homework.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
public class InorderTraversal {
    /**
     * 递归法 左-根-右
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;
    }
    public void inorder(TreeNode root,List<Integer> list){
        if(root!=null){
            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);
        }
    }

    /**
     * 非递归，使用栈
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root){
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;
        while(!stack.empty() || p!=null){
            //找到最左叶子节点
            while(p!=null){
                stack.push(p);
                p=p.left;
            }
            //到达最左节点，开始出栈
            if(!stack.empty()){
                p=stack.pop();
                //添加根节点
                list.add(p.val);
                //访问右子节点
                p=p.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root=TreeNode.generateATree(new int[]{1,2,3,4,5,6,7});
        System.out.println(new InorderTraversal().inorderTraversal1(root));
    }
}
