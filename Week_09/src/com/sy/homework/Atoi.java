package com.sy.homework;

/**
 * @Author: sy
 * @Date: 2020/10/11 19:13
 * @Description:
 */
public class Atoi {
    public int myAtoi(String str) {
        int n;
        if(str==null || (n=str.length())==0){
            return 0;
        }
        char[] chars = str.toCharArray();
        int index=0;
        while(index<n && chars[index]==' '){
            index++;
        }
        if(index==n){
            return 0;
        }
        boolean isNegative=false;
        if(chars[index]=='+'){
            index++;
        }else if(chars[index]=='-'){
            isNegative = true;
            index++;
        }
        int res = 0;
        while(index<n && chars[index]>='0' && chars[index]<='9'){
            int num = chars[index] - '0';
            if(res> (Integer.MAX_VALUE-num)/10){
                return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            res = res*10 + num;
            index++;
        }
        return isNegative?-res:res;
    }
}
