package palindrome;

public class PalindromeCheck {
	public static void main(String[] args) {
	int num = 123;
	int original = num;
	int reverse = 0;

	while (num > 0) {
	    reverse = reverse * 10 + (num % 10);
	    num = num / 10;
	}

	if (original == reverse) {
	    System.out.println("Palindrome");
	} 
	else {
	    System.out.println("Not Palindrome");
	}
	}
}
