package pyramid;

public class PyramidPattern {

	public static void main(String[] args) {
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5-i;j++) {                   
				System.out.print(" ");               // if this line is not given then its a left triangle
			}
			for(int j = 1; j<=i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}



