import java.util.Scanner;

public class Matrix {
    private final double[][] matrix;

    public Matrix(int rows, int cols) {
       matrix = new double[rows][cols];
    }

    public void setElement(int row, int column, double value) {

        matrix[row][column] = value;
    }

    public double getElement(int row, int column) {

        return matrix[row][column];
    }

    public int getRowsNum() {
        return matrix.length;
    }

    public int getColumnsNum() {
        return matrix[0].length;
    }
    public static Matrix input(Matrix matrix) {
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < matrix.getRowsNum(); ++i) {
            System.out.print("Input row number: "+ (i+1)+ "\n");

            for (int j = 0; j < matrix.getColumnsNum(); ++j) {
                System.out.print("Input col number: "+ (j+1)+ " ");
                matrix.setElement(i, j, (double) (in.nextDouble()));
            }

            System.out.print("\n");
        }
        return matrix;
    }

    public static void print(Matrix matrix) {
        int rows = matrix.getRowsNum();
        int cols = matrix.getColumnsNum();
        System.out.println("Matrix dimensions: [" + rows + "; " + cols + "]");
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                System.out.print(matrix.getElement(i, j) + " ");
            }
            System.out.println();
        }
    }

    public Matrix addition(Matrix summand) {

        int thisRows = getRowsNum();
        int thisCols = getColumnsNum();

        int otherRows = summand.getRowsNum();
        int otherCols = summand.getColumnsNum();
        if ((thisCols != otherCols)||(thisRows !=otherRows)) {
            throw new IllegalArgumentException(" Matrices must be equal to the dimension ");
        }
        Matrix result = new Matrix(thisRows, thisCols);

        for (int thisRow = 0; thisRow < thisRows; ++thisRow)
            for (int thisCol = 0; thisCol < thisCols; ++thisCol)

                    result.matrix[thisRow][thisCol] += matrix[thisRow][thisCol]
                            + summand.getElement(thisRow, thisCol);


        return result;
    }

    public Matrix multiply(Matrix multiplier) {

        int thisRows = getRowsNum();
        int thisCols = getColumnsNum();

        int otherRows = multiplier.getRowsNum();
        int otherCols = multiplier.getColumnsNum();
        if (thisCols != otherRows) {
            throw new IllegalArgumentException(" The number of columns m1 should be equal to the number of rows m2 ");
        }
        Matrix result = new Matrix(thisRows, otherCols);

        for (int thisRow = 0; thisRow < thisRows; ++thisRow)
            for (int otherCol = 0; otherCol < otherCols; ++otherCol)
                for (int thisCol = 0; thisCol < thisCols; ++thisCol) {
                    result.matrix[thisRow][otherCol] += matrix[thisRow][thisCol]
                            * multiplier.getElement(thisCol, otherCol);
                }

        return result;
    }

    public Matrix transposition(){
        int thisRows = getRowsNum();
        int thisCols = getColumnsNum();


        Matrix result = new Matrix(thisCols, thisRows);
        for (int thisRow = 0; thisRow < thisRows; thisRow++) {
            for (int thisCol = 0; thisCol < thisCols; thisCol++) {
                result.matrix[thisCol][thisRow] = matrix[thisRow][thisCol];
             }
        }
        return result;
    }

}
