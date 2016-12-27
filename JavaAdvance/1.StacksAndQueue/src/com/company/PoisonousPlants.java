package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PoisonousPlants {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        List<Integer> plants=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            int poison=scanner.nextInt();
            plants.add(poison);
        }
        Stack<Integer> proximityStack = new Stack<>();
        int[] days = new int[plants.size()];
        proximityStack.push(0);
        for (int x = 1; x < plants.size(); x++) {
            int maxDays = 0;
            while (proximityStack.size() > 0 && plants.get(proximityStack.peek()) >= plants.get(x)) {

                maxDays = Integer.max(days[proximityStack.pop()], maxDays);
            }

            if (proximityStack.size() > 0) {
                days[x] = maxDays + 1;
            }

            proximityStack.push(x);
        }

        System.out.printf("%d%n",days[days.length-1]);
    }



}

