package com.sy.homework;

import com.sy.homework.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {
    /**
     * 二叉树的最近公共祖先，递归
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        //递归终止条件
        if(root==null || root==p || root==q){
            return root;
        }
        //递归地查找左右子树
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        //满足条件返回
        if(left!=null && right!=null){
            return root;
        }
        return left==null?right:left;
    }

}
