package fibonacci;

public class Fibonacci_problrm {

	public static void main(String[] args) {
		int a = 0;
		int b = 1;
		int n = 10;
		System.out.println(a);
		for(int i = 1; i<n; i++) {                   // if int i = 0 then it prints upto 54
			System.out.println(b);
			int sum = a+b;
			a = b;
			b = sum;
		}
	}

}
