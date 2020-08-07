package com.sy.homework;

import com.sy.homework.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NTreePreorderTraversal {
    private static class Node{
        int val;
        List<Node> children;
        public Node(int val){
            this.val=val;
        }
        public Node(int val,List<Node> children){
            this.val=val;
            this.children=children;
        }
    }

    public List<Integer> preorder(Node root){
        List<Integer> list=new ArrayList<>();
        dfs(root,list);
        return list;
    }
    public void dfs(Node root,List<Integer> list){
        if(root==null) {
            return;
        }
        list.add(root.val);
        if(root.children!=null){
            for(Node node:root.children){
                dfs(node,list);
            }
        }
    }

    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        List<Node> children1=new ArrayList<>();
        children1.add(node3);
        children1.add(node2);
        children1.add(node4);
        List<Node> children3=new ArrayList<>();
        children3.add(node5);
        children3.add(node6);
        node1.children=children1;
        node3.children=children3;

        System.out.println(new NTreePreorderTraversal().preorder(node1));
    }
}
