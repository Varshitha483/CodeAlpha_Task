package star;

public class StarPattern {

	public static void main(String[] args) {
		for (int i=1; i<=3;i++) {                      // if i=0 then it prints 4 rows
			for(int j=1;j<=4;j++) {                    // if j=0 then it prints 5 rows
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}


// i -----> rows
// i -----> columns