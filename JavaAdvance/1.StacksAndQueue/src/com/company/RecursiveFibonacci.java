package com.company;


import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt();

        //with Memoization
        fibArray[0]=1;
        fibArray[1]=1;
        System.out.println(fibonacci(number));
    }
    private static int fibArray[]=new int[26];

    private static int fibonacci(int n){
        int fibValue=0;
        if(n==0 ){
            return 0;
        }else if(n==1){
            return 1;
        }else if(fibArray[(int)n]!=0){
            return fibArray[(int)n];
        }else{
            fibValue=fibonacci(n-1)+fibonacci(n-2);
            fibArray[(int) n]=fibValue;
            return fibValue;
        }
    }
}
