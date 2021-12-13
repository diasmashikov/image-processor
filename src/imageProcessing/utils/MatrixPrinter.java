package imageProcessing.utils;

// Matrix printer prints matrix representations in the console
public class MatrixPrinter {
    public static void printMatrix(double[][] matrix) {
        for(int row = 0; row < matrix.length; row++) {
            System.out.print(matrix[row][0]);
            for(int column = 1; column < matrix[0].length; column++) {
                System.out.print("\t " + matrix[row][column]);
            }
            System.out.println();
        }
        System.out.println();

    }



}
