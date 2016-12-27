package com.company;

import java.util.Scanner;
import java.util.Stack;

public class StackFibonacci {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        stack.push(1);
        stack.push(1);
        while (true) {
            int num1=stack.pop();
            int num2=stack.peek();
            stack.push(num1);
            int sum=num1+num2;
            stack.push(sum);
            number--;
            if(number-1==0){
                break;
            }
        }
        System.out.println(stack.pop());
    }
}
