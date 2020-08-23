package com.sy.homework;

/**
 * https://leetcode-cn.com/problems/lemonade-change/
 */
public class LemonageChange {
    /**
     * 柠檬水找零
     * 贪心算法，先给顾客找10块，10块不够了再找五块，五块也不够就返回false
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (ten == 0) {
                    if (five < 3) {
                        return false;
                    } else {
                        five -= 3;
                    }
                } else {
                    if (five < 1) {
                        return false;
                    } else {
                        five--;
                        ten--;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LemonageChange().lemonadeChange(new int[]{5, 5, 5, 10, 20}));
    }
}
