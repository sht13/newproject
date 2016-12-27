package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            String currentLine = "";
            for (int col = 0; col < matrix.get(row).size(); col++) {
                currentLine += matrix.get(row).get(col) + " ";
            }
            System.out.println(currentLine.trim());
        }
    }

    private static ArrayList<ArrayList<Integer>> fillMatrix(Integer rows, Integer cols) {
        ArrayList<ArrayList<Integer>> numberMatrix = new ArrayList<ArrayList<Integer>>();
        Integer count = 1;

        for (int row = 0; row < rows; row++) {
            numberMatrix.add(new ArrayList<Integer>());
            for (int col = 0; col < cols; col++) {
                numberMatrix.get(row).add(count);
                count++;
            }
        }
        return numberMatrix;
    }

    private static Integer[] parseArgs(String[] inputArgs) {
        Integer[] parsedResults = new Integer[inputArgs.length];

        for (int i = 0; i < inputArgs.length; i++) {
            parsedResults[i] = Integer.parseInt(inputArgs[i]);
        }

        return parsedResults;
    }

    private static void filterMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            matrix.get(row).removeAll(Arrays.asList((new Integer[]{-1})));
        }
        matrix.removeAll(Arrays.asList(new ArrayList<Integer>()));
    }

    private static boolean isInMatrix(Integer currentRow, Integer currentCol, ArrayList<ArrayList<Integer>> numberMatrix) {
        return currentRow >= 0 && currentRow < numberMatrix.size() && currentCol >= 0 && currentCol < numberMatrix.get(currentRow).size();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(" ");
        Integer[] parsedDimensions = parseArgs(dimensions);

        ArrayList<ArrayList<Integer>> numberMatrix = fillMatrix(parsedDimensions[0], parsedDimensions[1]);

        String[] commandArgs = scanner.nextLine().split(" ");

        while (!String.join(" ", commandArgs).equals("Nuke it from orbit")) {

            Integer[] parsedArgs = parseArgs(commandArgs);
            Integer shotRow = parsedArgs[0];
            Integer shotCol = parsedArgs[1];
            Integer shotRadius = parsedArgs[2];

            for (Integer currentRow = shotRow - shotRadius; currentRow <= shotRow + shotRadius; currentRow++) {
                if (isInMatrix(currentRow, shotCol, numberMatrix)) {
                    numberMatrix.get(currentRow).set(shotCol, -1);
                }
            }

            for (Integer currentCol = shotCol - shotRadius; currentCol <= shotCol + shotRadius; currentCol++) {
                if (isInMatrix(shotRow, currentCol, numberMatrix)) {
                    numberMatrix.get(shotRow).set(currentCol, -1);
                }
            }

            filterMatrix(numberMatrix);
            commandArgs = scanner.nextLine().split(" ");
        }
        printMatrix(numberMatrix);
    }

}
