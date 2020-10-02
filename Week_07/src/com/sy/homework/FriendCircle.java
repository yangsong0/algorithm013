package com.sy.homework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/friend-circles/
 */
public class FriendCircle {
    /**
     * 广度优先遍历，使用队列
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<M.length;i++){
            if(visited[i]==0){
                queue.add(i);
                while(!queue.isEmpty()){
                    int s = queue.remove();
                    visited[s] = 1;
                    for(int j=0;j<M.length;j++) {
                        if (M[s][j] == 1 && visited[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[][] M = new int[][]{
                {1,1,0},
                {1,1,1},
                {0,1,1}
        };
        System.out.println(new FriendCircle().findCircleNum(M));
    }
}
