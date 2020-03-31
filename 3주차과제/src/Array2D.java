public class Array2D {
    public static void main(String[] args) {

        int Number [][] = { {1}, {1,2,3}, {1} ,{1,2,3,4},{1,2} };

        for (int i = 0; i < Number.length; i++) {
            for (int j = 0; j < Number[i].length; j++)
                System.out.print(Number[i][j] + " ");
            System.out.println();
        }
    }
}