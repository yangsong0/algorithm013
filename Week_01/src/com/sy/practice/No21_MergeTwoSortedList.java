package com.sy.practice;

import com.sy.practice.common.ListNode;

import java.util.Arrays;

/**
 * 合并两个有序链表
 */
public class No21_MergeTwoSortedList {
    /**
     * 非递归法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null || l2==null){
            return l1==null?l2:l1;
        }
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next=l1==null?l2:l1;
        return dummy.next;
    }

    /**
     * 递归法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsRec(ListNode l1,ListNode l2){
        if(l1==null || l2==null){
            return l1==null?l2:l1;
        }
        ListNode temp=null;
        if(l1.val < l2.val){
            temp=l1;
            temp.next=mergeTwoListsRec(l1.next,l2);
        }else{
            temp=l2;
            temp.next=mergeTwoListsRec(l1,l2.next);
        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode l1=ListNode.generateList(Arrays.asList(1,2,4));
        ListNode l2=ListNode.generateList(Arrays.asList(1,3,4));
        ListNode mergedHead = new No21_MergeTwoSortedList().mergeTwoListsRec(l1,l2);
        System.out.println(ListNode.printList(mergedHead));
    }
}
