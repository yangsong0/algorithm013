package com.sy.homework;

/**
 * @Author: sy
 * @Date: 2020/10/11 19:01
 * @Description:
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if(s==null || s.length()==0){
            return false;
        }
        int i=0,j=s.length()-1;
        while(i<j && s.charAt(i)==s.charAt(j)){
            i++;
            j--;
        }
        if(valid(s,i+1,j)){
            return true;
        }
        if(valid(s,i,j-1)){
            return true;
        }
        return false;
    }
    private boolean valid(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}
