class Average {
    public static int average(int[] array) {
        int Array[] = array;
        int sum = 0;

        for (int i = 0; i < Array.length; i++)
            sum += Array[i];

        return sum / Array.length;
    }

    public double average(double[] array) {
        double Array[] = array;
        double sum = 0;

        for (int i = 0; i < Array.length; i++)
            sum += Array[i];

        return sum / Array.length;
    }
}

public class AverageA {

    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5, 6};
        double arr2[] = {6.0, 4.4, 1.9, 2.9, 3.4, 3.5};
        Average a = new Average();

        System.out.println("{1,2,3,4,5,6}의 평균값 = " + Average.average(arr1));
        System.out.println("{6.0, 4.4, 1.9, 2.9, 3.4, 3.5} 의 평균값 = " + a.average(arr2));

    }
}
