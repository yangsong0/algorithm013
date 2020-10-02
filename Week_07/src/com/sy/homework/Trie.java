package com.sy.homework;

/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree
 */
public class Trie {
    class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public void put(char ch) {
            links[ch - 'a'] = new TrieNode();
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }

    private TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)){
                node.put(currentChar);
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }
    public boolean startsWith(String prefix){
        return searchPrefix(prefix)!=null;
    }
    public boolean search(String word){
        TrieNode node;
        return (node=searchPrefix(word))!=null && node.isEnd();
    }

    private TrieNode searchPrefix(String prefix){
        TrieNode node = root;
        for(int i=0;i<prefix.length();i++){
            char currentChar = prefix.charAt(i);
            if(node.containsKey(currentChar)){
                node = node.get(currentChar);
            }else{
                return null;
            }
        }
        return node;
    }
}
