package com.sy.homework;

public class Pow {
    /**
     * 数值的整数次方
     * @param base
     * @param
     * @return
     */
    public double power(double base,int n){
        return mypower(base, n);
    }

    private double mypower(double base, long exp) {
        if(exp==0){
            return 1;
        }
        if(exp<0){
            exp=-exp;
            base=1/base;
        }

        double res = mypower(base,exp>>1);
        //exp是偶数
        if((exp&1)==0){
            res*=res;
        }else{
            //exp是奇数
            res*=res*base;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Pow().power(2, 7));
    }
}
