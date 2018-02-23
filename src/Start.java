public class Start {
    public static void main(String[] args){
        Matrix m1 = new Matrix(2, 2);


        System.out.println("Input matrix - m1, dimensions: [" + m1.getRowsNum() + "; " + m1.getColumnsNum() + "]");

//        Matrix.input(m1);

        m1.setElement(0, 0, 4);
        m1.setElement(0, 1, 2);

        m1.setElement(1, 0, 9);
        m1.setElement(1, 1, 0);

        Matrix.print(m1);

        Matrix m2 = new Matrix(2, 2);


        System.out.println("Input matrix - m2, dimensions: [" + m2.getRowsNum() + "; " + m2.getColumnsNum() + "]");

//        Matrix.input(m2);
        m2.setElement(0, 0, 3);
        m2.setElement(0, 1, 1);

        m2.setElement(1, 0, -3);
        m2.setElement(1, 1, 4);

        Matrix.print(m2);

        System.out.println("addition");
        Matrix sum = m1.addition(m2);
        Matrix.print(sum);

        System.out.println("multiply");
        Matrix mult = m1.multiply(m2);
        Matrix.print(mult);

        System.out.println("transposition");
        Matrix trunsp = mult.transposition();
        Matrix.print(trunsp);

    }
}


