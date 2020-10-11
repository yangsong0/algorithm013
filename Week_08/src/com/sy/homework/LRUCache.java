package com.sy.homework;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class ListNode{
        private int key,val;
        private ListNode next,prev;
        public ListNode(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    private ListNode head,tail;
    private Map<Integer,ListNode> map;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.next = null;
        head.prev = null;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        ListNode node = map.get(key);
        remove(node);
        insertHead(node);
        return node.val;
    }

    private void insertHead(ListNode node) {
        ListNode next = head.next;
        next.prev = node;
        head.next = node;
        node.prev = head;
        node.next = next;
    }

    private void remove(ListNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            remove(node);
            insertHead(node);
            node.val = value;
        }else{
            ListNode node = new ListNode(key,value);
            if(map.size() >= capacity){
                ListNode rm = tail.prev;
                remove(rm);
                map.remove(rm.key);
            }
            insertHead(node);
            map.put(key,node);
        }
    }
}
