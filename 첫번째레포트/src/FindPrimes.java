public class FindPrimes
{
    public static boolean isPrime(int x)
    {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        int currentNumber = 2;
        int primesCount = 0;

        while (primesCount < 50) {
            if (isPrime(currentNumber)) {
                primesCount++;

                System.out.print (currentNumber + " ");
                if (primesCount % 10 == 0) {
                    System.out.println();
                }
            }

            currentNumber++;
        }
    }
}