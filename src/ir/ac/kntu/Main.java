package ir.ac.kntu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Matrix matrixA = readMatrix("a.txt");
        Matrix matrixB = readMatrix("b.txt");
        printMatrix(kroneckerProduct(matrixA, matrixB));
    }


    private static Matrix readMatrix(String fileName) {
        int[][] array;
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            int width;
            int height;
            if (!scanner.hasNextLine()) {
                System.out.println("wrong form!!!!");
                return null;
            }
            width = scanner.nextInt();
            height = scanner.nextInt();
            array = new int[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    array[i][j] = scanner.nextInt();
                }
            }
            return new Matrix(width, height, array);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            return null;
        }
    }

    private static void printMatrix(Matrix matrix) {
        int[][] array = matrix.array;
        for (int i = 0; i < matrix.getHeight(); i++) {
            for (int j = 0; j < matrix.getWidth(); j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    private static Matrix kroneckerProduct(Matrix a, Matrix b) {
        int width = a.getWidth() * b.getWidth();
        int height = a.getHeight() * b.getHeight();
        int[][] array = new int[height][width];
        for (int m = 0; m < a.getHeight(); m++) {
            for (int n = 0; n < a.getWidth(); n++) {
                for (int p = 0; p < b.getHeight(); p++) {
                    for (int q = 0; q < b.getWidth(); q++) {
                        array[m * b.getHeight() + p][n * b.getWidth() + q] = a.array[m][n] * b.array[p][q];
                    }
                }
            }
        }
        return new Matrix(width, height, array);
    }
}

