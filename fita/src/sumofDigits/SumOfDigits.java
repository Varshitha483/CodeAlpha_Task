package sumofDigits;

public class SumOfDigits {
	public static void main(String[] args) {
		int n = 236;
		int sum = 0;
		while(n>0) {
			sum = sum + n % 10;
			n = n/10;
		}
		System.out.println(sum);
	}
}

// n = 236
// n % 10 = 6
// sum = sum + n % 10   ---->   sum = 0 + 6 = 6
// n = n / 10   ---->    n = 236 / 10 = 23 (no decimal)


// n = 23
// n % 10 = 3
// sum = sum + n % 10   ---->   sum = 6 + 3 = 9
// n = n / 10   ---->    n = 23 / 10 = 2 (no decimal)


// n = 2
// n % 10 = 2
// sum = sum + n % 10   ---->   sum = 9 + 2 = 11
// n = n / 10   ---->    n = 2 / 10 = 0 (no decimal)   // problem ends here

// sum of digits = 11 

