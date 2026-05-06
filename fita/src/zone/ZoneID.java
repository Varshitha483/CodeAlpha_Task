package zone;
import java.util.Scanner;

public class ZoneID {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Numbers: ");
		n = sc.nextInt();
		int prev = -1;
		System.out.println("Output: ");
		for(int i = 0; i<n; i++) {
			int current = sc.nextInt();
			if (i == 0 || current != prev) {
				System.out.println(current);
				prev = current;
			}
		}
		sc.close();
	}

}
