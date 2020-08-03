package com.sy.practice;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class No20_ValidParentheses {
    public boolean isValid(String s){
        Map<Character,Character> map=new HashMap<>(4);
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Deque<Character> stack=new LinkedList<>();
        for(char ch:s.toCharArray()){
            if(map.containsKey(ch)){
                char top=stack.isEmpty()?'#':stack.pollLast();
                if(top!=map.get(ch)){
                    return false;
                }
            }else{
                stack.offerLast(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new No20_ValidParentheses().isValid("(){}[{}]"));
    }
}
