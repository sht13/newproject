package com.company;


import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        String[] parentheses=input.split("");
        if(input.length()%2!=0){
            System.out.println("NO");
        }else {
            boolean isTrue=true;
            for (int i = 0; i <parentheses.length/2; i++) {
                stack.push(parentheses[i]);
            }
            for (int i=parentheses.length/2;i<parentheses.length;i++){
                String o=parentheses[i];

               String inStack= stack.pop();
                if(inStack.equals("(") && parentheses[i].equals(")")){
                    continue;
                }else if(inStack.equals("{") && parentheses[i].equals("}")){
                  continue;
                }else if(inStack.equals("[") && parentheses[i].equals("]")) {
                  continue;
                }else {
                    System.out.println("NO");
                    isTrue=false;
                    break;
                }
            }
            if(isTrue){
                System.out.println("YES");
            }
        }
    }
}
