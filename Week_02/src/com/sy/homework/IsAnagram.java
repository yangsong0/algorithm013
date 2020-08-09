package com.sy.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {
    /**
     * 数组存储次数，适用于字符种类少的情况，如只包含小写字母
     * 思路：先判断字符串长度，若不相等返回false
     * 开一个数组大小为26，存小写字母出现的次数，把第一个字符串中每个字符出现的次数记录在数组中，
     * 再遍历第二个数组，在相应的字符位置作减一操作，若出现小于0 的情况，则一定是两个字符串中有字符不一样了
     * 时间复杂度：O(n)，空间复杂度：O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        //适用于只包含小写字母
        int[] cnts=new int[26];
        for(char ch:s.toCharArray()){
            cnts[ch-'a']++;
        }
        for(char ch:t.toCharArray()){
            cnts[ch-'a']--;
            if(cnts[ch-'a']<0){
                return false;
            }
        }
        return true;
    }

    /**
     * 如果输入字符串包含 unicode 字符，显然用数组是不合理的，因为会使数组太过稀疏
     * 所以自然想到HashMap，把字符都存放在特定区间的下标里，思想和用数组一样
     * 时间复杂度：O(n)，空间复杂度：O(n)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:t.toCharArray()){
            int count = map.getOrDefault(ch,0)-1;
            if(count<0){
                return false;
            }
            map.put(ch,count);
        }
        return true;
    }
}
