import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x;
        int y;
        Scanner sc = new Scanner(System.in);
        System.out.println("Внесите размеры массива");
        x = sc.nextInt();
        y = sc.nextInt();
        String[][] massiv = new String[x][y];
        try {
            array(massiv, sc, x, y);
            System.out.println("Сумма: " + +sumArray(massiv, x, y));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static void array(String[][] array, Scanner sc, int x, int y) {
        if (x != 4 || y != 4) throw new MyArraySizeException();
        System.out.println("Внесите значения массива");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                array[i][j] = sc.next();
            }
        }
        printArray(array);
        sumArray(array, x, y);
    }

    private static int sumArray(String[][] array, int x, int y) {
        int sum = 0;
        int[][] arrayInt = new int[x][y];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    arrayInt[i][j] = Integer.parseInt(array[i][j]);
                    sum += arrayInt[i][j];
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException();
                }
            }
        }
        printArrayInt(arrayInt);
        return sum;
    }

    private static void printArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    private static void printArrayInt(int[][] array) {
        System.out.println("Массив ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
