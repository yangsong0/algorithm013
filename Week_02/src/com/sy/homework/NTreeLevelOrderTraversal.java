package com.sy.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class NTreeLevelOrderTraversal {
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

    /**
     * N叉树的层序遍历，和二叉树类似，将节点按顺序往Queue里放即可
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> lists = new ArrayList<>();
        if(root==null){
            return lists;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        //下一行节点个数，当前初始状态处于根节点的上一层
        int nextCount=1;
        //当前行节点个数
        int curCount=0;
        while(!queue.isEmpty()){
            //往下走一行
            curCount = nextCount;
            nextCount = 0;
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<curCount;i++){
                Node node = queue.poll();
                list.add(node.val);
                if(node.children!=null){
                    //将每个子节点放入队列
                    for(Node child:node.children){
                        queue.offer(child);
                        nextCount++;
                    }
                }
            }
            lists.add(list);
        }
        return lists;
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
        System.out.println(new NTreeLevelOrderTraversal().levelOrder(node1));
    }
}
