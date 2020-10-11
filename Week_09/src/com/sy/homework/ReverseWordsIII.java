package com.sy.homework;

/**
 * @Author: sy
 * @Date: 2020/10/11 17:54
 * @Description:
 */
public class ReverseWordsIII {
    public String reverseWords(String s) {
        if(s==null || s.length()<2){
            return s;
        }
        s = s.trim();
        char[] chars = s.toCharArray();
        int start=0,end=0;
        while(start<chars.length){
            while(end<chars.length && chars[end]!=' '){
                end++;
            }

            reverseStr(chars,start,end-1);
            start=++end;
        }
        return String.valueOf(chars);
    }

    private void reverseStr(char[] chars,int i,int j){
        while(i<j){
            char temp = chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsIII().reverseWords("Let's take LeetCode contest"));
    }
}
