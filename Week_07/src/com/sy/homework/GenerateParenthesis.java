package com.sy.homework;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(0,0,n,"");
        return list;
    }

    public void generate(int left,int right,int n,String s){
        if(left == n && right == n){
            list.add(s);
            return;
        }
        if(left<n){
            generate(left+1,right,n,s+"(");
        }
        if(left>right){
            generate(left,right+1,n,s+")");
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
