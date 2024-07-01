package CSES.WeirdAlgorithm;

import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        System.out.print(n + " ");
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 2 == 1) {
                n = 3 * n + 1;
            }
            System.out.print(n + " ");
        }
        scanner.close();
    }
}
