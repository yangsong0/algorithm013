package com.sy.practice.common;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val=val;
    }

    public static ListNode generateList(List<Integer> list){
        ListNode dummy = new ListNode(-1);
        ListNode cur=dummy;
        for(Integer num:list){
            cur.next=new ListNode(num);
            cur=cur.next;
        }
        return dummy.next;
    }

    public static List<Integer> printList(ListNode head){
        ListNode node=head;
        List<Integer> list=new ArrayList<>();
        while(node != null){
            list.add(node.val);
            node=node.next;
        }
        return list;
    }
}
