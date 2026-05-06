package Static;

import java.util.Random;

public class StaticClass {

	static int number;        // static is there then same values 


	public static void main(String[] args) {

		StaticClass s1 = new StaticClass();
		s1.number = new Random().nextInt();

		StaticClass s2 = new StaticClass();
		s2.number = new Random().nextInt();

		StaticClass s3 = new StaticClass();
		s3.number = new Random().nextInt();

		StaticClass.number = new Random().nextInt();     //another way



		System.out.println(s1.number);
		System.out.println(s2.number);
		System.out.println(s3.number);

		System.out.println(StaticClass.number);

	}

}
