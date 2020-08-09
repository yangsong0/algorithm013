package com.sy.homework;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {
    /**
     * 使用HashMap存储，键是String，值是List<String>，将排序后的字符串作为键，遍历整个数组，将原始str加到list即可
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> lists=new ArrayList<>();
        if(strs==null || strs.length==0){
            return lists;
        }
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            String sortedStr=sortStr(str);
            if(!map.containsKey(sortedStr)){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr,list);
            }else{
                map.get(sortedStr).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    private String sortStr(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
