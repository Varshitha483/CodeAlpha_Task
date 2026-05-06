package varshitha;

public class Varshitha_Pattern {
    public static void main(String[] args) {

        int n = 5;

        for (int i = 1; i <= n; i++) {

            // V
            for (int j = 1; j <= n; j++) {
                if ((j == 1 && i < n) || (j == n && i < n) || (i == n && j == (n / 2) + 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("   ");

            // A
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == 3 || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("   ");

            // R
            for (int j = 1; j <= n; j++) {
                if (j == 1 || i == 1 || i == 3 || (j == n && i <= 3) || (i - j == 2)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("   ");

            // S
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == 3 || i == n || (j == 1 && i < 3) || (j == n && i > 3)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("   ");

            // H
            for (int j = 1; j <= n; j++) {
                if (j == 1 || j == n || i == 3) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("   ");

            // I
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 3) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("   ");

            // T
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 3) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("   ");

            // H
            for (int j = 1; j <= n; j++) {
                if (j == 1 || j == n || i == 3) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("   ");

            // A
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == 3 || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
