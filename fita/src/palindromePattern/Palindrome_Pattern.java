package palindromePattern;

public class Palindrome_Pattern {
	public static void main(String[] args) {
		int n = 5;

		for (int i = 1; i <= n; i++) {

			// 1. Left zeros
			for (int z = 1; z <= n - i; z++) {
				System.out.print("0 ");
			}

			// 2. Increasing numbers
			int num = i;
			for (int j = 1; j <= i; j++) {
				System.out.print(num + " ");
				num++;
			}

			// 3. Decreasing numbers
			num = num - 2;
			for (int j = 1; j < i; j++) {
				System.out.print(num + " ");
				num--;
			}

			// 4. Right zeros
			for (int z = 1; z <= n - i; z++) {
				System.out.print("0 ");
			}

			System.out.println();
		}
	}
}

